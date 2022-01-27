package com.eomcs.mylist.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import com.eomcs.mylist.domain.Board;

//인터페이스를 직접구현하는 대신에
//Abstract를 상속받는다.

public class BinaryBoardDao extends AbstractBoardDao { // 데이터 처리는 무조건 DAO에가 맡긴다. 

  String filename ="board.bin"; // 파일명은 인스턴스변수로 사용

  public BinaryBoardDao() {

    try {
      DataInputStream in =  new DataInputStream(new BufferedInputStream(new FileInputStream(filename))); // 텍스트읽을꺼니까 파일리더,빠르게 읽기 - 버퍼드리더

      //저장된 데이터 개수 읽어온다.
      int len = in.readInt();// 첫번째 4바이트 읽어온다. 없다면 에러가 뜨겠지만, 서버가종료되지는암ㅎ음

      for(int i=0; i<len;i++) { //순서대로 읽고, 순서대로 출력
        Board board = new Board();
        board.setTitle(in.readUTF());
        board.setContent(in.readUTF());
        board.setViewCount(in.readInt());
        board.setCreatedDate(Date.valueOf(in.readUTF())); // ** valueOf() date객체를 만들어줌 팩토리 메서드 -메서드에서 객체를 만드는 것 - 문자열을 리턴하니까 날짜객체로 변경

        boardList.add(board);
      }

      in.close();

    }catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류발생!");
    }
  }



  @Override
  protected void save() throws Exception { // 내부만 접근가능하도록 - 내부에서만 쓰니까 private , 인스턴스 메소드이므로 늘 주소를 줘야함 this.sava(); , 저장하다가 오류뜨면 알려줘야되므로  오류던지도록
    DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename))); //바로출력하는게 아니라 버퍼에 왕창담아서 다 차면 파일출력으로 보냄 

    out.writeInt(boardList.size());

    for (int i = 0; i<boardList.size(); i++) { // 굳이 배열만드필요없고 , 있으니까 
      Board board = (Board) boardList.get(i);
      out.writeUTF(board.getTitle());
      out.writeUTF(board.getContent());
      out.writeInt(board.getViewCount());
      out.writeUTF(board.getCreatedDate().toString());
    }
    out.flush(); // 명시적으로 출력하라고 요구

    out.close(); // 정의를 따라가면 다 정의되어있지만 
  }
}



















//