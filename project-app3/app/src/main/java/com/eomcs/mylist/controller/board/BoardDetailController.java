package com.eomcs.mylist.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.controller.Component;
import com.eomcs.mylist.controller.Controller;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.service.BoardService;

@Component("/board/detail") 
public class BoardDetailController implements Controller { // 얘는 서블릿이 아니기 때문에 안만들어줘

  BoardService boardService;


  public BoardDetailController(BoardService boardService)  {
    this.boardService = boardService;//이제 서블릿이 아니라서 일반클래스 @WebServlet 필요없음 얘가 사용할 의존객체는 생성자에서 받을 것
  } // 우리가 객체생성해줄꺼야 -> 리스너등록


  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception { //얘를 호출하는 프런트컨트럴러에게 에러를 던지므로 
    int no = Integer.parseInt(request.getParameter("no"));
    Board board = boardService.get(no);
    request.setAttribute("board", board);
    return "jsp/board/detail.jsp"; // 개발은 어떻게 하면 편하게 할까 하고 나온 잔머리 

  }
}
