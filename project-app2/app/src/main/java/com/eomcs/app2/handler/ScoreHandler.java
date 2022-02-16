package com.eomcs.app2.handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.eomcs.app2.vo.Score;
import com.eomcs.util.Prompt;

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
    score.setName(Prompt.promptString("이름? "));
    score.setKor(Prompt.promptInt("국어? "));
    score.setEng(Prompt.promptInt("영어? "));
    score.setMath(Prompt.promptInt("수학? "));

    scores.add(score);
    save();
  }

  public void list() {
    int count = 0;
    for (Score score : scores) {
      System.out.printf("%d: %s, %d, %.1f\n",
          count++,
          score.getName(), 
          score.getSum(),
          score.getAverage());
    }
  }

  public void detail() {
    int no = Prompt.promptInt("번호? ");
    if (no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Score score = scores.get(no);
    System.out.printf("이름: %s\n", score.getName());
    System.out.printf("국어: %d\n", score.getKor());
    System.out.printf("영어: %d\n", score.getEng());
    System.out.printf("수학: %d\n", score.getMath());
    System.out.printf("합계: %d\n", score.getSum());
    System.out.printf("평균: %.1f\n", score.getAverage());
  }

  public void update() {
    int no = Prompt.promptInt("번호? ");
    if (no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    Score old = scores.get(no);

    Score score = new Score();
    score.setName(Prompt.promptString("이름(%s)? ", old.getName()));
    score.setKor(Prompt.promptInt("국어(%d)? ", old.getKor()));
    score.setEng(Prompt.promptInt("영어(%d)? ", old.getEng()));
    score.setMath(Prompt.promptInt("수학(%d)? ", old.getMath()));

    scores.set(no, score);
    save();
  }

  public void delete() {
    int no = Prompt.promptInt("번호? ");
    if (no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다.");
      return;
    }

    scores.remove(no);
    save();
  }
}


/*

public class ScoreHandler {
  ArrayList<Score> scores = new ArrayList<>();

  public ScoreHandler() {
    try (BufferedReader in = new BufferedReader(new FileReader("./score.csv"));) {
      String line;
      while ((line = in.readLine()) != null) {
        scores.add(Score.fromCSV(line)); //스코어객체-> 따로 분리, 훨씬 코드가 간결해진다.  
      }
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }
  }

  private void save() {
    try(PrintWriter out = new PrintWriter(new FileWriter("./score.csv"));) {// autoclosable 구현체 
      for(Score score :scores) {
        out.println(score.toCSV()); //따로 뽑을 필요없다
      }
    }catch (Exception e) {
      System.out.println("데이터 저장 중 오류 발생!");
    }
  }

  public void create() {
    Score score = new Score();
    score.setName( Prompt.promptString("이름?")); // 실행순서 확인! 스트링을 입력받는 프롬프트 - 실행되고 값이 놓이면 호출 // 객체주소 -어레이리스트 
    score.setKor( Prompt.promptInt("국어?"));
    score.setEng( Prompt.promptInt("영어?"));
    score.setMath( Prompt.promptInt("수학?"));

    scores.add(score);  
    save();
  }


  public void list() {
    int count = 0;
    for (Score score : scores) {// 배열또는 Iterable  구현체 - 객체리턴 - 반복문을 끝까지 돈다.  index가 필요없어서 편하다.
      System.out.printf("%d: %s, %d, %.1f\n",
          count++, // 먼저 번호 보여주고, 후위연산자 
          score.getName(), 
          score.getSum(),
          score.getAverage());
    }
  }

  public void detail() {
    int no = Prompt.promptInt("번호?"); // 원시타입은 tostring -> string 바꿀 수 있음 
    if(no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다.");
      return; // 메서드를 나가도록 - 예외는 무미건조한 에러를 띄울뿐.,... 예외발생 전 사전조치  // 예외까지 가지않고 여기서 걸러낸느 방법 
    }

    Score score = scores.get(no);
    System.out.printf("이름 : %s\n", score.getName());
    System.out.printf("국어 : %d\n", score.getKor());
    System.out.printf("영어 : %d\n", score.getEng());
    System.out.printf("수학 : %d\n", score.getMath());
    System.out.printf("합계 : %d\n", score.getSum());
    System.out.printf("평균 : %.1f\n", score.getAverage());
  }

  public void update() {
    int no = Prompt.promptInt("번호?"); // 원시타입은 tostring -> string 바꿀 수 있음 
    if(no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다.");
      return; // 메서드를 나가도록 - 예외는 무미건조한 에러를 띄울뿐.,... 예외발생 전 사전조치  // 예외까지 가지않고 여기서 걸러낸느 방법 
    }
    Score old = scores.get(no); // 유효한번호- 예전꺼

    Score score = new Score(); // 가변파라미터로 바꾸자  VariableArityParameter: {VariableModifier} UnannType {Annotation} ... Identifier
    score.setName( Prompt.promptString("이름(%s)?", old.getName())); // 스트링을 입력받는 프롬프트 - 실행되고 값이 놓이면 호출 // 객체주소 -어레이리스트 
    score.setKor( Prompt.promptInt("국어(%d)?", old.getKor()));
    score.setEng( Prompt.promptInt("영어(%d)?", old.getEng()));
    score.setMath( Prompt.promptInt("수학(%d)?", old.getMath())); // 내부적으로 처리 - 똑같은 코드를 여러번 반복하지 못하도록 -String.format printf와 같이 형식을 주자

    scores.set(no, score);// 옛날꺼를 새로 대체
    save();
  }

  public void delete() {
    int no =  Prompt.promptInt("번호?"); // 원시타입은 tostring -> string 바꿀 수 있음 
    if(no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다.");
      return; // 메서드를 나가도록 - 예외는 무미건조한 에러를 띄울뿐.,... 예외발생 전 사전조치  // 예외까지 가지않고 여기서 걸러낸느 방법 

    }

    scores.remove(no);
    save();// 매번 저장 가장 무식한 방법 - 바람직하진 않음 
  }
}

 */