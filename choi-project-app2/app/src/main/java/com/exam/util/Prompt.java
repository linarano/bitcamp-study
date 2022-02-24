package com.exam.util;

import java.util.Scanner;

public class Prompt {

  static Scanner keyScan = new Scanner(System.in);

  // 1) 캡슐화 => 다른 클래스에서 해당 메서드를 사용할 때 쉽게 사용  Prompt.promptString(); // String.format();
  // 2) 가변 파라미터 
  public static String promptString(String titleFormat, Object... args) {
    System.out.print(String.format(titleFormat, args));
    return keyScan.nextLine();
  }

  public static int promptInt(String titleFormat, Object... args) {
    return Integer.parseInt(promptString(titleFormat, args));
  }

}


/*
 public void update() {
    int no = Prompt.promptInt("번호?");
    if(no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지않습니다.");
      return;
    }
    Score old = scores.get(no);

    Score score = new Score();

    //해당 메서드를 가변파라미터로 선언해서 파라미터 값을 2개 받을 수 있었음 
    score.setName(Prompt.promptString("이름(%s)? ", old.getName()));
    score.setKor(Prompt.promptInt("국어(%d)? ", old.getKor()));
    score.setEng(Prompt.promptInt("영어(%d)? ", old.getEng()));
    score.setMath(Prompt.promptInt("수학(%d)? ", old.getMath()));

    scores.set(no, score);
  }


 */