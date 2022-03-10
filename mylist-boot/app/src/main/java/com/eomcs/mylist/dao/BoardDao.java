package com.eomcs.mylist.dao;

import java.util.List;
import com.eomcs.mylist.domain.Board;

public interface BoardDao {

  // 인터페이스는 객체의 메서드 호출 규칙을 정의하는 것이기 때문에 
  // 메서드를 작성할 때 메서드 몸체(method body)를 작성하지 말아야 한다.
  // 메서드 바디가 없는 메서드를 "추상 메서드(abstract method)"라 부른다.
  //인테페이스 메서드 정의시 예외를 정의하지않음 - 예외 안던짐 -> 실무 " 실제 구현체에서 런타임익셉션 정리 - dao 사용하는 쪽에서 
  int countAll() ;

  List<Board> findAll(); //파라미터타입이나 리턴타입이 인터페이스일 경우 대체하기 쉽다

  int insert(Board board);

  Board findByNo(int no) ;

  int update(Board board); //어레이리스트에서 쓰는 방식이므로 번호받지만, 보드에서 한번에 받아라 이제 

  int delete(int no);

  int increaseViewCount(int no) ;//update갯수를 리턴해라 항상, 쓰든 안쓰든 
}











