package com.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
  Scanner keyScan = new Scanner(System.in);
  ArrayList<Score> scores = new ArrayList<>();

  public static void main(String[] args) {
    new App().service();
  }

  public void service() {

    while (true) {
      printMenu();
      String input = promptString("명령 >");

      if(checkQuit(input)) {
        break;
      }
      switch (input) {
        case "1": createScore(); break;
        case "2": listScore(); break;
        case "3": detailScore(); break;
        case "4": updateScore(); break;
        case "5": deleteScore(); break;
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

  public String promptString(String title) {
    System.out.print(title);
    return keyScan.nextLine();
  }

  public int promptInt(String title) {
    return Integer.parseInt(promptString(title));
  }

  public boolean checkQuit(String input) {
    return input.equals("quit") || input.equals("exit");
  }

  private void createScore() {
    Score score = new Score();
    score.setName(promptString("이름?"));
    score.setKor(promptInt("국어?"));
    score.setEng(promptInt("영어?"));
    score.setMath(promptInt("수학?"));

    scores.add(score);
  }
  private void listScore() {
    int count = 0;
    for(Score score:scores) {
      System.out.printf("%d: %s, %d, %d, %d, %d, %.1f\n" , 
          count++,
          score.getName(),
          score.getKor(),
          score.getEng(),
          score.getMath(),
          score.getSum(),
          score.getAverage());
    }
  }

  private void detailScore() {
    int no = promptInt("번호?");
    if(no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지않습니다.");
      return;
    }

    //객체에 값 꺼내기 =>  캡슐화를 통해 접근제어 
    //
    //  인스턴스 필드에 직접접근 제한 ->필드에 직접 사용하는 것보다 각 메서드를 통해서 필드를 사용하는게 낫다.
    // 이유 - 1) 필드 값에 대해서 조건문을 추가하는 방법으로 세밀하게 조정할 수 있음 , 직접 필드값을 사용하면 나중에 유지보수가 어려움
    //  이유 - 2) 무효한 필드 값을 변경하는 것을 막을 수 없음. 메서드를 통해서 값을 집어넣으면 어느정도 막을 수 있음.  
    //
    //
    Score score = scores.get(no); 
    System.out.printf("이름 : %s\n", score.getName());
    System.out.printf("국어 : %d\n", score.getKor());
    System.out.printf("영어 : %d\n", score.getEng());
    System.out.printf("수학 : %d\n", score.getMath());
    System.out.printf("합계 : %d\n", score.getSum());
    System.out.printf("평균 : %.1f\n", score.getAverage());

  }

  private void updateScore() {
    int no = promptInt("번호?");
    if(no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지않습니다.");
      return;
    }
    Score old = scores.get(no);

    Score score = new Score();
    score.setName(promptString(String.format("이름(%s)? ", old.getName())));
    score.setKor(promptInt(String.format("국어(%d)? ", old.getKor())));
    score.setEng(promptInt(String.format("영어(%d)? ", old.getEng())));
    score.setMath(promptInt(String.format("수학(%d)? ", old.getMath())));

    scores.set(no, score);
  }

  private void deleteScore() {
    int no = promptInt("번호?");
    if(no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지않습니다.");
      return;
    }

    scores.remove(no);
  }

}