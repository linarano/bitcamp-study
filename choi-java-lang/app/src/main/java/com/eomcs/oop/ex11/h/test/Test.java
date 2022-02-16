package com.eomcs.oop.ex11.h.test;


public class Test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    list.add("안중근");
    list.add("윤봉길");
    list.add("김구");
    System.out.println(list.size());

    printList(list);

    list.remove(0); // 홍길동
    list.remove(4);//김구
    list.remove(2);//안중근
    printList(list);

    // 내가 삭제전 값을 먼저 꺼내고 싶다면 
    // Object deleted = list.get(0); //먼저 삭제값을 먼저 꺼내고 알고싶으면 -> 실무에서는 리무브전에 -> api : 필요있으면 이걸 가져다 쓰라는 의미 
    list.remove(0);
    list.remove(0);
    list.remove(0);
    //  애드
    list.add("박보검"); //뒤에 계쏙 추가 
    printList(list);

    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    list.add("안중근");
    list.add("윤봉길");
    printList(list);


    //삽입
    list.add(0,"김구"); // 만약 0번째 삽입한다면? -> 맨 앞에 이전노드는  null이므로 -> 조건 필요
    list.add(0,"안창호");
    list.set(4,"오호라");
    printList(list);
    System.out.println("-------------------------------------");


    list.add(7, "김상옥");
    printList(list);

    list.set(4, "오호라");
    printList(list);
  }

  static void printList(LinkedList list) {

    //  이터레이터 객체만 필요할 뿐, 그게 뭐인지는 궁금하지않음 -> 내부로 옮겨 
    Iterator iterator = list.iterator(); // 실제로는 리스트이터레이터 객체를 이턴하지만, 이터레이터 규칙에 따라서 만든 
    while(iterator.hasNext()) {
      System.out.print(iterator.next() + ",");
    }
    System.out.println();
    System.out.println("----------------");

  }
}


