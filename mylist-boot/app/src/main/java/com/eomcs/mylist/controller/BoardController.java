package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Board;
import com.eomcs.util.ArrayList;

@RestController 
public class BoardController  {

  ArrayList boardList = new ArrayList();

  public BoardController() throws Exception {
    System.out.println("BoardController() 호출됨!");
    FileReader in = new FileReader("boards.csv");

    StringBuilder buf = new StringBuilder();
    int c;
    while ((c = in.read()) != -1) {

      if (c == '\n') { // 만약 읽은 문자가 줄바꿈 명령이라면, 지금까지 읽은 CSV 데이터를 분석하여 Contact 객체에 담는다.
        boardList.add(Board.valueOf(buf.toString()));//스태틱 메소드의 전형적인 에 - 복잡한걸 감추고, 단지 호출만하면된다.
        buf.setLength(0); // 다음 데이터를 읽기 위해 버퍼를 초기화시킨다.

      } else { // 문자를 읽을 때 마다 버퍼이 임시 보관한다.
        buf.append((char) c);
      }
    }

    in.close();
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
    board.setViewCount(old.getViewCount()); //인스턴스변수에 다이렉트로 접근하지않도록, 메소드로 접근,(시스템운영에 더 안정적)
    board.setCreatedDate(old.getCreatedDate());

    return boardList.set(index, board) == null ? 0 : 1;
  }

  @RequestMapping("/board/save")
  public Object save() throws Exception {
    FileWriter out = new FileWriter("boards.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.

    Object[] arr = boardList.toArray();
    for (Object obj : arr) {
      Board board = (Board) obj;
      out.write(board.toCsvString() + "\n");
    }

    out.close();
    return  arr.length;
  }


  @RequestMapping("/board/delete")
  public Object delete(int index) {
    if (index < 0 || index >= boardList.size()) {
      return 0;
    }
    return boardList.remove(index) == null ? 0 : 1;
  }
}




