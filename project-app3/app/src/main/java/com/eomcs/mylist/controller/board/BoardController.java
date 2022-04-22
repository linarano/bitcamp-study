package com.eomcs.mylist.controller.board;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller; //스프링
import org.springframework.web.bind.annotation.RequestMapping; //스프링
import org.springframework.web.bind.annotation.RequestParam; //스프링
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@Controller// 페이지컨트럴러에게 붙인다.- 리턴값은 JSP주소 //@RestController - 메서드의 리턴값은 제이슨을 변환해서 보낸다. 
@RequestMapping("/board/")
public class BoardController {

  BoardService boardService;

  public BoardController(BoardService boardService) { // 생성자에서 보드서비스를 요구하는데  애노테이션붙은게 없다. 애노테이션이 없으면 관리할 대상이없으므로 못찾음 
    this.boardService = boardService;
  }

  @RequestMapping("list")
  public String list(
      @RequestParam(value="pageNo", defaultValue="1") int pageNo, 
      @RequestParam(value="pageSize", defaultValue="5") int pageSize, 
      Map<String,Object> model) throws Exception {

    int totalPageSize = 0;

    try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
      if (pageSize < 5 || pageSize > 100) {
        pageSize = 5;
      }
    } catch (Exception e) {}

    //게시글 전체 개수를 알아내서 페이지 개수를 계산한다.
    int boardSize = boardService.size(); 
    totalPageSize = boardSize / pageSize; // 예: 게시글개수 / 페이지당개수 = 16 / 5 = 3 
    if ((boardSize % pageSize) > 0) {
      totalPageSize++;
    }

    try { // pageNo 파라미터 값이 있다면 기본 값을 변경한다.
      if (pageNo < 1 || pageNo > totalPageSize) {// pageNo 유효성 검증
        pageNo = 1;
      }
    } catch (Exception e) {}

    // 2) 서비스 객체 실행
    List<Board> boards = boardService.list(pageSize, pageNo);

    // 3) 출력 데이터 준비
    model.put("list", boards);
    model.put("pageNo", pageNo);
    model.put("pageSize", pageSize);
    model.put("totalPageSize", totalPageSize);

    return "/jsp/board/list.jsp"; // 프런트 컨트럴러가 실행할 jsp주소냐 json에 따라서 애노테이션을 결정해야하는 것  - 우리는 JSP를 하고있기때문에
  }

  @RequestMapping("detail")
  public String detail(@RequestParam("no") int no, Map<String, Object> model) throws Exception {
    Board board = boardService.get(no);
    model.put("board", board);
    return "/jsp/board/detail.jsp";
  }

  @RequestMapping("update")
  public String update(
      @RequestParam("no") int no, 
      @RequestParam("title") String title, 
      @RequestParam("content") String content,
      HttpSession session) throws Exception {

    Board board = new Board();
    board.setNo(no);
    board.setTitle(title);
    board.setContent(content);

    Member loginUser = (Member) session.getAttribute("loginUser");
    board.setWriter(loginUser);

    boardService.update(board);

    return "redirect:list"; 
  } 

  @RequestMapping("delete")
  public String delete(@RequestParam("no") int no, HttpSession session) throws Exception {
    Board board = new Board();
    board.setNo(no);

    Member loginUser = (Member) session.getAttribute("loginUser");
    board.setWriter(loginUser);

    boardService.delete(board);

    return "redirect:list";
  }

  @RequestMapping("add")
  public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equals("GET")) {
      return "/jsp/board/form.jsp";
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






