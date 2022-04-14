package com.eomcs.mylist.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/error") 
public class ErrorServlet extends HttpServlet {

  @Override
  protected void service (HttpServletRequest req, HttpServletResponse resp) //내부 인터페이스에 정의된 서비스가 이 메서드를 호출(서블릿이 호출하는게 아니므로 프로텍트)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8"); // 응답한 데이터 
    PrintWriter out = resp.getWriter();


    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset=\"UTF-8\">");
    out.println("  <title>MyList!</title>");
    out.println("  <link href=\"/css/common.css\" rel=\"stylesheet\">");
    out.println("</head>");
    out.println("<body>");

    out.println("<div class=\"container\">");

    out.println("<div id=\"header\">");
    req.getRequestDispatcher("/header").include(req,resp);

    out.println("</div>");


    out.println("<div id=\"sidebar\">");
    req.getRequestDispatcher("/sidebar").include(req,resp);
    out.println("</div>");

    out.println("<div id=\"content\">");
    out.println("<h1>서버실행 오류!</h1>");

    Exception e = (Exception)req.getAttribute("error");// 요청저장소에 에러 객체를 받아서 
    out.printf("<p>%s</p>\n", e.getMessage());//action='add' 같은 URL요청

    out.println("제목*: <input name=\"title\" type=\"text\" ><br>");
    out.println("내용*: <textarea name=\"content\" cols=\"50\" rows=\"10\"></textarea><br>");//2rorkqtdmf qhsoTek
    out.println("별표(*) 항목은 필수 입력입니다.<br>");
    out.println("<button>등록</button>"); // 서브밋버튼 브라우저가 요청 ()
    out.println("<button id='cancel-btn' type=\"button\">취소</button>");
    out.println("</form>");
    out.println("</div>");

    out.println("<div id=\"footer\">");

    req.getRequestDispatcher("/footer").include(req,resp);

    out.println("</div>");

    out.println("</div>");
    out.println("</body>");
    out.println("</html>");


  }
}






