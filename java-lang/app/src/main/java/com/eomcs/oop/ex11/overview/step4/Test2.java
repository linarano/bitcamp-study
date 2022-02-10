package com.eomcs.oop.ex11.overview.step4;

public class Test2 {
  public static void main(String[] args) {
    MyStack myStack = new MyStack();
    myStack.push("홍길동");
    myStack.push("임꺽정");
    myStack.push("유관순");
    myStack.push("안중근");
    myStack.push("윤봉길");
    myStack.push("김구");


    Iterator iterator = myStack.iterator(); // 이터레이터 구현체를 리턴할꺼다만 알면 된다.

    // 꺼내는 방법은 단일->일관성이 있다.(이터레이터를 쓰는 이유)
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}