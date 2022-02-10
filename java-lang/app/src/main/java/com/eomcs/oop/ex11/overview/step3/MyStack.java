package com.eomcs.oop.ex11.overview.step3;

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

  @Override // 상속받은 메서드 중에서  서브클래스의 목적에 맞게끔 재정의 
  public Iterator iterator() 
  {
    return new StackIterator(this);
  }

}

// 겸사겸사 자료구조 만든다. 
//자료구조는 혼자서 만들 수 있을정도로 트레이닝해라.
//향후 프로그램 개발뿐만 아니라 손코딩테스트 통과 가능 

