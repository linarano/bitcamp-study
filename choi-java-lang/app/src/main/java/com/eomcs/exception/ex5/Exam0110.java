// 예외 처리 전
package com.eomcs.exception.ex5;

import java.sql.Date;
import java.util.Scanner;

public class Exam0110 {

  static Board read() {
    try (Scanner keyScan = new Scanner(System.in)) {
      Board board = new Board();

      System.out.print("번호> ");
      board.setNo(Integer.parseInt(keyScan.nextLine()));

      System.out.print("제목> ");
      board.setTitle(keyScan.nextLine());

      System.out.print("내용> ");
      board.setContent(keyScan.nextLine());

      System.out.print("등록일> ");
      board.setCreatedDate(Date.valueOf(keyScan.nextLine()));// 사용자가 입력한 문자열을 가지고 날짜객체를 만든 것 

      return board;
    } 
  } //read()호출이 끝나면 닫는다. cl0se()
  //캐치문 안적으면 선언해야하는데... 컴파일러가 아무런 에러 안뜸. =>RuntimeException 의 자식이므로 가능 
  //throw를 안적어도 된다는 이야기지, 예외가 발생하지않는다는 의미가 아님. 받을때까지 끝까지 던진다. 

  public static void main(String[] args) {
    Board board = read();
    System.out.println("---------------------");
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("등록일: %s\n", board.getCreatedDate());
  }
}


