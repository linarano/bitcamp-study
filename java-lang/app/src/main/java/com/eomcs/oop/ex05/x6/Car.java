package com.eomcs.oop.ex05.x6;

public abstract class Car { //직접 인스턴스를 만들수 없다. 서브클래스의 관리목적이다. 서브클래스에서 정의해라. -유지보수용이다. 
  int cc;
  int valve;

  public void start( ) {
    System.out.println("부릉부릉!");
  }
  public void stop( ) {
    System.out.println("멈추자!");
  }
  public abstract void run( );
}
