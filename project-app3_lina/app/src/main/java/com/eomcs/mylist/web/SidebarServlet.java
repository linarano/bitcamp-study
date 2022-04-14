package com.eomcs.mylist.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/sidebar") 
public class SidebarServlet extends HttpServlet {

  @Override
  protected void service (HttpServletRequest req, HttpServletResponse resp) //내부 인터페이스에 정의된 서비스가 이 메서드를 호출(서블릿이 호출하는게 아니므로 프로텍트)
      throws ServletException, IOException {
    // GET,POST 요청 모두에 대응할 수 있도록 

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<style>");
    out.println("h1.sidebar {");
    out.println("  font-size: 1.2em;");
    out.println("}");
    out.println("</style>");

    out.println("<h1 class=\"sidebar\">제목</h1>");
    out.println("<div class=\"sidebar\">");
    out.println("<ul>");
    out.println("  <li>내용1</li>");
    out.println("  <li>내용2</li>");
    out.println("  <li>내용3</li>");
    out.println("</ul>");
    out.println("</div>  ");

  }
}






