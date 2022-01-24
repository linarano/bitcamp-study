package com.eomcs.mylist.controller;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.CsvBoardDao;
import com.eomcs.mylist.domain.Board;

@RestController 
public class BoardController {

  CsvBoardDao boardDao = new CsvBoardDao();


  @RequestMapping("/board/list")
  public Object list() {
    return boardDao.findAll(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {

    board.setCreatedDate(new Date(System.currentTimeMillis()));
    boardDao.insert(board);
    return boardDao.countAll();
  }


  @RequestMapping("/board/get")
  public Object get(int index) {
    Board board = boardDao.findByNo(index); // 못찾으면 null 리턴 
    if (board == null) {
      return ""; // 빈문자열 리턴, 웹브라우저에 자바스크립트 쪽에 널을 리턴할 수 없으므로 
    }

    board.setViewCount(board.getViewCount() + 1);
    return board;
  }


  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    Board old = boardDao.findByNo(index);

    if (old == null) {
      return 0;
    }

    board.setViewCount(old.getViewCount());
    board.setCreatedDate(old.getCreatedDate());
    return boardDao.update(index, board);
  }
  // 다른 사람이 100번 게시물을 지울 수 있기때문에 중간에 - 무효할 수 있으므로, 0 리턴
  //코드를 실행하는 과정중에 
  @RequestMapping("/board/delete")
  public Object delete(int index) {
    return boardDao.delete(index);
  }


  @RequestMapping("/board/save") //sava로 해야 바이너리 형식으로 저장, 출력 
  public Object save() throws Exception {
    boardDao.save();
    return boardDao.countAll();
  }
}

//필드값일일이 출력하는게 아니라 객체 직접출력
//board 생성자 호출안됨, 바로 객체를 집어넣는다. - 26분
//arrayList 통째로 출력 (각자 따로해도되고)
//단, serialrizable 해야함. 인터페이스

//강사님이 저렇게 메서드를 사용했구나 정도 ...
// 한번에 되는게 없다 경험ㅇ르 배워라 