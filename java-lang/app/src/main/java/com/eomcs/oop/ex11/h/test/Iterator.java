package com.eomcs.oop.ex11.h.test;

// 컬렉션의 값을 조회하는 객체 사용버 
public interface Iterator {
  boolean hasNext(); //꺼낼 값이 있는지 알고 싶을때 
  Object next(); // 값을 꺼낼떄 
}
