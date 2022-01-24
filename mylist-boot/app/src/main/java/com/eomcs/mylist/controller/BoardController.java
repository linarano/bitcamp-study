package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController 
public class BoardController {

  ArrayList boardList = new ArrayList();

  public BoardController() {
    System.out.println("BoardController() 호출됨!"); // 생성자 호출함. - 직렬화와 다르게 json


    try { 

      BufferedReader in = new BufferedReader (new FileReader("boards.json"));

      ObjectMapper mapper = new ObjectMapper();

      //1) 객체를 JSON 형식의 ㅁ누자열로 생성한다.
      //=>어레이리스트에서 보드배열ㅇ르 꺼낸후, 제이슨 문자열로 만든다. 
      String jsonStr = mapper.writeValueAsString(boardList.toArray()); // 어레이리스트에서 배열만 쏙 꺼내라 - 배열이 3개면 3개를 꺼낸다.

      Board[] boards = mapper.readValue(jsonStr, Board[].class);// 보드배열 클래스정보를 넘겨야함. 그 객체의 배열이라면 배열 표시를 하면된다. 

      //3) 배열 객체를 ArrayList에 저장한다.
      //반복문을 돌릴 수도있음
      for(Board board: boards) {
        boardList.add(board);
      }

      in.close();

    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩중 오류 발생!");
    }
  }


  //
  //    try {
  //      ObjectInputStream in = new  ObjectInputStream(new BufferedInputStream(new FileInputStream("boards.ser2")));
  //      //
  //      //
  //      //    // 1) 직렬화 복원- 객체가 각각 따로 serialise 되었을 경우, 다음과 같이 객체 단위로 읽으면 되고,
  //      //    while (true) {  //무조건 읽어라 
  //      //      try {
  //      //        Board board = (Board) in.readObject(); // 지금은 임시 변수를 쓰자 .객체꺼내기 객체주소를 넘겨줘(객체를 넘긴다라고 간단히 표현) - object임으로 BOARD인걸 알려줘야 레퍼런스에 저장가능 
  //      //        boardList.add(board); 
  //      //
  //      //      } catch(Exception e) {
  //      //        break;
  //      //      }
  //      //    } //csv필요없음
  //
  //      //2) 목록이 통째로 serialize 되었을 경우, 한번에 목록을 읽으면 된다.
  //
  //      boardList = (ArrayList) in.readObject(); //단 기존에 생성한 ArrayList 객체는 버린다.
  //      in.close(); //데코레이터와 그 연결된 객체 모두 클로즈
  //      //in.close();  //in.close(); // 데코레이터를 close() 하면 그 데코레이터와 연결된 객체들도 모두 close() 된다.
  //    }catch (Exception e) {
  //      System.out.println("게시판 데이터를 읽는중 오류발생");
  //    }
  //  }

  @RequestMapping("/board/list")
  public Object list() {
    return boardList.toArray(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) {

    board.setCreatedDate(new Date(System.currentTimeMillis()));
    boardList.add(board);
    return boardList.size();
  }


  @RequestMapping("/board/get")
  public Object get(int index) {
    if (index < 0 || index >= boardList.size()) {
      return "";
    }
    Board board = (Board) boardList.get(index);
    board.setViewCount(board.getViewCount() + 1);

    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }

    Board old = (Board) boardList.get(index);
    board.setViewCount(old.getViewCount());
    board.setCreatedDate(old.getCreatedDate());

    return boardList.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }
    return boardList.remove(index) == null ? 0 : 1;
  }


  @RequestMapping("/board/save") //sava로 해야 바이너리 형식으로 저장, 출력 
  public Object save() throws Exception {
    //    FileOutputStream out = new  FileOutputStream("boards.data"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.
    //    BufferedOutputStream out1 = new BufferedOutputStream(out);// 순서있음 
    //    DataOutputStream out2 = new DataOutputStream(out1);


    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("boards.json")));

    // JSON 형식의 문자열을 다룰 객체를 준비한다. 
    ObjectMapper mapper = new ObjectMapper();

    //1) 문자열로 생성한다.
    String jsonStr = mapper.writeValueAsString(boardList.toString());// 값출력할때 문자열로 출력하라

    //2) 제이슨형식의 문자열을 파일로 출력
    out.println( jsonStr);// 버퍼드리더로 읽으려면 한줄로 


    out.close();
    return boardList.size();
  }
}

//필드값일일이 출력하는게 아니라 객체 직접출력
//board 생성자 호출안됨, 바로 객체를 집어넣는다. - 26분
//arrayList 통째로 출력 (각자 따로해도되고)
//단, serialrizable 해야함. 인터페이스