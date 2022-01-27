package com.eomcs.mylist.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import com.eomcs.mylist.domain.Board;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Repository
public class JsonBoardDao extends AbstractBoardDao { // 데이터 처리는 무조건 DAO에가 맡긴다. 

  String filename ="board.json"; // 파일명은 인스턴스변수로 사용

  public JsonBoardDao() {

    try {
      ObjectMapper mapper = new ObjectMapper();
      boardList.addAll(mapper.readValue(new File(filename), Board[].class));


    }catch (Exception e) {
      System.out.println("게시글 등록중 오류발생");
    }
  }



  @Override
  protected void save() throws Exception { // 내부만 접근가능하도록 - 내부에서만 쓰니까 private , 인스턴스 메소드이므로 늘 주소를 줘야함 this.sava(); , 저장하다가 오류뜨면 알려줘야되므로  오류던지도록
    BufferedWriter out =  new BufferedWriter(new FileWriter(filename)); 

    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), boardList.toArray()); // 효율적으로 하도록 맡기자
    out.flush();
    out.close();
  }
}
















//