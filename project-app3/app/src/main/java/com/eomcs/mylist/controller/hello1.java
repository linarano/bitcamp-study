package com.eomcs.mylist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("/hello1")
public class hello1 implements Controller {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/jsp/hello1.jsp"; // 자동객체 생성되서 컴퍼넌트에  url을 주기만 하면된다.
  }
}

// 스프링프레임워크
//클래스를 실행하려면 객체가 생성, 메서드 호출 되는 과정도 자동화


//이제 필요한 컨트럴러 만들고 
// 규칙을 만들면된다.
//인터페이스 구현
//자동생성하면 컴퍼넌트 붙이고
//URL 주면됨

//스프링프레임워크가 프런트컨트럴러가 이미 만들어져있음 - DispatcherServlet : 프런트 컨트럴러가 객체자동생성