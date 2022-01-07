package com.eomcs.mylist.domain;

import java.sql.Date;

public class Board {
  String title;
  String content;
  int viewCount;
  java.sql.Date CreatedDate;

  public Board() {
    System.out.println("Board() 호출됨!");
  }



  public Board(String csvStr) { //객체를 만들어 파라미터로 들어오 csv
    // 예) "홍길동,hong@test.com,010-1111-2222,비트캠프"
    String[] values = csvStr.split(","); // 예) ["홍길동","hong@test.com","010-1111-2222","비트캠프"]
    this.setTitle(values[0]);
    this.setContent(values[1]);
    this.setViewCount(Integer.valueOf(values[2]));
    this.setCreatedDate(Date.valueOf(values[3]));
  }

  public static Board valueOf(String csvStr) { // 직관적이게 우리도 만들어보자. 팩토리메서드 적용해라는 말의 의미 복잡한코드를 캡슐화(감춘다)- 메서드안에 숨긴다.
    // 예) "홍길동,hong@test.com,010-1111-2222,비트캠프" // 복잡한 코드를 메서드로 감추고 그걸 다시 클래스로 감추는 것 //value of는 팩토리 메서드 파라미터만 넘겨준다면 
    String[] values = csvStr.split(","); // 예) ["홍길동","hong@test.com","010-1111-2222","비트캠프"]

    Board board = new Board();
    board.setTitle(values[0]);
    board.setContent(values[1]);
    board.setViewCount(Integer.valueOf(values[2]));
    board.setCreatedDate(Date.valueOf(values[3]));

    return board;


  }


  // 적용 기술
  // => 인스턴스 메서드
  // 인스턴스 메서드: 특정인스턴스를 사용한다면 인스턴스 메서드로 만들라!
  //  => + GRASP: Information Expert
  // 데이터를 가공하는 기능은 그 데이터를 갖고있는 클래스에 둬야한다.
  //
  public String toCsvString() {//현재 연락처정보를 사용할것이므로 인스턴스메소드
    return String.format("%s,%s,%s,%s",//모든인스턴스메서드 this , 순수하게 하나의 문자열로 리턴
        this.getContent(), 
        this.getTitle(), 
        this.getTitle(),
        this.getViewCount()) ;
  }



  public String getTitle() {
    return title;
  }



  public void setTitle(String title) {
    this.title = title;
  }



  public String getContent() {
    return content;
  }



  public void setContent(String content) {
    this.content = content;
  }



  public int getViewCount() {
    return viewCount;
  }



  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }



  public java.sql.Date getCreatedDate() {
    return CreatedDate;
  }



  public void setCreatedDate(java.sql.Date createdDate) {
    CreatedDate = createdDate;
  }



  @Override
  public String toString() {
    return "Board [title=" + title + ", content=" + content + ", viewCount=" + viewCount
        + ", CreatedDate=" + CreatedDate + "]";
  }





}
