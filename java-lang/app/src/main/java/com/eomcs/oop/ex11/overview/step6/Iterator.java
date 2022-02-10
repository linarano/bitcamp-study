package com.eomcs.oop.ex11.overview.step6;

// 목록을 관리하는 객체 - 컬렉션 //이터레이터는 컬렉션에서 데이터를 조회하는 객체 사용법을 정의한다. 
// 규칙을 만들었으니 규칙을 지켜야한다.
//
public interface Iterator {
  boolean hasNext(); //  컬렉션에서 꺼낼 데이터가 있는지 확인  
  Object next(); // 컬렉션에서 데이터를 꺼내기 
}

//규칙
//규칙을 사용하는쪽
//사용되는 쪽을 다 만드는 중 