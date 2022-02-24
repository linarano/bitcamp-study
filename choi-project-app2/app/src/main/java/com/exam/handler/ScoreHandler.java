package com.exam.handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.exam.util.Prompt;
import com.exam.vo.Score;

public class ScoreHandler {
  ArrayList<Score> scores = new ArrayList<>();


  public ScoreHandler() {
    try (BufferedReader in = new BufferedReader(new FileReader("./score.csv"));) {
      String line;
      while ((line = in.readLine()) != null) {
        scores.add(Score.fromCSV(line));
      }
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }
  }

  private void save() {
    try (PrintWriter out = new PrintWriter(new FileWriter("./score.csv"));) {
      for (Score score : scores) {
        out.println(score.toCSV());
      }
    } catch (Exception e) {
      System.out.println("데이터 저장 중 오류 발생!");
    }
  }

  public void create() {
    Score score = new Score();
    score.setName(Prompt.promptString("이름?"));
    score.setKor(Prompt.promptInt("국어?"));
    score.setEng(Prompt.promptInt("영어?"));
    score.setMath(Prompt.promptInt("수학?"));

    scores.add(score);
  }

  public void list() {
    int count = 0;
    //for( : 배열또는 Iterable  구현체) //  index가 필요없어서 편하다.
    for(Score score : scores) {
      System.out.printf("%d: %s, %d, %.1f\n" , 
          count++,
          score.getName(),
          score.getSum(),
          score.getAverage());
    }
  }

  public void detail() {
    int no = Prompt.promptInt("번호?");
    if(no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지않습니다.");
      return;
    }

    //  객체에 값 꺼내기 => 인스턴스 필드에 직접 접근 제한, 캡슐화를 통해 접근제어 
    //   "필드에 직접 사용하는 것보다 각 메서드를 통해서 필드를 사용하는게 낫다."
    // 왜?
    // => 이유 1) 필드 값에 대해서 조건문을 추가하는 방법으로 세밀하게 조정할 수 있음 , 
    //              직접 필드값을 사용하면 나중에 유지보수가 어려움
    // => 이유 2) 무효한 필드 값을 변경하는 것을 막을 수 없음. 메서드를 통해서 값을 집어넣으면 어느정도 막을 수 있음.  
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

  public void update() {
    int no = Prompt.promptInt("번호?");
    if(no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지않습니다.");
      return;
    }
    Score old = scores.get(no);

    Score score = new Score();
    score.setName(Prompt.promptString("이름(%s)? ", old.getName()));
    score.setKor(Prompt.promptInt("국어(%d)? ", old.getKor()));
    score.setEng(Prompt.promptInt("영어(%d)? ", old.getEng()));
    score.setMath(Prompt.promptInt("수학(%d)? ", old.getMath()));

    scores.set(no, score);
  }

  public void delete() {
    int no = Prompt.promptInt("번호?");
    if(no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지않습니다.");
      return;
    }

    scores.remove(no);
  }



}
