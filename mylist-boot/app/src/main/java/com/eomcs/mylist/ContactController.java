package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//이 클래스가 클라이언트 요청 처리 담당자임을 표시
//@애노테이션
public class ContactController {

  String[] contacts = new String[5];
  int size = 0;//배열에 집어넣은 갯수

  @RequestMapping("/contact/list")
  public Object list() {
    String[] arr = new String[size];
    for(int i = 0; i < size; i++) { //배열에 저장된 값만 복사할 새 배열을 만든다
      arr[i] = contacts[i];//전체 배열에서 값이 들어있는 항목만 복사한다.
    }
    return arr; //복사한 배열 항목들을 담고있는 새배열을 리턴한다.
  }

  @RequestMapping("/contact/add")
  public Object  add(String name, String email, String tel, String company) {
    String contact =  name +","+ email + "," + tel + "," + company ;//일반문자열
    //    contacts[size] = contact;
    //    
    //    size++;
    contacts[size++] = contact;
    return size;//몇개 리턴했는지 
  }


  @RequestMapping("/contact/get")
  public Object get (String email) {
    for(int i =0; i < size; i++) {
      if(contacts[i].split(",")[1].equals(email)) {// "ul,ul
        return contacts[i];
      }
    }
    return "";

  }

  @RequestMapping("/contact/update")
  public Object update (String name, String email, String tel, String company) {
    String contact =  name +","+ email + "," + tel + "," + company ;//일반문자열
    for(int i =0; i < size; i++) {
      if(contacts[i].split(",")[1].equals(email)) {// "ul,ul
        contacts[i] = contact;
        return 1;
      }
    }
    return 0; //못찾음, 변경하려는 사이에 해당게시물 삭제되는 경우
  }

  @RequestMapping("/contact/delete")
  public Object delete (String email) {
    for(int i =0; i < size; i++) {
      if(contacts[i].split(",")[1].equals(email)) {// "ul,ul

        //현재 위치의 다음 항목에서 배열 끝까지 반복하며 앞으로 값을 당겨온다.
        for(int j = i+1; j < size; j++) {
          contacts[j - 1] = contacts[j];  
        }
        size--;
        return 1;
      }
    }
    return 0;
  }
}