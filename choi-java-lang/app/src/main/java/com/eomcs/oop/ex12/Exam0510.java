// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;


public class Exam0510 {

  static class MyCalculator {
    public static int plus(int a, int b) {return a + b;}
    public static int minus(int a, int b) {return a - b;}
    public static int multiple(int a, int b) {return a * b;}
    public static int divide(int a, int b) {return a / b;}
  }

  interface Calculator {
    int compute(int x, int y);
  }

  public static void main(String[] args) {
    // 메서드 한 개짜리 인터페이스의 구현체를 만들 때,

    // 1) 익명 클래스 활용
    Calculator obj1 = new Calculator() {
      @Override
      public int compute(int x, int y) {
        return x * y;
      }
    }; // 인스턴스를 만드는 거기때문에 ; 생략하면 안되. 문장의 끝

    // 2) 람바 문법 활용 - 현재 익명클래스를 더 간단 -간단한 구현체를 만들때 적절 
    Calculator obj2 = (x, y) -> x * y;

    // 3) 기존에 작성한 클래스의 스태틱 메서드를 재활용하기
    // => 인터페이스의 메서드 규격과 일치하는 메서드가 있다면,
    //    그 메서드를 람다 구현체로 대체할 수 있다.
    // => 새로 코드를 작성할 필요가 없어 매우 편리하다.
    // => 규격? 메서드의 파라미터 타입/개수/순서, 리턴 타입
    // => 문법:
    //    클래스명::메서드명
    Calculator c1 = MyCalculator::plus;
    Calculator c2 = MyCalculator::minus;
    Calculator c3 = MyCalculator::multiple;
    Calculator c4 = MyCalculator::divide;

    System.out.println(c1.compute(200, 17)); // compute() ==> plus()
    System.out.println(c2.compute(200, 17)); // compute() ==> minus()
    System.out.println(c3.compute(200, 17)); // compute() ==> multiple()
    System.out.println(c4.compute(200, 17)); // compute() ==> divide()
  }
}

//메소드 한개짜리 
//인처페이스의 구현체를 만드는 방법
// 연습방법 -> 기존것을 복사 0510x
//인터페이스의 모두 구현체는 퍼블릭 
// 컴파일러가 우리가 생략한걸 자동으로 만들어준다. - 익명클래스의 슈퍼클래스의 기본생성자를 호출해준다. // name = new //();
// 인스턴스를 만드는 거기때문에 ; 생략하면 안되. 문장의 끝


// 기존의 기능이 이미 있는 경우, 새로 구현하지말고,
// 기존의 메서드 호출 -> 컴퓨트호출하면 기존 메서드 호출하도록 return MyCalculator.plus(x,y)