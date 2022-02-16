// anonymous class : 인터페이스를 구현한 익명 클래스 정의
package com.eomcs.oop.ex11.e;

public class Exam0110 {
  // 인터페이스의 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  // => 인터페이스는 규칙을 정의한 것이기 때문에 인스턴스 멤버라는 개념이 존재하지 않는다. static 상관없다. 
  interface A {
    void print();
  }

  public static void main(final String[] args) {

    // 1) 로컬 클래스로 인터페이스 구현하기
    class My implements A {
      String name = "홍길동"; 

      @Override
      public void print() {
        System.out.printf("Hello, %s!\n", this.name);
      }
    }

    A obj = new My(); // 딱 1번쓴다. 여기서 마이클래스를 - 어차피 객체생성1번뿐만이라면 
    obj.print();
  }
}

//레페런스생성은 문제 없으나, 객체생성만들때가 문제- 바깥클래스의 주소가 필요하므로 - 중첩클래스