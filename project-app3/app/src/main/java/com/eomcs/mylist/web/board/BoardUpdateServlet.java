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
@WebServlet("/board/delete") 
public class BoardUpdateServlet extends HttpServlet { 


  BoardService boardService;

  @Override
  public void init() throws ServletException {
    // BoardService 객체를 웹애플리케이션 보관소에서 꺼낸다.
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    boardService = (BoardService) 웹애플리케이션보관소.getAttribute("boardService");
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    // 클라잉너트가 보낸 문자열이 UTF-8로 인코딩 되어 있음을 설정한다.
    // 이 설정이 된 후에 getParameter() 호출해야한다.
    // 그래야만 UTF-8 한글이 온전히 변환될 수 있음 
    req.setCharacterEncoding("UTF-8"); // 요청한 데이터가 UTF-8 , 무조건 클라이언트에서 보낸 데이터는 is0-8859-1아스키코드(영어)라고 간주함 꼭 알려줘야함

    //간 주한 상태에서 utf-16으로 바꾸니까
    // 파라미터에서 꺼내기전에 바꾸는 것 

    Board board = new Board();
    board.setNo(Integer.parseInt(req.getParameter("no"))); // 클라이언트가 보낸 가뵷을 꺼낼 수 있음
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));

    Member loginUser = (Member) req.getSession().getAttribute("loginUser");
    board.setWriter(loginUser);

    boardService.update(board);//업데이트 후 목록으로 가자
    resp.sendRedirect("list");//리스트 페이지를 주는게 아니라 변경헀으니 게시물 목록 페이지를 다시요청하라고 클라이언트에게 명령한다.
  }
}
