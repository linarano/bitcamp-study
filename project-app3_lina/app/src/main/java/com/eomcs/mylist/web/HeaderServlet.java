package com.eomcs.mylist.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/header") // 루트 빠지면안된다. 
public class HeaderServlet extends HttpServlet {

  // 로그인 로그아웃은 보드서비스가 아니라 멤버서비스를 쓴다.

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException { //오리지널 서비스가 아니라 내부적으로 서비스 오버로딩해서 호출
    // service() 메서드는 GET,POST 요청 모두에 대해 호출된다. Doget() 변경
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<style>");
    out.println("#login-btn {");
    out.println("  position: absolute;");
    out.println("  right: 10px;");
    out.println("}");
    out.println("#logout-btn {");
    out.println("  position: absolute;");
    out.println("  right: 10px;");
    out.println("}");
    out.println("#app-title {");
    out.println("  font-size: 1.5em;");
    out.println("  font-weight: bold;");
    out.println("  font-style: none;");
    out.println("  color: white;");
    out.println("} ");
    out.println("#user-name {");
    out.println("  position: absolute;");
    out.println("  right: 90px;");
    out.println("}");
    out.println("</style>");

    out.println("<a href=\"/index.html\"><span id=\"app-title\">MyList</span></a> ");
    out.println("<button id=\"login-btn\" type=\"button\" class=\"not-login\">로그인</button>");
    out.println("<span id=\"user-name\" class=\"login\"></span>");
    out.println("<button id=\"logout-btn\" type=\"button\" class=\"login\">로그아웃</button>  ");

  }
}






