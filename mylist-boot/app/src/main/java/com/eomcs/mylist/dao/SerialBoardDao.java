package com.eomcs.mylist.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.util.ArrayList;

//@Repository
public class SerialBoardDao extends AbstractBoardDao { // 데이터 처리는 무조건 DAO에가 맡긴다. 

  String filename ="board.ser"; // 파일명은 인스턴스변수로 사용


  public SerialBoardDao() {

    try {
      ObjectInputStream in =  new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename))); // 텍스트읽을꺼니까 파일리더,빠르게 읽기 - 버퍼드리더

      boardList = (ArrayList) in.readObject();// 왕창 읽어드려랴
      in.close();

    }catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류발생!");
    }
  }



  @Override
  protected void save() throws Exception { // 내부만 접근가능하도록 - 내부에서만 쓰니까 private , 인스턴스 메소드이므로 늘 주소를 줘야함 this.sava(); , 저장하다가 오류뜨면 알려줘야되므로  오류던지도록
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename))); //바로출력하는게 아니라 버퍼에 왕창담아서 다 차면 파일출력으로 보냄 
    out.writeInt(boardList.size());

    out.writeObject(boardList);// 통째로 읽어라 
    out.flush(); // 명시적으로 출력하라고 요구
    out.close(); // 정의를 따라가면 다 정의되어있지만 
  }
}

/*
  @Override
  public int countAll() {
    return boardList.size();
  }

  @Override
  public Object[] findAll() {
    return boardList.toArray();
  }

  @Override
  public void insert (Board board) throws Exception {
    boardList.add(board);
    save(); //컴파일러가 자동으로 만들어주기때문에 디스생략가능(자바스크립트는 안되) , 넘어온 주소를 넘김 // 오류났을때, 내가 처리할건지, 오류를 던질지 결정 다시리턴할지 DAO는 오류를 처리하지말고 전달해야함. 보드컨트럴러가 처리할일 
  }
  //현업에서 insert의 리턴값은 1개 - 객체들어가는 것
  //우리는 들어갈때마다 1


  @Override
  public Board findByNo(int no) {
    if (no < 0 || no >= boardList.size()) {
      return null;
    }
    return (Board) boardList.get(no);
  }

  @Override
  public int update(int no, Board board) throws Exception { // 나중에 업데이트하자 다른기능과함께 , 업데이트를 호출할 컨트럴러에게 예외를 던져라. 직접처리할지말고 
    if ( no < 0 || no >= boardList.size()) {
      return 0;
    }
    boardList.set(no, board);
    save(); //추가변경삭제한후, 서버꺼버리면 세이브가 안된상태로 종료. 업데이트할때마다,ㅡ 삭제할때마다 바로 저장. 더이상 세이브호출할 필요없이. , 어차피 dbms로 바꿀꺼다. (파일출력 담당하는 프로그램이 따로있지않냐)
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    if (no < 0 || no >= boardList.size()) {
      return 0;
    }
    boardList.remove(no);
    save();
    return 1;
  }

  @Override
  public void increaseViewCount(int no)  throws Exception{
    Board board = findByNo(no);
    board.setViewCount(board.getViewCount() +1);
    save();
  }*/

//현업에서 insert의 리턴값은 1개 - 객체들어가는 것
// 우리는 들어갈때마다 1




// 초심자는 어떻게 저렇게 하지- 정답을 고민할 필요없음. 정답에는 풀이과정이 있음 
// 정답이 아니라 경험자의 코드는 이런거다 라는 것을경험해라. (소개) - 문법과 실전 계쏙 연습하는 단계일뿐 

//내일 
//바이너리 
//인터페이스 추가 기능 배움 - 파일필터를 다루기 위해 필터클래스를 만들었다면 , 파일필터가 아니라 우리가 인터페이스를 =>  만들기 위해   
//스프링부트의 ioc 컨테이너 - 자동기술  


















//