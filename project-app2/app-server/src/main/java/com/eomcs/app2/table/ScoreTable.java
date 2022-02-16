package com.eomcs.app2.table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.eomcs.app2.vo.Score;

public class ScoreTable {
  static ArrayList<Score> scores = new ArrayList<>();

  static {
    try (BufferedReader in = new BufferedReader(new FileReader("./score.csv"));) {
      String line;
      while ((line = in.readLine()) != null) {
        scores.add(Score.fromCSV(line));
      }
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }
  }

  private static void save() {
    try (PrintWriter out = new PrintWriter(new FileWriter("./score.csv"));) {
      for (Score score : scores) {
        out.println(score.toCSV());
      }
    } catch (Exception e) {
      System.out.println("데이터 저장 중 오류 발생!");
    }
  }

  public static int insert(Score score) {
    scores.add(score);
    save();
    return 1;
  }

  public static Score[] selectList() {
    return scores.toArray(new Score[0]);
  }

  public static Score selectOne(int no) {
    return scores.get(no);
  }

  public static int update(int no, Score score) {
    scores.set(no, score);
    save();
    return 1;
  }

  public static int delete(int no) {
    scores.remove(no);
    save();
    return 1;
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