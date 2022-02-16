package com.eomcs.oop.ex05.x4.app2;

import com.eomcs.oop.ex05.x4.app1.Car;

public class Truck extends Car { // 다른 프로그램에서  쓰고있는 소스코드를 재사용- 코드의 재사용성

  public void dump () {
    System.out.println("짐내린다!");
  }
}
