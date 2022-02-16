package com.eomcs.oop.ex05.x7;

public abstract class Option extends Car {

  @Override
  public void start() {
    // TODO Auto-generated method stub
    car.start();
  }

  @Override
  public void stop() {
    car.stop();
  }
}
