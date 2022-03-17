"use strict"

  var titleInput = $("#x-title-input");
  titleInput.css("display", "none");

  var tbody = $("#x-todo-table tbody");

  $("#x-todo-input").onkeyup = function(e) {
    if (e.keyCode == 27) {
      e.target.value = "";

    } else if (e.keyCode == 13) {
      if ($(e.target).val() == "") {
       Swal.fire("필수 입력 항목이 비어 있습니다.");
        return;
      }

      fetch(`/todo/add?title=${e.target.value}`)
        .then(function(response) {
          return response.text();
        })
        .then(function(text) {
          console.log(text);
          location.reload();
        });
    }
  };

  fetch("/todo/list")
    .then(function(response) {
      return response.json();
    })
    .then(function(todoList) {
      console.log(todoList);
      for (var todo of todoList) {
        var tr = document.createElement("tr");
        tr.setAttribute("data-no", todo.no);
        var checkedOption = "";
        var titleTdOption = "";
        if (todo.done) {
          checkedOption = "checked";
          titleTdOption = "class='todo-checked'";
        }
        tr.innerHTML = `<td><input type="checkbox" ${checkedOption} onchange="checkTodo(${todo.no}, event.target.checked)"></td>
        <td class="todo-title"><span ${titleTdOption}>${todo.title}</span></td>
        <td><button type="button" class =btn onclick="updateTodo(${todo.no})">변경</button></td>
        <td><button type="button" onclick="deleteTodo(${todo.no})">삭제</button></td>`;
        tbody.appendChild(tr);
      }
      $("#x-todo-input").focus();
    });

 function deleteTodo(no) {
   fetch(`/todo/delete?no=${no}`)
     .then(function(response) {
       return response.json();
     })
     .then(function(result) {
       if (result == 0) {
         window.alert("삭제하지 못했습니다!");
       } else {
         location.reload();
       }
     });
 }

 function checkTodo(no, checked) {
   console.log(no, checked);
   fetch(`/todo/check?no=${no}&done=${checked}`)
     .then(function(response) {
       return response.json();
     })
     .then(function(result) {
       if (result == 0) {
         window.alert("변경하지 못했습니다!");
       } else {
         var titleSpan = $(`tr[data-no="${no}"] > td.todo-title > span`);
         if (checked) {
           titleSpan.classList.add("todo-checked");
         } else {
           titleSpan.classList.remove("todo-checked")
         }
       }
     });
 }

 function updateTodo(no) {
   // 현재 Todo 항목을 편집 중인 상태에서 변경 버튼을 눌렀다면
  // console.log(titleInput.parent()) 
   //console.log(titleInput.parent() instanceof HTMLTableCellElement)
   if (titleInput.parent()[0] instanceof HTMLTableCellElement) { //부모가 여러명 jquery의 parent가 배열을 리턴한다. 
     // 다른 항목을 편집하기 위해 이동하기 전에 편집 전의 상태로 되돌린다.
     titleInput.parent()[0].find("span").css("display", "");
   }
   var titleTd = $(`tr[data-no="${no}"] > td.todo-title`);
   var titleSpan = titleTd.find("span");
   titleSpan.css( "display", "none" );
   titleInput.val( titleSpan.html() );
   titleInput.attr("data-no", no);
   titleTd.appendChild(titleInput);
   titleInput.css("display", "");
 }

 titleInput.onkeyup = function(e) {
   var no = titleInput.getAttribute("data-no");
   var titleSpan = titleInput.parentNode.querySelector("span");
   var originTitle = titleSpan.innerHTML;

   if (e.keyCode == 27) { // ESC 키를 눌러 편집을 취소한다면
     cancelTodoEditing();
   } else if (e.keyCode == 13 && titleInput.value != "" && originTitle != titleInput.val()) {
     fetch(`/todo/update?no=${no}&title=${titleInput.value}`)
       .then(function(response) {
         return response.json();
       })
       .then(function(result) {
         if (result == 0) {
           window.alert("변경하지 못했습니다!");
         } else {
           console.log("변경했습니다.");
           titleSpan.innerHTML = titleInput.value;
           cancelTodoEditing();
         }
       });
   }
 };

 function cancelTodoEditing() {
   titleInput.parentNode.querySelector("span").style["display"] = "";
   titleInput.style["display"] = "none";
   document.body.appendChild(titleInput);
 }