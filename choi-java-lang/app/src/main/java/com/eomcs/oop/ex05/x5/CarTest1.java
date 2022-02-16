package com.eomcs.oop.ex05.x5;

public class CarTest1 {
  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    sedan.start();
    sedan.stop();
    sedan.run();

    System.out.println("---------------");
    Truck truck = new Truck();
    truck.start();
    truck.stop();
    truck.run();

  }
}
