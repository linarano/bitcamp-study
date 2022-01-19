package com.eomcs.oop.ex05.l;

public class Car { // 직접 사용하려고 만든 클래스가 아니라 임의로 만든 클래스 - 세단과 트럭의 공통점을 추출한 것일뿐.

  public Car() {
    super();
  }

  public void start() {
    System.out.println("시동 건다!");
  }

  public void shutdown() {
    System.out.println("시동 끈다!");
  }

  public void run() {
    System.out.println("달린다.");
  }

}