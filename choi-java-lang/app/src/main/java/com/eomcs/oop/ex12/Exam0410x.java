// 리턴 문장에 람다(lambda) 활용
package com.eomcs.oop.ex12;

public class Exam0410x {

  static interface Interest {
    double compute(int money);
  }

  // 팩토리 메서드
  // => Interest 구현체를 생성하여 리턴하는 메서드
  // 
  static Interest getInterest(final double rate) {
    // 로컬 클래스로 인터페이스 구현한 후 객체 리턴하기
    Object obj  = 
        @Override
        public double compute(int money) {
      return money + (money * rate / 100);
    }
  }
  return new InterestImpl();
}

public static void main(String[] args) {
  Interest i1 = getInterest(1.5);
  System.out.printf("금액: %.2f\n", i1.compute(1_0000_0000));

  Interest i2 = getInterest(2.5);
  System.out.printf("금액: %.2f\n", i2.compute(1_0000_0000));
}

}


// 익명클래스를 메서드 갯수 상관없음 
// 추상메서드1개 -> 람다와 메서드레퍼런스