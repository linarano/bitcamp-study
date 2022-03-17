//오리지널을 안쓸만한 이름으로 함수를 정해놓고 
function myQuery(selector, parent) {
  if(typeof(selector) == startWith("<")){
    
  //파라미터 값이 '<' 로 시작한다면 태그를 생성한다.
  var e= document.createElemnt(selector.substring(1, selector.length -1)) // 알멩이만 뺴내자 
    }
   if (typeof(selector)=="string"){
  if(parent !== null){
    //  부모 태그가 지정되어 있으면 그 부모 태그 아래에서 해당 태그를 찾는다. 
  var e = parent.querySelector(selector);
  } else{
    // 부모 태그가 지정되어 있지않으면 HTML  문서 전체에서 조건에 해당하는 태그를 찾는다. 
    var e = document.querySelector(selector);
      }
    } else if (selector instanceof HTMLElement){
      var e = selector; // 오리지널에 태그에 없지만 가공된 태그을 추가 
    }
  }
  }
  //자바스크립트는 블록안에 선언된 변수로 로컬변수임 - 자바처럼 효력을 잃지않음


// 태그의 스타일값 조회 및 설정// 객체에 스타일 설정(함수추가) - 제이쿼리에 있는 것을 모방 
 e.css = function(name, value){
  if(arguments.length == 1){
    return e.style[name];
  }else if (arguments.length ==2)
  e.style[name] = value;
  return e;
};

// 태그 아래에서 다른 태그 찾기 
  e.find = function(selector){
    return myQuery(selector, e);
  };

//  태그의 콘텐트(inner HTML 프로퍼티 값)를 꺼내기 => <태그명>콘텐트</태그명>
e.html = function(content){
  if (arguments.length ==0){
  return e.innerHTML;
 }else if(arguments.length ==1){
  e.innerHTML = content;
return e; 
  }
};


e.val = function (v){
  if(arguments.length == 0){
    return e.value;
  }else{
    e.value = v;
  } // 모든 함수는 빌트인  배열이 들어있다. 
return e; // 리턴하기 때문에 ;  끝내는게 연속호출이 가능해짐  
}
//제이쿼리를 쓰게 되면 이 함수를 호출하게 되는 것 

// 입력 상자의 value 프로퍼티 값을  조회하거나 설정하기(setter/getter : 하나의 함수를 가지고 그때그떄 적용  - 파라미터가 없으면 겟, 파라미터가 있으면 셋으로 동작) 
e.attr = function(name, value){
  if(arguments.length == 1){
    return e.getAttribute(name);
  }else if (arguments.length == 2){
  
    e. setAttrubute(name.value);
}
};

//태그의 부모를 찾아 리턴한다.

e.parent = function(){
return myQuery(e.parentNode); //오리지널 태그가 아닌 가공된 태그를 리턴한다. 왜냐면 우리가 추가한 함수들이 없기때문에
};

//현재 태그를 부모 태그에 자식 태그로 만든다.
e.appendTo = function(parent){
  parent.appendChild(e);
}

//현재 태그에 클래스를 추가한다.
e.addClass = function(name){
  e.classList.add(name);
return e;
}

e.removeClass = function(name){
  e.classList.remeve(name);
  return e;
};


// keyup  이벤트 리스너 등록한다.
 e.keyup = function(listener){
  e.addEventListener("keyup", listener)
      return e;
  
}
return e;
}


var $ = myQuery

//껍데기를 씌워서 간결하게 만들자 
// 변수 자체가 함수 주소를 담는 

// 함수 이름을 2가지로 정의하는 이유 다른사람이 만든 라이브러리에 _ 가 있으면  myQuery를 쓰고, 없으면 간단한걸 써라. 
//자바스크립트는 객체에 언제든 필요한 함수나 변수 추가 가능 (자바는 클래스에 미리 설계 )