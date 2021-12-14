package com.eomcs.web.javascript;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//클라이언트 요청 클래스임을 선언 스프링부트에게
public class ex01Controller {

  @RequestMapping("/javascript/ex01/exam05_1")
  public Object exam05_1() throws Exception {
    Thread.sleep(10000);//10초동안 기다렸다가 작업을 재개한다.
    return "console.log('okok')"; // 자바스크립트 코드 조각을 리턴

  }


  @RequestMapping("/javascript/ex01/exam05_2")
  public Object exam05_2() {
    return "console.log('nono')"; // 자바스크립트 코드 조각을 리턴
  }


  @RequestMapping("/javascript/ex01/exam05_x")
  public Object exam05_x() throws Exception {
    Thread.sleep(10000);// 데이터베이스 시간걸린다
    return "50000"; //데이터를 리턴한다.
  }
}
