package com.eomcs.mylist.controller;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;

@RestController 
public class BoardController {

  // 필드 선언부에 표시해두면
  // SpringBoot가 BoardController 객체를 자동으로 자동으로 주입한다. 
  //
  @Autowired
  BoardDao boardDao; 

  @RequestMapping("/board/list")
  public Object list() {
    return boardDao.findAll(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) throws Exception {

    board.setCreatedDate(new Date(System.currentTimeMillis()));
    boardDao.insert(board);
    return boardDao.countAll();
  }


  @RequestMapping("/board/get")
  public Object get(int index) throws Exception {
    Board board = boardDao.findByNo(index); // 새로객체리턴이 아니라 기존의 어레이리스트에 있던걸 리턴, 값을 바뀌면, 저장된 조회수가 저장안됨 
    if (board == null) {
      return ""; // 빈문자열 리턴, 웹브라우저에 자바스크립트 쪽에 널을 리턴할 수 없으므로 
    }

    boardDao.increaseViewCount(index); //기존 객체가 바뀌는 것이므로 손을대면 안됨(남의것을 함부로 손대면 안됨), dao가 다루는 객체는  
    return board;
  }


  @RequestMapping("/board/update")
  public Object update(int index, Board board) throws Exception {
    Board old = boardDao.findByNo(index);

    if (old == null) {
      return 0;
    }

    board.setViewCount(old.getViewCount());
    board.setCreatedDate(old.getCreatedDate());// 복제해와서 바뀐 이메일 ,컨트럴러가 다루는 객체 가 다루는 객체는  
    return boardDao.update(index, board);
  }
  // 다른 사람이 100번 게시물을 지울 수 있기때문에 중간에 - 무효할 수 있으므로, 0 리턴
  //코드를 실행하는 과정중에 
  @RequestMapping("/board/delete")
  public Object delete(int index)  throws Exception { // 개발자가 처리하기 싫어 delete을 호출한 스프링부트에 시켜 
    return boardDao.delete(index);
  }

}

//필드값일일이 출력하는게 아니라 객체 직접출력
//board 생성자 호출안됨, 바로 객체를 집어넣는다. - 26분
//arrayList 통째로 출력 (각자 따로해도되고)
//단, serialrizable 해야함. 인터페이스

//강사님이 저렇게 메서드를 사용했구나 정도 ...
// 한번에 되는게 없다 경험ㅇ르 배워라 