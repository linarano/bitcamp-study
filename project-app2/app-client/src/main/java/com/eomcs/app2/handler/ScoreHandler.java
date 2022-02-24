package com.eomcs.app2.handler;

import com.eomcs.app2.net.ScoreTableProxy;
import com.eomcs.app2.vo.Score;
import com.eomcs.util.Prompt;

//  이런 것들도 캡슐화의 예
//  어떤 네트워크통신 프로그램 없음 - 캡슐화되어서 대행자가 알아서 한다.
public class ScoreHandler { 

  ScoreTableProxy scoreTable; // 스코어테이블의 대행자 

  public ScoreHandler(ScoreTableProxy scoreTabl) {
    this.scoreTable = scoreTable;
  }


  public void create() throws Exception { 
    Score score = new Score();
    score.setName( Prompt.promptString("이름?")); // 실행순서 확인! 스트링을 입력받는 프롬프트 - 실행되고 값이 놓이면 호출 // 객체주소 -어레이리스트 
    score.setKor( Prompt.promptInt("국어?"));
    score.setEng( Prompt.promptInt("영어?"));
    score.setMath( Prompt.promptInt("수학?"));

    scoreTable.insert(score); // 클라이언트에서 거르므로 - 예외 상황 거리므로 여기서는 거를 필요없다.

    String status = in.readUTF();
    int count = in.readInt();
    if(count == 1) {
      System.out.println("입력했습니다.");
    }else {
      System.out.println("입력하지 못했습니다.");
    }
  }


  public void list() throws Exception {

    Score[] scores = (Score[]) scoreTable.selectlist();// 배열을 리턴함 
    int count = 0;
    for (Score score : scores) {// 
      System.out.printf("%d: %s, %d, %.1f\n",
          count++, // 먼저 번호 보여주고, 후위연산자 
          score.getName(), 
          score.getSum(),
          score.getAverage());
    }
  }
  // 서버와 통신하는 규칙을 더 신경안쓰고 ->통신코드가 알아서 함
  public void detail() throws Exception {
    int no = Prompt.promptInt("번호?"); 

    Score score = scoreTable.selectOne(no);
    System.out.printf("이름 : %s\n", score.getName());
    System.out.printf("국어 : %d\n", score.getKor());
    System.out.printf("영어 : %d\n", score.getEng());
    System.out.printf("수학 : %d\n", score.getMath());
    System.out.printf("합계 : %d\n", score.getSum());
    System.out.printf("평균 : %.1f\n", score.getAverage());

  } // 서버개발자가 캡슐화해서 통신방법을 주면 - 클라이언트 개발자는 이용만 한다. 

  public void update() throws Exception {// 밖같에 호출한 쪽으로 예외 던져(책임넘기기)- 굳이 여기 메서드에서 처리할 필요 없다.  
    int no = Prompt.promptInt("번호?"); // 원시타입은 tostring -> string 바꿀 수 있음 

    Score old = scoreTable.selectOne(no);

    Score score = new Score(); // 가변파라미터로 바꾸자  VariableArityParameter: {VariableModifier} UnannType {Annotation} ... Identifier
    score.setName( Prompt.promptString("이름(%s)?", old.getName())); // 스트링을 입력받는 프롬프트 - 실행되고 값이 놓이면 호출 // 객체주소 -어레이리스트 
    score.setKor( Prompt.promptInt("국어(%d)?", old.getKor()));
    score.setEng( Prompt.promptInt("영어(%d)?", old.getEng()));
    score.setMath( Prompt.promptInt("수학(%d)?", old.getMath())); // 내부적으로 처리 - 똑같은 코드를 여러번 반복하지 못하도록 -String.format printf와 같이 형식을 주자

    int count = scoreTable.update(no, score);
    if(count == 1) {
      System.out.println("업데이트했습니다.");
    }else {
      System.out.println("업데이트했습니다.");
    }
  }


  public void delete() {
    int no =  Prompt.promptInt("번호?"); // 원시타입은 tostring -> string 바꿀 수 있음 

    int count = scoreTable.delete(no); 
    if(count == 1) {
      System.out.println("입력했습니다.");
    }else {
      System.out.println("입력하지 못했습니다.");
    }
  }

}

//업데이트/삭제/인서트 -> int리턴 :Jdbc 경험!@
