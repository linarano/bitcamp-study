// 게시판 관리 - 삭제
package com.eomcs.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

// 다음과 같이 게시물을 삭제하는 프로그램을 작성하라!
// ----------------------------
// 번호? 1
// 삭제하였습니다.
// (또는)
// 해당 번호의 게시물이 존재하지 않습니다.
// ----------------------------
public class Exam0150 {

  public static void main(String[] args) throws Exception {
    String no = null;

    try (Scanner keyScan = new Scanner(System.in)) {
      System.out.print("번호? ");
      no = keyScan.nextLine();
    }

    try (Connection con = DriverManager.getConnection( //드라이버객체를 통해서 커넥션을 얻고
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement()) {//커넥션 객체를통해서 스테이트먼트를 얻는다.

      // delete 문장은 executeUpdate()를 사용하여 서버에 전달한다.
      // => 게시글 첨부 파일 삭제
      // stmt.executeUpdate(
      //     "delete from x_board_file where board_id = " + no);
      //
      // => 게시글 삭제
      int count = stmt.executeUpdate(
          "delete from x_board where board_id = " + no);

      if (count == 0) {
        System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
      } else {
        System.out.println("삭제하였습니다.");
      }
    }
  }
}
//이거 가지고 밥벌어먹고 살껀데 책을 사라
// 자식테이블에 데이터가 있으면 자식테이블은 먼저 삭제하고 부모테이블을 삭제해야 부모테이블이 삭제가능

//4번게시글의 데이터가 포린키로 자식테이블에 있으므로 - 데이터베이스가 무결성을 지키기 위해 삭제불가능 \
// 그래서 30번 문장 필요 - 자식테이블 지우고, 부모테이블 지우기

/*
-- 게시물 첨부파일 테이블 생성
create table x_board_file (
  board_file_id int not null primary key auto_increment,
  file_path varchar(255) not null,
  board_id int not null,
  constraint fk_board_file foreign key (board_id) references x_board(board_id) on delete cascade-- 새로 추가
);-- 부모테이블을 지울때 자식테이블의 데이터를 자동으로 날려라. (위험성)_ 실수로 부모테이블 지워버리면 그에 따른 자식까지 삭제 굉장히 위험도가 높음
-- 회사마다 다름 개발자가 알아서 잘관리해라 
-- 개발자가 삭제할때는 미리 자식테이블을 일일이 찾아다니면석 삭제해라 하면 저걸 안붙임 

 */