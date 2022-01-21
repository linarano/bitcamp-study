// Wrapper 클래스 - 오토박싱(auto-boxing)/오토언박싱(auto-unboxing)****
package com.eomcs.basic.ex02;

public class Exam0220 {
  public static void main(String[] args) {

    // 다음과 같이 프로그래밍 중에
    // primitive type의 값을 인스턴스에 담고("박싱(boxing)"이라 부른다)
    // 인스턴스의 담긴 primitive 값을 다시 꺼내는 일("언박싱(unboxing)"이라 부른다)은
    // 매번 메서드호출 매우 불편한다.

    // int값에서 ==> Integer 객체를 만들때 
    int i1 = 100;
    Integer obj1 = Integer.valueOf(i1);

    // Integer 객체에서 ==> int값을 뽑아낼 때
    Integer obj2 = Integer.valueOf(200);
    int i2 = obj2.intValue();

  }
}




//컴파일러가 변경한다.
//레퍼런스가 들어갈 자리에 어떻게 값이 들어가나
//마치 객체를 자동으로 변경하는 것처럼 코드가 변경되는 것. 우리를 대신해서 컴파일러가 변경
//인스턴스생성하는 코드로 변경한다. 
//Integer obj =100; ==> Integer.valueOf(100);(오토박싱)

//int v = obj; => obj.intValue(); 값을 꺼내는 코드로 바꿔줌 컴파일러는 코드를 변경한다. ( 마치 인스턴스에서 값을 꺼내는 것같이)\
//오토언박싱

