// JDBC 프로그래밍 - DBMS에 SQL문 보내기 : select
package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;

public class Exam0340 {

  public static void main(String[] args) throws Exception {
    try (
        java.sql.Connection con = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        java.sql.Statement stmt = con.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery(
            "select * from x_board order by board_id desc");
        ) {

      // 반복문을 사용하면 서버에서 여러 개의 데이터를 가져올 수 있다.
      // - next()는 서버에서 레코드 1개를 가져온다.
      while (rs.next()) {
        System.out.printf("%d, %s, %s, %s, %d\n", 
            rs.getInt("board_id"), 
            rs.getString("title"), 
            rs.getString("contents"), 
            rs.getDate("created_date"), //-> 데이터타입중 날짜만 뽑은것, 또는 문자열로 꺼내거나 getTime() 하면 시간까지 꺼냄
            rs.getInt("view_count")); 
      }
    }
  }
}


