package com.eomcs.oop.ex05.j;

public class Car { // 만든 후에 조금더 특별한 기능이 필요했음=> 상속(전문화), 차 클래스를 쓰고있었음 

  public String model;
  public String maker;
  public int capacity;

  public Car() {}

  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public void run() {
    System.out.println("달린다!");
  }
}


