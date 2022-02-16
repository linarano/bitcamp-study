// final 사용법: 파라미터
package com.eomcs.oop.ex06.e;

class G {
  public void m1(final int a) {
    // 파라미터는 메서드가 호출될 때 외부의 값을 받는 용도의 변수다.
    // 메서드 안에서 파라미터 값을 임의로 변경하게 되면
    // 처음 받은 파라미터 값을 사용하지 못하는 상황이 발생한다.
    // 그래서 이런 상황을 피하고자,
    // 보통 실무에서 파라미터를 final로 선언한다.
    //
    //    a = 200; // 컴파일 오류!

    System.out.println(a);
  }
}

public final class Exam0510 {
  public static void main(String[] args) {
    G g = new G();
    g.m1(100);
  }
}

//클린코드소개 - 파라미터 : 메소드가 일하는데 필요한 값을 받는 변수
//메서드가 한줄로 되어있는 경우는 거의없다. 
//파라미터 변수명을 중간에 바꿔버리면
//원래 파라미터값을 이용하려했던 코드가 망가진다.
//파라미터 변수는 메소드가 작업한느데 필요한 외부로부터 받기위해 존재하는 변수
//가공데이터 저장용도로 쓰는게 아님.
//final int a로 하면 값을 변경하지않아도됨 
//예를들자면 
//public void m1(final int value) {
// int result = value * value
//}