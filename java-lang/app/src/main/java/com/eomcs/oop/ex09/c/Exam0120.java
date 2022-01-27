// 인터페이스 다중 상속과 구현
package com.eomcs.oop.ex09.c;


public class Exam0120 {

  interface ProtocolA {
    void rule1();
  }

  interface ProtocolB {
    void rule2();
  }

  interface ProtocolC extends ProtocolA, ProtocolB {
    void rule3();
  }

  // 인터페이스를 구현할 때는
  // 수퍼 인터페이스의 메서드까지 모두 구현해야 한다.
  class ProtocolImpl implements ProtocolC {
    // ProtocolA 규칙 준수!
    @Override
    public void rule1() {System.out.println("rule1()");}

    // ProtocolB 규칙 준수!
    @Override
    public void rule2() {System.out.println("rule2()");}

    // ProtocolC 규칙 준수!
    @Override
    public void rule3() {System.out.println("rule3()");}
  }
  public void m1() {System.out.println("m1()");}
}

void test() {

  ProtocolImpl obj = new ProtocolImpl();

  // 1) 인터페이스 레퍼런스로 구현체의 주소 받기
  ProtocolC c = obj;
  ProtocolB b = obj;
  ProtocolA a = obj;

  // 2) 메서드 호출
  // - 해당 인터페이스의 규칙에 따라서만 호출할 수 있다.

  c.rule1(); // OK
  c.rule2(); // OK
  c.rule3(); // OK
  System.out.println("-------------------------------");

  //    b.rule1(); // 컴파일 오류!
  b.rule2(); // OK
  //    b.rule3(); // 컴파일 오류!
  System.out.println("-------------------------------");

  a.rule1(); // OK
  //    a.rule2(); // 컴파일 오류!
  //    a.rule3(); // 컴파일 오류!
  System.out.println("-------------------------------");
}

public static void main(String[] args) {
  new Exam0120().test();
}
}




// 자바는 클래스상속받을때 같은 시그너쳐를 가진 다중상속을 허락하지않음. 
//다중상속을 허용했을떄 어던 클래스의 M1()을 호출하느냐에 따라 동작이 달라진다. (구현된 메서드)
// 인터페이스는 허락  - 구현되지않은 메서드이므로 어떤 것을 상속받더라도 문제될게 없다. 


