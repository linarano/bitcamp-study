package com.eomcs.oop.ex11.overview.step2;

public class Test2 {
  public static void main(String[] args) {
    MyStack myStack = new MyStack();
    myStack.push("홍길동");
    myStack.push("임꺽정");
    myStack.push("유관순");
    myStack.push("안중근");
    myStack.push("윤봉길");
    myStack.push("김구");

    StackIterator iterator= new StackIterator(myStack);// 
    // 꺼내는 방법은 단일->일관성이 있다.(이터레이터를 쓰는 이유)
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}