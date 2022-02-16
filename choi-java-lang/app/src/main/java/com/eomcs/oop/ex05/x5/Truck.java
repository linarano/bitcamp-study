package com.eomcs.oop.ex05.x5;

public class Truck extends Car {

  @Override
  public void run() {
    System.out.println("덜컹덜컹 달린다!");
  }

}

//car class와 다르게  얘는 구체적으로 만들어야되 콘크리트클래스 