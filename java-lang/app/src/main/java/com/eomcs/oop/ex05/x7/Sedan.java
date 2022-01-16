package com.eomcs.oop.ex05.x7;

public class Sedan extends Car {

  boolean openedSunroof; // 이걸 어떻게 구현하지? // 카테스트2에서정의?

  @Override
  public void run() {
    System.out.println("씽씽 신나게 달려보자 바다로!");

  }

  public void openSunroof(boolean openedSunroof) {
    if(openedSunroof) {
      System.out.println("썬루프 오픈");
    } else {
      System.out.println("썬루프 덮어");
    }

  }
}
