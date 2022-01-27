package com.eomcs.mylist.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.domain.Board;

@Repository
public class CsvBoardDao extends AbstractBoardDao { // 데이터 처리는 무조건 DAO에가 맡긴다. ,csv 장점- 임의적으로 텍스트 에디터로 데이터 추가변경 가능 

  String filename = "board.csv";

  public CsvBoardDao() {

    try {

      BufferedReader in =  new BufferedReader(new FileReader(filename)); // 텍스트읽을꺼니까 파일리더,빠르게 읽기 - 버퍼드리더
      String csvStr;

      while ((csvStr = in.readLine()) !=  null) {
        boardList.add(Board.valueOf(csvStr)); //this. 생략, 컴파일러가 자동으로 붙여준다. 규칙! 만약에 boardList가 로컬변수라면 안붙인다. 인스턴스 주소없이는 인스턴스롤 찾아갈 수 없다. 
      }

      in.close();
    }catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류발생!");
    }
  }



  @Override
  protected void save() throws Exception { // 내부만 접근가능하도록 - 내부에서만 쓰니까 private , 인스턴스 메소드이므로 늘 주소를 줘야함 this.sava(); , 저장하다가 오류뜨면 알려줘야되므로  오류던지도록
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename))); //바로출력하는게 아니라 버퍼에 왕창담아서 다 차면 파일출력으로 보냄 

    for (int i = 0; i<boardList.size(); i++) { // 굳이 배열만드필요없고 , 있으니까 
      Board board = (Board) boardList.get(i);
      out.write(board.toCsvString());
    }
    out.flush(); // 명시적으로 출력하라고 요구
    out.close(); // 정의를 따라가면 다 정의되어있지만 
  }

}










//