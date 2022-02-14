// Lambda 문법 - 람다 리턴
package com.eomcs.oop.ex12;

public class Exam0150 {

  interface Calculator {
    int compute(int a, int b);
  }

  public static void main(String[] args) {
    // 1) 리턴 값은 return 명령을 사용하여 처리한다.
    Calculator c1 = (a, b) -> { // 파라미터 타입 적어도 되고, 생략가능 파라미터 2개니까 괄호생략은 안됨  리턴문장 있을때는 괄호생략불가능 
      return a + b; //  리턴을 생략하지않으면 꼭 {} 적어줘야함 
    };
    System.out.println(c1.compute(10, 20));

    // 2) 한 문장으로 된 표현식(=값을 리턴하는 한 문장의 코드)인 경우 괄호 생략할 수 있다.
    // => 문장은 문장인데 값을 리턴하는 문장을 '표현식(expression)' 이라 부른다.
    // => 단 괄호를 생략할 때 return 키워드도 생략해야 한다. 있으면 컴파일 오류!
    Calculator c2 = (a, b) -> a - b; // 리턴이 생략된것
    System.out.println(c2.compute(10, 20));

    // Math.max()는 int 값을 리턴한다. 그래서 이 메서드를 호출하는 문장은 표현식이다. 
    Calculator c3 = (a, b) -> Math.max(a, b); // 리턴값 생략
    System.out.println(c3.compute(10, 20));

    // 값을 리턴해야 하는데 람다 문장에서 값을 리턴하지 않으면 컴파일 오류!
    //    Calculator c4 = (a, b) -> System.out.println(a + ",", b); // 컴파일 오류!
    //    System.out.println(c4.compute(10, 20));
  }

}


