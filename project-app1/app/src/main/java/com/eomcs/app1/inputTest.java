package com.eomcs.app1;

public class inputTest {
  public static void main(String[] args) {


    java.util.Scanner keyboardScanner = new java.util.Scanner(System.in);

    // next()
    // - 토큰 단위로 입력 데이터를 잘라서 읽을 때 유용하다. 
    System.out.print(">");
    String token1 = keyboardScanner.next();
    String token2 = keyboardScanner.next();
    String token3 = keyboardScanner.next();

    keyboardScanner.close();

    System.out.printf("%s, %s, %s\n", token1, token2, token3);
  }

}