package com.eomcs.oop.ex05.x5;

public abstract class Car {
  public void start() {
    System.err.println("시동건다!");
  }
  public void stop() {
    System.err.println("시동끈다!");
  }// 기본기능이므로 구현 
  public abstract void run();

}
// car 클래스 기본기능만 갖어라.