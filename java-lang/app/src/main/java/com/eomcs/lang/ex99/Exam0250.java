package com.eomcs.lang.ex99;

//# 키보드 입력 받기 - 여러 개의 데이터를 한 번에 입력하고 쪼개서 읽기
//
public class Exam0250 {
  public static void main(String[] args) { 
    java.util.Scanner keyboardScanner = new java.util.Scanner(System.in);

    System.out.print("나이, 이름, 취업여부? ");
    int age = keyboardScanner.nextInt();

    // 한 개의 토큰을 읽을 때 유용하다.(앞쪽의 공백무시한다 여러개도 상관없음)
    String name = keyboardScanner.next();

    boolean working = keyboardScanner.nextBoolean();//토큰앞쪽공백 무시

    keyboardScanner.close();

    System.out.printf("%d, %s, %b\n", age, name, working);
  }
}















