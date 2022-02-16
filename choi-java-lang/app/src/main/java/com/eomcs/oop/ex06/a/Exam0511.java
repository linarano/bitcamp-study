// 다형성 - 다형적 변수와 instanceof 연산자
package com.eomcs.oop.ex06.a;

public class Exam0511 {

  public static void main(String[] args) {
    Vehicle v = new Sedan();

    // getClass() ?
    // => 레퍼런스가 가리키는 인스턴스의 실제 클래스 정보를 리턴한다.
    // => == 연산자를 사용하여 특정 클래스의 인스턴스인지 좁혀서 검사할 수 있다.*** 콕집어서 범위를 좁혀서 유용
    //
    // 클래스명.class
    // => 클래스 정보를 갖고 있는 스태틱 변수이다.
    //
    System.out.println(v.getClass() == Sedan.class); // 자바의 모든 클래스는 스태틱 변수를 가지고있다. 빌트인변수  this/super/class 예약어임 
    System.out.println(v.getClass() == Car.class); // 해당클래스정보 
    System.out.println(v.getClass() == Vehicle.class);
    System.out.println(v.getClass() == Truck.class);
    System.out.println(v.getClass() == Bike.class); // 인스턴스의 클래스정보를 리턴하여 비교 
  }

}




