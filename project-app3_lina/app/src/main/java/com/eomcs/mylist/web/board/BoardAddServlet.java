package com.eomcs.mylist.web.board;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

// 서블릿 컨테이너가 실행할 클래스를 만드려면 
//Servlet API 규칙에 따라 작성해야한다. 
//
@SuppressWarnings("serial")
@WebServlet("/board/add") 
public class BoardAddServlet extends HttpServlet { 

  BoardService boardService;

  @Override
  public void init() throws ServletException {
    // BoardService 객체를 웹애플리케이션 보관소에서 꺼낸다.
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    boardService = (BoardService) 웹애플리케이션보관소.getAttribute("boardService");
  }


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
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
    out.println("<h1>게시글 등록</h1>");

    out.println("<form  method='post'>");//action='add' 같은 URL요청
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
    out.println("<script>");
    out.println(" document.querySelector('#cancel-btn').onclick = () => { alert('호출')");
    out.println("   location.href = 'list';");
    out.println("</script>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      //      //웹브라우저가 POST 요청으로(GET요청은 안해도된다.) 문자열을 보낼 떄 어떤 문자집합으로 인코딩했는지 알려줘야한다. 
      //      //그래야만 getParameter() 메서드에서 웹브라우저가 보낸 파라미터 값을 올바르게 꺼낼 수 있다.
      //      //즉 웹브라우저에서 웹서버에게 데이터를 보낼 때 UTF-8로 인코딩해서 보낸다.
      //      // 그렇게 인코딩해서 그 보낸 문자열을 자바에서 사용하는 UTF-16으로 바꿔서 리턴하는 것이다. 
      //      //주의!
      //      //반드시 getParameter() 호출하기 전에 설정해야한다.
      //      // 단 한번이라도 getParameter()호출한 후 설정하게 되면 이 설정은 무시된다. 
      //      req.setCharacterEncoding("UTF-8"); // getParameter()호출 전에 먼저 설정해줘야한다.- 그렇지않으면 버그 

      Board board = new Board();
      board.setTitle(req.getParameter("title"));
      board.setContent(req.getParameter("content"));

      Member loginUser = (Member) req.getSession().getAttribute("loginUser");
      board.setWriter(loginUser);

      boardService.add(board);

      resp.sendRedirect("list");//현재 URL board/list를 요청하라고 브라우저에게 이야기함 
    } catch (Exception e){

      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error").forward(req,resp); // 모든 책임을 넘긴다. 다시 리턴


    }
  }
}
