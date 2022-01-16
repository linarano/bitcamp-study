package com.eomcs.oop.ex05.x7;

public class Suv extends Car {

  boolean enabled4wd;

  Suv(boolean enabled4wd) {
    this.enabled4wd = enabled4wd;
  }


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
    System.out.println("고속도로를 달리자!");
  }

  public void enable() {

    if(enabled4wd) {
      System.out.println("4륜구동 ON!");
    } else {
      System.out.println("4륜구동 OFF");
    }

  }
}
