// 오버라이딩(overriding) - 리턴 타입 :똑같지 않아도 됨
package com.eomcs.oop.ex06.c;

public class Exam0610 {

  static class Car {}
  static class Sedan extends Car {}
  static class Tico extends Sedan {}
  static class Truck extends Car {}
  static class CarFactory {
    Car create() {  //return type Car
      return new Car();
    }
  }

  static class SedanFactory extends CarFactory {
    // 오버라이딩 메서드의 리턴 타입은 달라도된다. 단, 서브타입이어야한다. (실무용어)
    // 서브 클래스도 가능하다.

    // String create() { // 메서드시그니처는 동일하나 리턴타입이 다른경우 : 리턴타입이 달라도 오버라이딩가능? Sedan이 된 이유 - 하위클래스이므로 가능 
    // return new  String ();
    @Override
    Sedan create() { // 메서드시그니처는 동일하나 리턴타입이 다른경우 : 리턴타입이 달라도 오버라이딩가능? Sedan이 된 이유 - 하위클래스이므로 가능 
      return new  Sedan();
    }
  }

  static class TicoFactory extends SedanFactory {
    // 오버라이딩 메서드의 리턴 타입은 
    // 서브 클래스도 가능하다.
    @Override
    Tico create() {
      return new Tico  (); // truck은 세단의 서브클래스가 아니기때문에 , 리턴타입이 같거나 서브클래스일 때만 허락한다. 
    }
  }


  public static void main(String[] args) {

  }
}








