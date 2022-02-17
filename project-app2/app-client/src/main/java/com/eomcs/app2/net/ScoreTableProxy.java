package com.eomcs.app2.net;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import com.eomcs.app2.vo.Score;

// 서로 대화나누는 코드를 서버개발자가 개발해주자
// 클라이언트가 각 서버프로그램 마다 통신할떄 통신규칙이 다르므로, 통신규칙을 다시 짜야한다. 
// 클라이언트가 통신규칙을 몰라도
//서버개발자가 통신규칙을 만들어 클래스로 제공한다. 

//통신은 걱정하지마라 클라이언트개발자가 했던일을 서버개발자가 
//서버개발자가 통신을더 잘암 
//클라이언트개발자야 넌 내가 만든걸 쓰기만 해 
// 난 지금 서버개발자 

public class ScoreTableProxy {

  Socket socket;
  ObjectOutputStream out;
  ObjectInputStream in;

  public ScoreTableProxy(String host, int port) throws Exception {

    socket = new Socket(host,port);//192.168.0.23
    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream()); 


    public void close() { // 각각 따로따로 닫아줘야됨 + 가장 중요한 연결끊기 
      try { 
        out.wirteUTF("quit");
        out.flush();
      } catch (Exception e){
        // 종료할 때 에러는 무시한다.
      }
    } finally {
      try{out.close(); }catch (Exception e) {}
      try{in.close(); }catch (Exception e) {}
      try{socket.close(); }catch (Exception e) {}
    }
  }
  public int insert(Score score) throws Exception { // 인스턴스메서드로 바꾸자 

    try{out.writeUTF("insert"); // 서로 약속이 맞아야되 -> switch문서버
    out.writeObject(score);
    out.flush();

    String status = in.readUTF();
    if (status.equals("success")) {
      return in.readInt(); // 몇개 리턴했는지 알려줌 
    }else {
      throw new RuntimeException(in.readUTF()); // 서버에서 보낸 에러 -> 문자열로 읽어서 
    }
    } catch (Exception e) {
      throw new ScoreTableException(e); //예외를 포장해서 다시 인서트 호출한 쪽으로 던진다 
    }
  }

  public  Score[] selectList() { //인스턴스 필드 쓰니까 인스턴스메서드 
    try {
      out.writeUTF("selectlist");//서버에 보내고 
      out.flush();

      String status = in.readUTF();
      if (status.equals("success")) {
        return (Score[])in.readObject();// 배열을 리턴함 
      }else {
        throw new RuntimeException(in.readUTF()); // 서버에서 보낸 에러 -> 문자열로 읽어서 (에러사유)
      }
    } catch (Exception e) {
      throw new ScoreTableException(e); //예외를 포장해서 다시 해당메서드를 호출한 쪽으로 던진다 
    }
  }


  public  Score selectOne(int no) {
    try {

      out.writeUTF("selectOne"); // 명령어보내고
      out.writeInt(no); // 번호보내고
      out.flush(); // 끝까지 보내고 

      String status = in.readUTF();
      if (status.equals("success")) {
        return (Score)in.readObject();
      }else {
        throw new RuntimeException(in.readUTF()); // 서버에서 보낸 에러 -> 문자열로 읽어서 (에러사유)
      }
    } catch (Exception e) {
      throw new ScoreTableException(e); //예외를 포장해서 다시 해당메서드를 호출한 쪽으로 던진다 
    }
  }

  public  int update(int no, Score score) {
    try {

      out.writeUTF("update");// 조회먼저
      out.writeInt(no);
      out.writeObject(score);
      out.flush();

      String status = in.readUTF(); // 상태정보를 받아서
      if (status.equals("success")) {
        return in.readInt();
      }else {
        throw new RuntimeException(in.readUTF()); // 서버에서 보낸 에러 -> 문자열로 읽어서 (에러사유)
      }
    } catch (Exception e) {
      throw new ScoreTableException(e); //예외를 포장해서 다시 해당메서드를 호출한 쪽으로 던진다 
    }
  }



  public  int delete(int no) {
    try {
      out.writeUTF("delete");// 조회먼저
      out.writeInt(no);
      out.flush();

      String status = in.readUTF(); // 상태정보를 받아서
      if (status.equals("success")) {
        return in.readInt(); 
      }else {
        throw new RuntimeException(in.readUTF()); // 서버에서 보낸 에러 -> 문자열로 읽어서 (에러사유)
      }
    } catch (Exception e) {
      throw new ScoreTableException(e); //예외를 포장해서 다시 해당메서드를 호출한 쪽으로 던진다 
    }
  }
}






//public class ScoreTable {
//  static ArrayList<Score> scores = new ArrayList<>();// static 멤버에 접근하려면 static으로 접근 // 클래스가 로딩될때 실행- 스태틱블록의 위로 들어간다
//
//  static { // 클래스가 로딩될때 실행
//    try (BufferedReader in = new BufferedReader(new FileReader("./score.csv"));) {
//      String line;
//      while ((line = in.readLine()) != null) {
//        scores.add(Score.fromCSV(line)); //스코어객체-> 따로 분리, 훨씬 코드가 간결해진다.  
//      }
//    } catch (Exception e) {
//      System.out.println("데이터 로딩 중 오류 발생!");
//    }
//  }
//
//  private static void save() {// static 멤버에 접근하려면 static으로 접근
//    try(PrintWriter out = new PrintWriter(new FileWriter("./score.csv"));) {// autoclosable 구현체 
//      for(Score score :scores) {
//        out.println(score.toCSV()); //따로 뽑을 필요없다
//      }
//    }catch (Exception e) {
//      System.out.println("데이터 저장 중 오류 발생!");
//    }
//  }
//
//  public static int insert(Score score) { // static 멤버에 접근하려면 static으로 접근 
//    scores.add(score);
//    save();
//    return 1;
//  }
//
//  public static Score selectOne(int no) { // static 멤버에 접근하려면 static으로 접근 
//    return scores.get(no);// 배열의 크기가 충분하지 않으면 기존의 배열을 복사 내부적으로 새배열을 만들어서 리턴 
//  }
//  public static int  update (int no, Score score) { // static 멤버에 접근하려면 static으로 접근 
//    scores.add(score);
//    save();
//    return 1;
//  }
//
//  public static int  delete(int no) { // static 멤버에 접근하려면 static으로 접근 
//    scores.remove(no);
//    save();
//    return 1;
//  }
//}

/// 아무이유없다 스태틱이든 인스턴스든 -> 구현하는 정도로 
//지금 우리가 만드는 서버의 상태는 구분이 의미가 없다.
// 딱 스코어 데이터만 다루는 거기 때문에 => 지금은 데이터베이스의 역할에만 집중하자 
//우리 과정은 혀끝만 대는 정도

//정답이 없다.
//많이 짜는 사람이 프로그래밍 영역
//생각의 절차가 있지않을까?
//

// 근데 짜다보면 자기만의 논리적 사고가 생긴다.
//청소할때 사람마다 방법 다양 -> 청소하는 전문가를 따라하면서 내가 취할 것은 취하는 것 