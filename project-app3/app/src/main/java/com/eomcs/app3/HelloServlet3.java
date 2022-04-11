package com.eomcs.app3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 컨테이너가 실행할 클래스를 만드려면 
//Servlet API 규칙에 따라 작성해야한다. 
//
@SuppressWarnings("serial")
@WebServlet({"/hello3","/hello4"}) // 서블릿컨테이너가 실행할 클래스, 이 클래스를 실행하려면 hello라고 요청해야함 : 서블릿 컨테이너에게 이 클래스가 요청을 처리하는 서블릿임을 알려준다.
public class HelloServlet3 extends HttpServlet { //  가장편한방법 - 그러나 이걸꼭 상속받아서 만드는 방법만 있는게 아님. 인터페이스를 직접 만드는 것보다 상속보다 만드는게 편함


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    System.out.println("서비스호출");

    // HTTP 클라이언트가 name이란 이름으로 보내 온 파라미터 값을 읽는다.
    String name = req.getParameter("name");

    // HTTP 클라이언트에게 보낼 콘텐트의 MIME 타입을 설정한다.
    resp.setContentType("text/plain;charset=UTF-8");

    // HTTP 클라이언트에게 콘텐트를 출력할 도구를 준비한다.
    PrintWriter out = resp.getWriter();

    // HTTP 클라이언트에게 콘텐트를 출력한다.
    out.printf("%s 님 환영합니다!", name);

    //System.out.println(name);
  }

}
