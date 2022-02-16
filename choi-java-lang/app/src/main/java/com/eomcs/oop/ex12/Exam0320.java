// 아규먼트에 람다(lambda) 활용 II - 파라미터와 리턴 값이 있는 람다 만들기
package com.eomcs.oop.ex12;

public class Exam0320 {

  static interface Calculator {
    int compute(int a, int b);
  }

  static void test(Calculator c) {
    System.out.println(c.compute(100, 200));
  }

  public static void main(String[] args) {

    // 람다 
    // 파라미터와 리턴 값이 있는 메서드 구현하기
    test((a, b) -> a + b); // 현업에서 많이 사용한다.

  }

}


// 익숙해지고 나서야 학습이된다.
// 길치도 네비게이션만 있으면 운전할 수 있다. 

// 눈코딩은 늘지 않는다.
//요리를 유투브로만 보면 느는가? 직접 따라해보고 맛을 봐야지 
// 따라 해라. 