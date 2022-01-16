package com.eomcs.oop.ex05.x7;

public class CarTest2 {

  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    testSedan(sedan);

    System.out.println("-----------------------");

    Truck truck = new Truck();
    testTruck(truck);

    System.out.println("-----------------------");

    Suv suv = new Suv(false);
    testSuv(suv);

  }

  static void testSedan(Sedan sedan) {
    sedan.start();
    sedan.openSunroof(true);
    sedan.stop();
    sedan.run();
  }

  static void testTruck(Truck truck) {
    truck.launch();
    truck.stopping();
    truck.dump();
  }

  static void testSuv(Suv suv) {
    suv.start();
    suv.stop();
    suv.run();
    suv.enable();
  }

}
