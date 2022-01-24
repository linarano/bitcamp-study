package com.eomcs.mylist.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

public class CsvBoardDao {
  ArrayList boardList = new ArrayList();

  public CsvBoardDao() {

    try {
      BufferedReader in =  new BufferedReader(new FileReader("boards.csv")); // 텍스트읽을꺼니까 파일리더,빠르게 읽기 - 버퍼드리더

      String csvStr;

      while ((csvStr = in.readLine()) !=  null) {
        boardList.add(Board.valueOf(csvStr)); 
      }

      in.close();
    }catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류발생!");
    }
  }



  public void save() throws Exception{
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("boards.csv"))); //바로출력하는게 아니라 버퍼에 왕창담아서 다 차면 파일출력으로 보냄 

    for (int i = 0; i<boardList.size(); i++) { // 굳이 배열만드필요없고 , 있으니까 
      Board board = (Board) boardList.get(i);
      out.write(board.toCsvString());
    }
    out.flush(); // 명시적으로 출력하라고 요구

    out.close(); // 정의를 따라가면 다 정의되어있지만 
  }

  public int countAll() {
    return boardList.size();
  }

  public Object[] findAll() {
    return boardList.toArray();
  }

  public void insert(Board board) {
    boardList.add(board);
  }
  //현업에서 insert의 리턴값은 1개 - 객체들어가는 것
  //우리는 들어갈때마다 1


  public Board findByNo(int no) {
    if (no < 0 || no >= boardList.size()) {
      return null;
    }
    return (Board) boardList.get(no);
  }

  public int update(int no, Board board) { // 나중에 업데이트하자 다른기능과함께 
    if ( no < 0 || no >= boardList.size()) {
      return 0;
    }
    boardList.set(no, board);
    return 1;
  }

  public int delete(int no) {
    if (no < 0 || no >= boardList.size()) {
      return 0;
    }
    boardList.remove(no);
    return 1;
  }
}

//현업에서 insert의 리턴값은 1개 - 객체들어가는 것
// 우리는 들어갈때마다 1




// 초심자는 어떻게 저렇게 하지- 정답을 고민할 필요없음. 정답에는 풀이과정이 있음 
// 정답이 아니라 경험자의 코드는 이런거다 라는 것을경험해라. (소개) - 문법과 실전 계쏙 연습하는 단계일뿐 

//내일 
//바이너리 
//인터페이스 추가 기능 배움 - 파일필터를 다루기 위해 필터클래스를 만들었다면 , 파일필터가 아니라 우리가 인터페이스를 =>  만들기 위해   
//스프링부트의 ioc 컨테이너 - 자동기술  


















//