package com.eomcs.oop.ex11.overview.step4;

public class Test3 {
  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.offer("홍길동");
    myQueue.offer("임꺽정");
    myQueue.offer("유관순");
    myQueue.offer("안중근");
    myQueue.offer("윤봉길");
    myQueue.offer("김구");


    Iterator iterator =  myQueue.iterator(); //MyQueue.iterator(myQueue);// 인스턴스 메서드를 안배웠을때는 파라미터를 뒤에 

    // 꺼내는 방법은 단일->일관성이 있다.(이터레이터를 쓰는 이유)
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
//  아예꺼냄
//list gㄷㅅ 조회 