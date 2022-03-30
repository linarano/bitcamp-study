package com.eomcs.mylist.controller;

import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@RestController 
public class BoardController {

  @Autowired
  BoardService boardService;

  @RequestMapping("/board/list")
  public Object list() {
    return boardService.list();
  }

  @RequestMapping("/board/add")
  public Object add(Board board, HttpSession session) {
    Member member = (Member)session.getAttribute("loginUser");
    if(member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인하지 않았습니다.");
    }
    //로그인한 사용자만이 인서트할 수 있도록 
    board.setWriter(member);
    boardService.add(board);
    return new ResultMap().setStatus(SUCCESS);
  }


  @RequestMapping("/board/get")
  public Object get(int no) {
    Board board = boardService.get(no);
    if (board == null) {
      return "";
    }
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(Board board, HttpSession session) {
    Member member = (Member)session.getAttribute("loginUser");
    if(member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인하지 않았습니다.");
    }
    //자기가 쓴글만 업데이트하거나 삭제할 수 있도록
    board.setWriter(member);
    int count = boardService.update(board);

    if(count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    }else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유호하지않습니다");
    }
  }

  @RequestMapping("/board/delete")
  public Object delete(int no, HttpSession session) {
    Member member = (Member)session.getAttribute("loginUser");
    if(member == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인하지 않았습니다.");
    }
    Board board = new Board();
    board.setNo(no);
    board.setWriter(member);

    int count = boardService.delete(board);
    if(count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    }else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유호하지않거나 회원이 남긴 글이 아닙니다");
    }

  }
}




