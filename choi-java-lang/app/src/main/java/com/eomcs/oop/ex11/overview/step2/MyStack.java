package com.eomcs.oop.ex11.overview.step2;

import java.util.EmptyStackException;

public class MyStack extends MyList {

  public void push(Object obj) {
    this.add(obj);
  }

  public Object pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return remove(size - 1);

  }
}

// 겸사겸사 자료구조 만든다. 
//자료구조는 혼자서 만들 수 있을정도로 트레이닝해라.
//향후 프로그램 개발뿐만 아니라 손코딩테스트 통과 가능 

