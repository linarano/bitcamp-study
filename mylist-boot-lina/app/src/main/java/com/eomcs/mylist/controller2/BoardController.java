package com.eomcs.mylist.controller2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao2.BoardDao;
import com.eomcs.mylist.domain2.Board;

@RestController 
public class BoardController { // 이 메서드를 호출하는 쪽에서도 마찬가지로  예외 발생하면 - 스프링부트가 그 예외를 받는다 - 스프링부트가 기본적조치함 : 자바버츄얼머신을 종료하는게 아니라 상세에러정보를 웹브라우저에 띄운다.

  // 필드 선언부에 표시해두면
  // SpringBoot가 BoardController 객체를 자동으로 자동으로 주입한다. 
  //

  //  @Autowired(required = false)//디폴트가 트루, 객체를 찾을 수 없는 에러를 안뜨도록 하도록 - 인스턴스멤버를 사용하려면 인스턴스 주소가 있어야됨 
  //@Autowired
  BoardDao boardDao; //의존객체주입(필수여야함 없어도 되는게 있음 여기서는 없으면 무용지물필수) - 인터페이스의 구현체를 모두 올 수 있다. 유지보수에 좋음 (교체가능성이 높아짐)

  @RequestMapping("/board/list")   //요청핸들러
  public Object list(){ //요청핸들러
    return boardDao.findAll(); 
  }

  @RequestMapping("/board/add") //요청핸들러
  public Object add(Board board){
    return boardDao.insert(board);

  }


  @RequestMapping("/board/get")
  public Object get(int no) {
    Board board = boardDao.findByNo(no); // 새로객체리턴이 아니라 기존의 어레이리스트에 있던걸 리턴, 값을 바뀌면, 저장된 조회수가 저장안됨 
    if (board == null) {
      return ""; // 빈문자열 리턴, 웹브라우저에 자바스크립트 쪽에 널을 리턴할 수 없으므로 
    }

    boardDao.increaseViewCount(no); //기존 객체가 바뀌는 것이므로 손을대면 안됨(남의것을 함부로 손대면 안됨), dao가 다루는 객체는  
    return board;
  }


  @RequestMapping("/board/update")
  public Object update(Board board){
    return boardDao.update(board);
  }
  // 다른 사람이 100번 게시물을 지울 수 있기때문에 중간에 - 무효할 수 있으므로, 0 리턴
  //코드를 실행하는 과정중에 
  @RequestMapping("/board/delete")
  public Object delete(int no) { // 개발자가 처리하기 싫어 delete을 호출한 스프링부트에 시켜 
    return boardDao.delete(no);
  }

}

//필드값일일이 출력하는게 아니라 객체 직접출력
//board 생성자 호출안됨, 바로 객체를 집어넣는다. - 26분
//arrayList 통째로 출력 (각자 따로해도되고)
//단, serialrizable 해야함. 인터페이스

//강사님이 저렇게 메서드를 사용했구나 정도 ...
// 한번에 되는게 없다 경험ㅇ르 배워라 