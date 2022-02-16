// 오버라이딩(overriding) - this/super의 사용
package com.eomcs.oop.ex06.c;

// this.메서드() 호출?
// => 현재 클래스(this의 실제타입)부터 호출할 메서드를 찾아 올라 간다.***
//
// super.메서드() 호출?
// => 부모 클래스(메서드가 속해있는 그 클래스의 부모클래스)부터 호출할 메서드를 찾아 올라 간다. //this의 부모가 아니다!
//

public class Exam0420 {
  static class X {
    void m1() {
      System.out.println("X의 m1()");
    }
    void m2() {
      System.out.println("X의 m2()");
    }
  }


  static class X2 extends X {
    @Override
    void m1() {
      System.out.println("X2의 m1()");
    }
  }


  static class X3 extends X2 {
    @Override
    void m2() {
      System.out.println("X3의 m2()");
    }
  }


  static class X4 extends X3 {
    @Override
    void m1() {
      System.out.println("X4의 m1()");
    }

    void test() {
      this.m1(); // X4의 m1() : this가 실제 가리키는 인스턴스 클래스를 기준으로 메서드를 찾아 올라 간다.
      super.m1(); // X2의 m1() : test()가 소속된 클래스를 기준으로 수퍼 클래스부터 메서드를 찾아 올라간다.

      this.m2(); // X3의 m2()
      super.m2(); // X3의 m2()

      //      super.super.m1(); // 컴파일 오류! 이런 문법은 없다! 무협지 문법! - 나는 가장 위의 m2()를 쓰고 싶다고 막 쓰면안된다. , 이걸쓸일은 거의없겠지만 다른방법으로 구현해라. 그동안 사례는 없다. 아예문법없음 

    }
  }

  public static void main(String[] args) {
    X4 obj = new X4();
    obj.test();

    // 레퍼런스에서 super를 사용할 수 없다.
    //    obj.super.m1(); // 컴파일 오류!
  }
}


//***기준점 - 어디서 부터 찾아올가느냐의 문제 this
//streaming API 요즘흐름  - 마치 컨베이너 벨트에서 나사를 조인건 다시던져주는 것처럼 
//자바스크립트- 비동기처리 - 프로미스 -> Fetch
// 최신문법을 쫓아가는게 힘들어 또한 내 동료나 후임자선임자가 모르는 경우 있음
// 선임자가 나보다 문법을 모르는 경우가 많음. 
// 실무에서는 유지보수의 입장에서는 가장맣이쓴ㄴ걸 써야하므로 최신문법을 쓰는게 능사가아님 






