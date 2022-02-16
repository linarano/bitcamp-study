package com.eomcs.oop.ex11.overview.step4;

public class Test1 {
  public static void main(String[] args) {
    MyList myList = new MyList();
    myList.add("홍길동");
    myList.add("김구");
    myList.add("유관순");
    myList.add("윤봉길");
    myList.add("임꺽정");


    Iterator iterator = myList.iterator(); //뭔지몰라도 이터레이터 구현체를 리턴한다는 것만 안다. -> 클래스 이름이 바뀌더라도 영향을 받지 않는다.  - low 커플링 - 강제적이아니라 줄일 수 있음녀 줄여라 
    while(iterator.hasNext()) { //전혀 관계없다. 얘는 얘를 모른다.  //인터페이스가 빠뀔일은 없다. 
      System.out.println(iterator.next());
    }
  }
}
