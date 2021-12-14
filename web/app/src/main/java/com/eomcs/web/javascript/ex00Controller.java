package com.eomcs.web.javascript;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//클라이언트 요청 클래스임을 선언 스프링부트에게
public class ex00Controller {

  @RequestMapping("/javascript/ex00/exam06")
  public String exam06() {
    return "<ul><li>홍길동</li><li>임꺽정</li><li>유관순</li></ul>";  //데이터가 아니라 UI 조각을 만들어 던진다.(서버렌더링방식)

  }


  @RequestMapping("/javascript/ex00/exam07")
  public Object exam07() {
    String[] names = {"홍길동", "임꺽정", "유관순"};
    return names; //클라이언트에 보내는 것은 UI가 아니라 데이터이다. 

  }
}
