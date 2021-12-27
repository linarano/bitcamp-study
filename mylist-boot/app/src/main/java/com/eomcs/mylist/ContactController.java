package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ContactController {

  @RequestMapping("/contact/list") // 이 메소드자체는 클라이언트 요청처리
  public Object list() {
    return  ArrayList.toArray();
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {//메소드를 호출하는 스프링부트가 contact - 인스턴스 주소를 저장하는 레퍼런스변수를 넘겨준다.
    // System.out.println(contact); //println이 인스턴스의 주소넘겨주면 toString() 내부적으로 메서드 호출
    ArrayList.add(contact);
    return ArrayList.size;
  }

  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = ArrayList.indexOf(email);
    if (index == -1) {
      return "";
    }

    return ArrayList.contacts[index];
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = ArrayList.indexOf(contact.email);
    if (index == -1) {// 여기서 한번 걸러내지만 밑에 한번더하자 
      return 0;
    }
    return ArrayList.set(index,contact) = null ? 0 : 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = ArrayList.indexOf(email);
    if (index == -1) {
      return 0;
    }

    ArrayList.remove(index);  // 메서드 이름으로 코드의 의미를 짐작할 수 있다. 이것이 메서드로 분리하는 이유이다.
    return 1;
  }

}





