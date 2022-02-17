// 예외 처리 후 - 생각해 볼 문제 
package com.eomcs.exception.ex5;

import java.sql.Date;
import java.util.Scanner;

public class Exam0121 {

  static Board read() throws RuntimeException {
    try (Scanner keyScan = new Scanner(System.in)) {
      Board board = new Board();

      System.out.print("번호> ");
      board.setNo(Integer.parseInt(keyScan.nextLine()));

      System.out.print("제목> ");
      board.setTitle(keyScan.nextLine());

      System.out.print("내용> ");
      board.setContent(keyScan.nextLine());

      System.out.print("등록일> ");
      board.setCreatedDate(Date.valueOf(keyScan.nextLine()));

      return board;
    }
  }

  public static void main(String[] args) {
    //이 프로그램을 실행할 때,
    // 1) 번호를 입력할 때 숫자가 아닌 것을 입력하면 NumberFormatException 예외가 발생한다.
    // 2) 날짜를 입력할때 yyy-MM-dd 형식에 맞지않게 입력하면 
    //예외 클래스이름을 보면 오류의 원인이 상세하게 나와있지만
    // 전체적인 그림에서 어떤 객체에서 발생된 예외인지 직관적으로 알 수가 없다. 
    Board board = read();
    System.out.println("---------------------");
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("등록일: %s\n", board.getCreatedDate());
  }
}


//     if (d == null) {
//throw new java.lang.IllegalArgumentException(); - 생성자에 아무것도 없음 getCreatedDate() - 에러메시지가 없음 
