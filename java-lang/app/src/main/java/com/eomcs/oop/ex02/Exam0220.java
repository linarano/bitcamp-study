package com.eomcs.oop.ex02;

// # 관련된 기능(메서드)을 묶어 분류하기 - 클래스로 분류
//
public class Exam0220 {

  // 계산 기능과 관련된 메서드를 별도의 블록으로 분리할 때 사용하는 문법이 "클래스"이다.
  // 메서드를 분류해 놓으면 좋은 점?
  // - 소스 코드를 유지보수하기 쉬워진다.
  // - 코드 재사용성이 높아진다.
  // 
  static class Calculator { //class 이름을 지을때 적당한 이름을 짓는다. -> 명사구형태 
    static int plus(int a, int b) {
      return a + b;
    }

    static int minus(int a, int b) {
      return a - b;
    }

    static int multiple(int a, int b) {
      return a * b;
    }

    static int divide(int a, int b) {
      return a / b;
    }

    static int abs(int a) {
      //  필요 기능이 있으면 그때그때 추가 가능 
      // if (a >= 0) 
      //   return a; 
      // else 
      //   return a * -1;
      //
      return a >= 0 ? a : a * -1;
    }
  }

  public static void main(String[] args) {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?

    // 계산 결과를 담을 변수를 준비한다.
    int result = 0;

    // 클래스 메서드를 호출하여 작업을 수행하고,
    // 리턴 결과는 로컬 변수에 저장한다.
    result = Calculator.plus(2, 3);
    result = Calculator.minus(result, 1);
    result = Calculator.multiple(result, 7);
    result = Calculator.divide(result, 3);// 클래스이름을 준다. 

    System.out.printf("result = %d\n", result);
  }
}
// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.


//복잡한 과정이 보인다. 클래스변수로 선언해버리자.  내부로 변수를 넣자.
//계산 결과를 밖으로 리턴할 필요없다. 내부에 저장할꺼니까. 

//장점- 바깥에서 계산결과를 관리할 필요없음 
//일하는 애한테 준다. 그리고 값만 리턴받자. 


