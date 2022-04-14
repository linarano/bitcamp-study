package com.eomcs.mylist.web.board;

import java.io.IOException;
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
@WebServlet("/board/update") 
public class BoardDeleteServlet extends HttpServlet { 

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

    try {
      Board board = new Board();
      int no = Integer.parseInt(req.getParameter("no"));

      Member loginUser = (Member) req.getSession().getAttribute("loginUser");
      board.setWriter(loginUser);

      boardService.delete(board);

      resp.sendRedirect("list");
    } catch (Exception e) {

      req.setAttribute("exception", e);
      // resp.setContentType("text/html;charset=UTF-8"); //인클루드하는 쪽에서 설정해줘야함
      req.getRequestDispatcher("/error").forward(req,resp);

    }
  }
}
