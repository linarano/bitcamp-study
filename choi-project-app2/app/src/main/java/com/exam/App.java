package com.exam;

import java.util.Scanner;
import com.exam.handler.ScoreHandler;
import com.exam.util.Prompt;

public class App {
  Scanner keyScan = new Scanner(System.in);

  ScoreHandler scoreHandler = new ScoreHandler();

  public static void main(String[] args) {
    new App().service();
  }

  public void service() {

    while (true) {
      printMenu();
      String input = Prompt.promptString("명령 >");

      if(checkQuit(input)) {
        break;
      }
      switch (input) {
        case "1": scoreHandler.create(); break;
        case "2": scoreHandler.list(); break;
        case "3": scoreHandler.detail(); break;
        case "4": scoreHandler.update(); break;
        case "5": scoreHandler.delete(); break;
        default:
          System.out.println("올바른 메뉴 번호를 입력하세요!");
      }
    }

    System.out.println("종료!");
    keyScan.close();
  }


  public void printMenu() {
    System.out.println("[메뉴]");
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 상세");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
  }


  public boolean checkQuit(String input) {
    return input.equals("quit") || input.equals("exit");
  }



}