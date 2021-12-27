package com.eomcs.lang.ex07;

// # 메서드 : 가변 파라미터
//
public class Exam0251 {

  // 가변 파라미터에 배열을 넘길 경우
  //기존 배열을 그대로 사용할까? 아니면 파라미터로 받은 배열을 복제해서 사용할까?
  // 가변 파라미터에 배열을 넘길 경우 그 배열을 그대로 받아 사용한다.
  static void hello(String... names) {

    for (int i = 0; i < names.length; i++) {// 내부적으로 배열처럼 쓴다.
      names[i] += "^^"; //기존 배열의 값에다가 붙이자

      System.out.printf("%s님 반갑습니다.\n", names[i]);
    }
  }

  public static void main(String[] args) {

    // 가변 파라미터 자리에 배열을 직접 넣어도 된다.
    String[] arr = {"김구", "안중근", "윤봉길", "유관순"}; //낱개를 4개 만들어 준것과 같다.

    // 가변 파라미터에 배열을 넘길 경우
    hello(arr);
    System.out.println("-------------------");

    for (String value : arr) {
      System.out.println(value);
    }

  }
}