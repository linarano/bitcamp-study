// 기존의 클래스를 손대지 않고 새 기능만 추가한다.
// 어떻게? 상속 문법을 이용한다.
package com.eomcs.oop.ex05.d;

public class Score2 extends Score {

  // 새 필드를 추가한다.
  public int music;
  public int art;


  // 기존 코드를 변경한다. => 기존의 메서드 재정의 => 오버라이딩(overriding)
  //**오버라이딩안붙이면 컴파일러는 검사해주지않음(개발자의실수를 줄일수있음). 새 메서드추가한것으로 오해함.
  @Override //재정의할껀데 문법검사좀해줘 - 컴파일러에게 재정의를 제대로했는지 검사해달라고 서비스를 요청하는 명령
  public void compute() {
    this.sum = this.kor + this.eng + this.math + this.music + this.art;
    this.aver = this.sum / 5f;
  }
}

//
////**오버라이딩 
//- 상속받은 메서드를 재정의하는 것. 재정의한 메서드를 사용
//메서드형식(메서드명,파라미터,리턴타입)이 같아야한다.(method signature)
//
//- c에서는 function prototype
//
//




