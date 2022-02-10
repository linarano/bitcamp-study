package com.eomcs.oop.ex11.overview.step2;

public class QueueIterator implements Iterator {
  MyQueue queue;
  // 커서 필요없다 팝으로 꺼낼꺼니까 

  public QueueIterator (MyQueue queue) {
    this.queue = queue;
  }

  @Override
  public boolean hasNext() {
    return queue.size() > 0; // 비교연산자의 리턴값 
  }


  @Override
  public Object next() {
    return queue.poll();
  }

}

// 생각하면 더 짧게 짤수있는데 - 길게짜는 경우가 많다.
// 나보다 소스코드 잘짜는 사람이 분명히 있다. 갑자기 위축되고 힘들다고 생각이 될껀데
// 스트레스 받을 필요없다.
// 소수의 몇명이다. - 누구나 나보다 잘하는 사람이 있고 낙심할 사람이 있다.
// 내가 잘짜더라도 자만하지마라 - 나보다 자만하지마라 = 
//자만할 필요도 자괴심을 느낄 필요도 없다.