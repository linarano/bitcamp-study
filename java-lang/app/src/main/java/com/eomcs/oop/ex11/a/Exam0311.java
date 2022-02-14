// nested class : 로컬 클래스의 접근 제어
package com.eomcs.oop.ex11.a;

public class Exam0311 {

  static void m1() {
    // 로컬 변수처럼 로컬 클래스에는 접근 제어 modifier 를 붙일 수 없다.
    //    private class A1 {} // 컴파일 오류!
    //        protected class A2 {} // 컴파일 오류!
    //    public class A3 {} // 컴파일 오류!

    class A4 {} // OK! ///로컬클래스 - 당연히 public이 안됨 

    //ㄹ
  }

  void m2() {
    // 로컬 변수처럼 로컬 클래스에는 접근 제어 modifier 를 붙일 수 없다.
    //    private class B1 {} // 컴파일 오류!
    //    protected class B2 {} // 컴파일 오류!
    //    public class B3 {} // 컴파일 오류!

    class B4 {} // OK!
  }
}

//메서드 안에 선언한 로컬변수에 public int a 가능하냐? 노논 아예 말도 안되는 - 문법에도 없음 로컬이므로 - 다른 메서드가 볼수도없음