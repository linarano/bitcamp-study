package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Board;

public interface BoardDao { 

  // 인터페이스는 객체의 메서드 호출 규칙을 정의하는 것이기 때문에
  // 메서드를 작성할때 메서드 몸체를 작성하지 말아야한다.
  // 메서드 바디가 없는 메서드를 추상메서드라 부른다. 

  int countAll();

  Object[] findAll();

  void insert(Board board) throws Exception;

  Board findByNo(int no);

  int update(int no, Board board) throws Exception ;

  int delete(int no) throws Exception ;

  void increaseViewCount(int no) throws Exception;

}

//인터페이스는 모두 public이므로 생략가능*** - 디폴트,프로텍티드,프라이빗 안됨 
//외부에 노출된 사용규칙 - 인터페이스
//save는 private

