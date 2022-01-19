package com.eomcs.oop.ex05.x6;

public class Truck extends Car {

  int weight;
  // 얼마만큼 내렸나 - 게임같은거 그렇게 인스턴스필드를 추가할 수도 있곘지 
  @Override
  public void run( ) {
    this.go();
  }

  @Override
  public void start( ) {
    this.launch(); // 기존의 것을 호출한다. 
  }
  @Override
  public void stop( ) {
    this.stopping();
  }

  public void launch( ) {
    System.out.println("트럭출발!");
  }

  public void go( ) {
    System.out.println("덜컹덜컹달리자!");
  }

  public void stopping( ) {
    System.out.println("조심조심 멈추자!");
  }

  public void dump( ) {
    System.out.println("우당탕탕 적재물을 내리자!");
  }
}

// 문법을 암기하면 뭐하나
//단순한 문법을 프로그래밍 하는데 겁내지말기.
//50일 남음. 
//이제얼마안남음 

//유지보수 -중복코드 제거 
// 추상메서드가 있으면 추상클래스가 있어야함. 
//일반클래스는 추상메서드못가짐


//과거시스템과 연결(레거시) - 현업에 가면 이런 경우가 많음