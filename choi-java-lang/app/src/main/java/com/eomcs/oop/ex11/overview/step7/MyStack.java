package com.eomcs.oop.ex11.overview.step7;

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
  public Iterator iterator() {


    return new Iterator(){//익명클래스의 생성자가 아니라., 슈퍼클래스의 생성자를 가리킨다. 


      // 커서 필요없다 팝으로 꺼낼꺼니까 



      @Override
      public boolean hasNext() {
        return MyStack.this.size() > 0; // 비교연산자의 리턴값 
      }


      @Override
      public Object next() {
        return  MyStack.this.pop();
      }

    };
  }

}

// 메서드 호출 