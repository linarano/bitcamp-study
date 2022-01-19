package com.eomcs.oop.ex05.x4.app5;

import com.eomcs.oop.ex05.x4.app4.HybridCar;

public class HybridTruck extends HybridCar{

  public void dump () {
    System.out.println("짐내린다!"); // 
  }

}


//(코드중복발생)다중상속이 가능했다면 가능하지만
//자바는 안됨
//트럭의 덤프를 상속