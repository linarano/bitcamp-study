package com.eomcs.mylist.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.controller.Component;
import com.eomcs.mylist.controller.Controller;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@Component("/board/add") 
public class BoardAddController  implements Controller { // 얘는 서블릿이 아니기 때문에 안만들어줘

  BoardService boardService;

  public BoardAddController(BoardService boardService)  {
    this.boardService = boardService;//이제 서블릿이 아니라서 일반클래스 @WebServlet 필요없음 얘가 사용할 의존객체는 생성자에서 받을 것
  } // 우리가 객체생성해줄꺼야 -> 리스너등록

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(request.getMethod().equals("GET")) {
      return"/jsp/board/form.jsp";
    }
    Board board = new Board();
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    board.setWriter(loginUser);

    boardService.add(board);

    return "redirect:list";

  }
}
// 컨트럴러에게 요청











