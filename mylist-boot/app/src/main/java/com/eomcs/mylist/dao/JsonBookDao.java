package com.eomcs.mylist.dao;

import java.io.File;
import com.eomcs.mylist.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Repository
public abstract class JsonBookDao extends AbstractBookDao { // 데이터 처리는 무조건 DAO에가 맡긴다. 

  String filename ="book.json"; // 파일명은 인스턴스변수로 사용

  public JsonBookDao() {
    try {
      ObjectMapper mapper = new ObjectMapper();
      bookList.addAll(mapper.readValue(new File(filename), Book[].class));


    }catch (Exception e) {
      System.out.println("독서록 데이터 로딩중 오류발생");
    }
  }



  @Override
  protected void save() throws Exception { // 내부만 접근가능하도록 - 내부에서만 쓰니까 private , 인스턴스 메소드이므로 늘 주소를 줘야함 this.sava(); , 저장하다가 오류뜨면 알려줘야되므로  오류던지도록
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), bookList.toArray()); // 효율적으로 하도록 맡기자
  }
}
















//