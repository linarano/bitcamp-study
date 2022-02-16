// 다형성 - 다형적 변수와 instanceof 연산자
package com.eomcs.oop.ex06.a;

public class Exam0510 {

  public static void main(String[] args) {
    Vehicle v = new Sedan();

    // instanceof 연산자?
    // => 레퍼런스에 들어있는 주소가 특정 클래스의 인스턴스인지 검사한다.
    // => 또는 그 상위/하위 클래스의 인스턴스인지 검사한다.
    //
    System.out.println(v instanceof Sedan);
    System.out.println(v instanceof Car); // 슈퍼타입도 해당
    System.out.println(v instanceof Vehicle);
    System.out.println(v instanceof Object);

    System.out.println(v instanceof Truck); // 전혀 다른 타입 지정
    System.out.println(v instanceof Bike);
  }

}

//자바스크립트와 동일 - 생성자를 물어 어떤생성자를 통해서 초기화시켰냐는 의미



