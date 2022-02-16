// 제네릭 적용 전 LinkedList 
package com.eomcs.generic.ex03;

public class Exam0110 {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(new Member("홍길동", 20));
    list.add(new Member("임꺽정", 30));
    list.add(new Member("유관순", 16));

    // 다음과 같이 Member 가 아닌 다른 타입의 객체를 저장하더라도 막을 수 없다. (Object 타입이므로)
    list.add(new String("문자열!!!"));

    // 값을 꺼내 사용하면 항상 형변환해야 한다.  (Object 타입이므로)
    for (int i = 0; i < list.size(); i++) {
      Member member = (Member) list.get(i);
      System.out.printf("%s(%d)\n", member.name, member.age);
    }
  }
}






// 실행할 떄 밝혀지면 버그
// 따라서 컴파일 단계에서 걸러져야함.!!! -> 제네릭
// 가능하면 예외상황 발생시키지말고 컴파일단계에서 거르자~!









