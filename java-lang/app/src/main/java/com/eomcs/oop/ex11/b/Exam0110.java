// static nested class : 클래스 정의와 인스턴스 생성
package com.eomcs.oop.ex11.b;

//import com.eomcs.oop.ex11.b.A.X; //스태틱 중첩클래스에서만 가능 

class A {
  //static int a;
  static class X { // 위의 것처럼 똑같이 사용ㄱ ㅏ능 

  }
}

public class Exam0110 {

  public static void main(String[] args) {
    //A.a= 100;

    // 레퍼런스 선언 - 일반적 스태틱변수 사용하는 것사용 할 수 있다.  - 중첩클래스 1) 제1 - 그안에서만 쓰도록 제약 2) 작은 클래스를 패키지로 관리하지말고 하나으 ㅣ클래스로 담아서 소스코드로 사용
    A.X obj;

    // 인스턴스 생성
    obj = new A.X();
  }

}

