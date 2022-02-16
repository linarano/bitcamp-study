package com.eomcs.oop.ex05.a;

public class Car {

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
  }// 인스턴스를 쓰지않으면 굳이 인스턴스메서드로 선언할필요없다. 하지만 지금배우는거니까 일단 인스턴스메소드로 만듬
}


