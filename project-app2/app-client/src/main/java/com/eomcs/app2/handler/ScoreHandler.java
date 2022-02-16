package com.eomcs.app2.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.app2.vo.Score;
import com.eomcs.util.Prompt;

public class ScoreHandler { // 데이터 저장 =-> 서버할일  서버에서 꺼내라 
  ObjectInputStream in;
  ObjectOutputStream out;

  public ScoreHandler(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }


  public void create() throws Exception { // 서버와 클라이언트 간 프로토콜대로 움직인다! 
    Score score = new Score();
    score.setName( Prompt.promptString("이름?")); // 실행순서 확인! 스트링을 입력받는 프롬프트 - 실행되고 값이 놓이면 호출 // 객체주소 -어레이리스트 
    score.setKor( Prompt.promptInt("국어?"));
    score.setEng( Prompt.promptInt("영어?"));
    score.setMath( Prompt.promptInt("수학?"));

    out.writeUTF("insert"); // 서로 약속이 맞아야되 -> switch문서버
    out.writeObject(score);
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) {
      int count = in.readInt();
      if(count == 1) {
        System.out.println("입력했습니다.");
      }else {
        System.out.println("입력하지 못했습니다.");
      }
    }else {
      System.out.println(in.readUTF()); // 서버에서 보낸 에러
    }
  }


  public void list() throws Exception {

    out.writeUTF("selectlist");
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) {
      Score[] scores = (Score[])in.readObject();// 배열을 리턴함 
      int count = 0;
      for (Score score : scores) {// 배열또는 Iterable  구현체 - 객체리턴 - 반복문을 끝까지 돈다.  index가 필요없어서 편하다.
        System.out.printf("%d: %s, %d, %.1f\n",
            count++, // 먼저 번호 보여주고, 후위연산자 
            score.getName(), 
            score.getSum(),
            score.getAverage());
      }

    } else {
      System.out.println(in.readUTF()); // 서버에서 보낸 에러
    }
  }

  public void detail() throws Exception {
    int no = Prompt.promptInt("번호?"); 

    out.writeUTF("selectOne");
    out.writeInt(no);
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) {
      Score score = (Score)in.readObject();
      System.out.printf("이름 : %s\n", score.getName());
      System.out.printf("국어 : %d\n", score.getKor());
      System.out.printf("영어 : %d\n", score.getEng());
      System.out.printf("수학 : %d\n", score.getMath());
      System.out.printf("합계 : %d\n", score.getSum());
      System.out.printf("평균 : %.1f\n", score.getAverage());

    }else {
      System.out.println(in.readUTF()); // 서버에서 보낸 에러
    }

  }

  public void update() throws Exception {// 밖같에 호출한 쪽으로 예외 던져(책임넘기기)- 굳이 여기 메서드에서 처리할 필요 없다.  
    int no = Prompt.promptInt("번호?"); // 원시타입은 tostring -> string 바꿀 수 있음 

    out.writeUTF("selectOne");// 조회먼저
    out.writeInt(no);
    out.flush();



    String status = in.readUTF();
    if (status.equals("success")) {
      Score score = (Score)in.readObject();
      Score score = new Score(); // 가변파라미터로 바꾸자  VariableArityParameter: {VariableModifier} UnannType {Annotation} ... Identifier
      score.setName( Prompt.promptString("이름(%s)?", old.getName())); // 스트링을 입력받는 프롬프트 - 실행되고 값이 놓이면 호출 // 객체주소 -어레이리스트 
      score.setKor( Prompt.promptInt("국어(%d)?", old.getKor()));
      score.setEng( Prompt.promptInt("영어(%d)?", old.getEng()));
      score.setMath( Prompt.promptInt("수학(%d)?", old.getMath())); // 내부적으로 처리 - 똑같은 코드를 여러번 반복하지 못하도록 -String.format printf와 같이 형식을 주자

      out.writeUTF("update");// 조회먼저
      out.writeInt(no);
      out.writeInt(score);
      out.flush();
      // 주거니받거니 대화 - 데이터타입 통일해줘여함
      status = in.readUTF(); // 상태정보를 받아서
      if (status.equals("success")) {
        int count = in.readInt();
        if(count == 1) {
          System.out.println("입력했습니다.");
        }else {
          System.out.println("입력하지 못했습니다.");
        }
      }else {
        System.out.println(in.readUTF()); // 서버에서 보낸 에러
      }


    }else {
      System.out.println(in.readUTF()); // 서버에서 보낸 에러
    }

  }

  public void delete() {
    int no =  Prompt.promptInt("번호?"); // 원시타입은 tostring -> string 바꿀 수 있음 

    out.writeUTF("delete");// 조회먼저
    out.writeInt(no);
    out.flush();

    String status = in.readUTF(); // 상태정보를 받아서
    if (status.equals("success")) {
      int count = in.readInt(); 
      if(count == 1) {
        System.out.println("입력했습니다.");
      }else {
        System.out.println("입력하지 못했습니다.");
      }
    }else {
      System.out.println(in.readUTF()); // 서버에서 보낸 에러
    }
  }

}

//업데이트/삭제/인서트 -> int리턴 :Jdbc 경험!@
