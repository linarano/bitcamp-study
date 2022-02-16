// 오버라이딩(overriding) - 오버라이딩할 때 접근 범위 조정하기
package com.eomcs.oop.ex06.c;

public class Exam0320 {

  static class C {
    private void m1() {}
    void m2() {}
    protected void m3() {} //서브클래스가 접근할수 있으나 약간 다르다.(다른패키지에 있더라도 자식클래스면 가능)- defualt보다 확대
    public void m4() {}
  }

  static class C3 extends C {

    // 오버라이딩 메서드의 접근 범위를 확대하는 것은 괜찮다.
    // => private 은 오버라이딩 자체가 불가능하기 때문에 접근 범위를 확대할 수 없다.
    //    @Override public void m1() {}

    //    @Override private void m2() {} // 컴파일 오류! 원래 접근 범위 보다 좁힐 수 없다.(접근범위를 줄이는건 안됨)
    //    @Override  void m2() {} // 접근 범위를 원래 대로 지정하는 것. OK!
    //    @Override protected void m2() {} // OK! default 보다 접근 범위를 확대하는 것은 허용된다.
    @Override public void m2() {} // OK! default 보다 접근 범위를 확대하는 것은 허용된다.****

    //    @Override private void m3() {} // 컴파일 오류! 원래 접근 범위 보다 좁힐 수 없다.
    //    @Override void m3() {} // 컴파일 오류! 원래 접근 범위 보다 좁힐 수 없다.
    //    @Override protected void m3() {} // 접근 범위를 원래 대로 지정하는 것. OK!
    @Override public void m3() {} // OK! proteced 보다 접근 범위를 확대하는 것은 허용된다.

    //    @Override private void m4() {} // 컴파일 오류! 원래 접근 범위 보다 좁힐 수 없다.
    //    @Override void m4() {} // 컴파일 오류! 원래 접근 범위 보다 좁힐 수 없다.
    //    @Override protected void m4() {} // 컴파일 오류! 원래 접근 범위 보다 좁힐 수 없다.
    //    @Override public void m4() {} // 접근 범위를 원래 대로 지정하는 것. OK!
  }

  public static void main(String[] args) {
    // C, C2, C3, C4 클래스의 주석을 확인하라!
  }
}

//규칙
//재정의 원칙- 슈퍼클래스보다 같거나 확대 가능
//축소는 안됨







