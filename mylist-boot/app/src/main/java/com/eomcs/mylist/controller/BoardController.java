package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController 
public class BoardController {

  ArrayList boardList = new ArrayList();

  public BoardController() throws Exception {
    System.out.println("BoardController() 호출됨!");

    ObjectInputStream in = new ObjectInputStream(new BufferedInputStream (new FileInputStream("boards.ser")));

    while(true) {
      try {
        Board board = (Board) in.readObject();
        boardList.add(board);

      } catch (Exception e) {
        break; 
      }
    }
    in.close();
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


    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("boards.ser")));


    // 1) 다음과 같이 목록에 들어있는 객체를 한 개씩 순차적으로 serialize 할 수 도있고, 
    //    Object[] arr = boardList.toArray();
    //    for (Object obj : arr) {
    //      out.writeObject(obj);
    //    }

    //2) 다음과 같이 목록 자체를 serialize 할 수도있다. 
    try {
      out.writeObject(boardList);

    } catch (Exception e){
      ""
    }
    out.close();
    return boardList.size();
  }
}

//필드값일일이 출력하는게 아니라 객체 직접출력
//board 생성자 호출안됨, 바로 객체를 집어넣는다. - 26분
//arrayList 통째로 출력 (각자 따로해도되고)
//단, serialrizable 해야함. 인터페이스