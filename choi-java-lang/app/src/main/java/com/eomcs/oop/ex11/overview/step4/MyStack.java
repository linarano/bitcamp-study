package com.eomcs.oop.ex11.overview.step4;

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

  static public class StackIterator implements Iterator {
    MyStack stack;


    public StackIterator (MyStack stack) {
      this.stack = stack;
    }

    @Override
    public boolean hasNext() {
      return stack.size() > 0; // 비교연산자의 리턴값 
    }


    @Override
    public Object next() {
      return stack.pop();
    }
  }

}
