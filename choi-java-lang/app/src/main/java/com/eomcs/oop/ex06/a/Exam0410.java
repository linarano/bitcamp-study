// 다형성 - 다형적 변수의 활용
package com.eomcs.oop.ex06.a;

public class Exam0410 {

  // Sedan과 Truck의 모델명과 cc를 출력하라!

  public static void printSedan(Sedan sedan) {// 세단 종류의 객체주소를 가리킨다. - 세단과 그 하위객체를 모두 담을 수 있다. 
    System.out.printf("모델명: %s\n", sedan.model); // Vehicle의 설계도로 만든 인스턴스 변수
    System.out.printf("cc: %d\n", sedan.cc); // Car 설계도로 만든 인스턴스 변수
    System.out.println("-------------------------");
  }

  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    sedan.model = "티코";
    sedan.cc = 800;

    Truck truck = new Truck();
    truck.model = "타이탄II";
    truck.cc = 10000;

    printSedan(sedan);

    // printSedan()의 파라미터는 Sedan 객체의 주소만 받을 수 있다.
    // 그래서 Truck 객체를 전달할 수 없다.(전혀상관없음)
    //    printSedan(truck); // 컴파일 오류!

    // Truck 인스턴스에서 model과 cc 값을 꺼내서 출력할 메서드를
    // 따로 만들어야 한다. 파라미터의 데이터타입이 Sedan
  }

}




// 어떤 클래스의 레퍼런스는 그 타입의 객체(뿐만 아니라 하위타입을 다 담을 수있다.)
// 어떤 클래스의 객체를 담을 수 있는 것. Object (최상위 클래스 )
// Object obj = new String();
// 레퍼런스를 만나면 - 레퍼런스타입을 봐라.
//printStream(out) -그 하위 콘크리트 클래스/abstract class의 반대 
//생성자의 파라미터의 클래스가 abstract로 되어있으면 인트턴스를 못만든다는게 아니라// 그 하위클래스를 넘겨주면됨.(다형성변수) - 유연성
//상위타입을 주면 유연성을 주는 것. 