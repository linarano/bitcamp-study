package com.eomcs.oop.ex05.x7;

public class Truck extends Car {
  int weight;

  @Override
  public void start() {
    super.start();
  }

  @Override
  public void stop() {
    super.stop();
  }

  @Override
  public void run() {
    System.out.println("덜컹덜컹 언덕길을 1단으로 올라가자");
  }
  public void launch( ) {
    System.out.println("덜컹덜컹달리자!");
  }

  public void stopping( ) {
    System.out.println("조심조심 멈추자!");
  }

  public void dump( ) {
    System.out.println("우당탕탕 적재물을 내리자!");
  }

}
