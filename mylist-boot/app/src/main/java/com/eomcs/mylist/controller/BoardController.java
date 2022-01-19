package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController 
public class BoardController {

  ArrayList boardList = new ArrayList();

  // 데이터읽고
  // 파일을 모아서 주는 것. (버퍼가 데이터를 읽을 수 없으므로 하나로 모아줌)- 엔터를 만나면 버퍼에담은 걸 리턴 
  public BoardController() throws Exception {
    System.out.println("BoardController() 호출됨!");

    //1) 주 작업 객체(concrete component) 준비
    FileReader in = new FileReader("boards.csv"); // 파일 읽어오는 기능만있음

    //2) 한 줄 단위로 데이터를 읽는 작업을 수행하는 데코레이터 준비
    BufferedReader in2 = new BufferedReader(in);

    String line;
    while ((line = in2.readLine()) != null) {  // 한 줄의 문자열을 읽었으면,
      boardList.add(Board.valueOf(line)); 
    } // 버퍼드리더의 리드라인은 스트링리턴이 아니고 null을 리턴한다. 
    in2.close(); //데코레이터와 그 연결된 객체 모두 클로즈
    //in.close();  //in.close(); // 데코레이터를 close() 하면 그 데코레이터와 연결된 객체들도 모두 close() 된다.
  }

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


  @RequestMapping("/board/save")
  public Object save() throws Exception {
    // 1) 주 작업객체 준비  
    FileWriter out = new FileWriter("boards.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.

    //2) 한 줄 단위로 출력하는 데코레이터 객체 준비 
    PrintWriter out2 = new PrintWriter(out); //생성자에 객체를 넘겨준다. 
    Object[] arr = boardList.toArray();
    for (Object obj : arr) {
      Board board = (Board) obj;
      out2.println(board.toCsvString());
    }

    out2.close();
    return arr.length;
  }
}


