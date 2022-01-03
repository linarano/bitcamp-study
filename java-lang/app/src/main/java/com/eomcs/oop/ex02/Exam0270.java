package com.eomcs.oop.ex02;

// # 관련된 기능(메서드)을 묶어 분류하기 - 패키지 멤버 클래스
//
public class Exam0270 {

  // 여러 클래스중 어느 클래스인지 빠르게 찾을 수 있도록(기능추가등의 이유로)Calculator 클래스를 향후 유지보수하기 쉽도록 별도의 파일로 분리한다.
  // - Calculator.java 파일로 분리한다.

  public static void main(String[] args) {
    // 다음 두 개의 식을 분리하여 계산해 보자!
    // - 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 식1) 2 + 3 - 1 * 7 / 3 = ?
    // 식2) 3 * 2 + 7 / 4 - 5 = ?

    //    int result = Integer.compare(121, 150);
    //    System.out.println(result);

    //    Integer i1 = new Integer(100);
    //    //        int result2 = i1.compare(300,2); //컴파일 오류는 안나지만, 클래스메소드를 논스태틱 클래스에 사용. , 쓰지않을 변수를 호출한셈, 욕먹는 코드  //다른개발자는 논스태틱메소드로 오해할 수 있음
    //    //    System.out.println(result2);
    //    //스태틱 메소드는 원래 클래스이름으로 호출해야하나 , 특별한 경우에 레퍼런스로 스태틱메소드를 호출할일이 가끔있기때문에 문법적으로 막지는 않음(느슨하게 만든것을 아무제약없이 막쓰는것은 바람직하지않음) - 그래서 자바에서도 경고를 띄운다. 
    //
    //    Integer i2 = new Integer(100);
    //    int result3 = i2.compareTo(2); //컴파일 오류는 안나지만, 클래스메소드를 논스태틱 클래스에 사용. , 쓰지않을 변수를 호출한셈, 욕먹는 코드  //다른개발자는 논스태틱메소드로 오해할 수 있음
    //    System.out.println(result3);


    Calculator c1 = new Calculator(); // 식1의 계산 결과를 보관할 메모리 준비
    Calculator c2 = new Calculator(); // 식2의 계산 결과를 보관할 메모리 준비

    // 계산을 수행할 때 계산 결과를 보관할 메모리를 메서드 호출 앞에서 전달하라!
    // - 인스턴스 메서드를 사용하면 파라미터로 메모리 주소를 전달할 필요가 없다.
    c1.plus(2); // + 2
    c2.plus(3); // + 3

    c1.plus(3); // + 2 + 3
    c2.multiple(2); // + 3 * 2

    c1.minus(1); // + 2 + 3 - 1
    c2.plus(7); // + 3 * 2 + 7

    c1.multiple(7); // + 2 + 3 - 1 * 7
    c2.divide(4); // + 3 * 2 + 7 / 4

    c1.divide(3); // + 2 + 3 - 1 * 7 / 3 = ?
    c2.minus(5); // + 3 * 2 + 7 / 4 - 5 = ?

    System.out.printf("c1.result = %d\n", c1.result);
    System.out.printf("c2.result = %d\n", c2.result);
  }
}

