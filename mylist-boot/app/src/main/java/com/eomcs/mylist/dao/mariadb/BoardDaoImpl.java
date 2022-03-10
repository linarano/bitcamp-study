package com.eomcs.mylist.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.dao.DaoException;
import com.eomcs.mylist.domain.Board;

// @Repository
// - 클래스에 이 애노테이션을 붙여 표시해 두면, Spring Boot가 실행될 때 이 클래스의 객체를 자동 생성한다.
// - 또한 이 객체를 원하는 곳에 자동으로 주입한다.
//
//DAO 데이터 처리하는 애는 Repository를 붙인다.(스프링매뉴얼) 컴포넌트도 가능하지만 - 비즈니스로직 처리하는 서비스객체인지 구분하려고 : 애노테이션 분류 
//클라이언트 요청 - Controller  
//@Componount --일반자바 객체
//나중에 통제하려고 @애노테이션 구분 

@Repository  
public class BoardDaoImpl implements BoardDao { // 스프링부트가 자동생성하고, 자동주입시켜버린다. BOardDao를 원하는 곳에

  public BoardDaoImpl() {
    System.out.println("JdbcBoardDao 객체 생성!");
  } //객체생성여부 생성자를 만들어 확인 
  @Override
  public int countAll() { // 인터페이스에 반드시 선언되어야함 예외가
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement( //
            "select count(*) from ml_board"); //desc 최신글 다꺼내는게 아니고 필요한 것만, 파일에서 하지못했던걸 디비를 사용하여 더 정교하게 제어
        ResultSet rs = stmt.executeQuery()) {


      rs.next();
      return rs.getInt(1);
    } catch (Exception e) {
      throw new DaoException(e); // 컴파일러가 검사하지않은 런타임익셉션 -> 개발자가 알아서 처리해라. 호출하는 시점에서 해라 (메인메서드까지 가기전에- 자바버츄얼머신까지 가기전까지)  : 검사하지않으므로 개발하는 입잔에서 편함
    }
  }

  @Override
  public List<Board> findAll(){ // 규칙상 예외를 안던져
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement( //
            "select board_no, title, created_date, view_count from ml_board order by board_no desc"); //desc 최신글 다꺼내는게 아니고 필요한 것만, 파일에서 하지못했던걸 디비를 사용하여 더 정교하게 제어
        ResultSet rs = stmt.executeQuery()) {

      ArrayList<Board> arr = new ArrayList<>();
      while (rs.next()) {
        Board board = new Board();
        board.setTitle(rs.getString("title"));
        board.setCreatedDate(rs.getDate("created_date"));
        board.setViewCount(rs.getInt("view_count"));
        arr.add(board);
      }
      return arr;
    }   catch (Exception e) {
      throw new DaoException(e); // 컴파일러가 검사하지않은 런타임익셉션 -> 개발자가 알아서 처리해라. 호출하는 시점에서 해라 (메인메서드까지 가기전에- 자바버츄얼머신까지 가기전까지)  : 검사하지않으므로 개발하는 입잔에서 편함
    }
  }

  @Override
  public int insert(Board board) {
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt =
            con.prepareStatement("insert into ml_board(title,content) values(?,?)");) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());

      return stmt.executeUpdate();
    }catch (Exception e) {
      throw new DaoException(e); // 컴파일러가 검사하지않은 런타임익셉션 -> 개발자가 알아서 처리해라. 호출하는 시점에서 해라 (메인메서드까지 가기전에- 자바버츄얼머신까지 가기전까지)  : 검사하지않으므로 개발하는 입잔에서 편함
    }
  }

  @Override
  public Board findByNo(int no) { // 리스트와 차이점 상세보기 딱 1개만 리턴하면 됨 
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement( //
            "select board_no, title, content, created_date, view_count from ml_board where board_id = ?")) 
    { 

      stmt.setInt(1, no); 

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next())
          return null;

        Board board = new Board();
        board.setNo(rs.getInt("board_no")); //넘버프로퍼티(세터게터를 가리키는 말)
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("contents"));
        board.setCreatedDate(rs.getDate("created_date"));
        board.setViewCount(rs.getInt("view_count"));
        return board;
      } catch (Exception e) {
        throw new DaoException(e); // 컴파일러가 검사하지않은 런타임익셉션 -> 개발자가 알아서 처리해라. 호출하는 시점에서 해라 (메인메서드까지 가기전에- 자바버츄얼머신까지 가기전까지)  : 검사하지않으므로 개발하는 입잔에서 편함
      } 
    }catch (Exception e) {
      throw new DaoException(e); // 컴파일러가 검사하지않은 런타임익셉션 -> 개발자가 알아서 처리해라. 호출하는 시점에서 해라 (메인메서드까지 가기전에- 자바버츄얼머신까지 가기전까지)  : 검사하지않으므로 개발하는 입잔에서 편함
    }
  }



  @Override
  public int update(Board board) {
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement( //
            "update ml_board set title=?, content=? where board_no = ?")) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getNo());

      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e); // 컴파일러가 검사하지않은 런타임익셉션 -> 개발자가 알아서 처리해라. 호출하는 시점에서 해라 (메인메서드까지 가기전에- 자바버츄얼머신까지 가기전까지)  : 검사하지않으므로 개발하는 입잔에서 편함
    }
  }

  @Override
  public int delete(int no)  {
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement( //
            "delete from ml_board where board_no=?")) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e); // 컴파일러가 검사하지않은 런타임익셉션 -> 개발자가 알아서 처리해라. 호출하는 시점에서 해라 (메인메서드까지 가기전에- 자바버츄얼머신까지 가기전까지)  : 검사하지않으므로 개발하는 입잔에서 편함
    }
  }

  @Override
  public int increaseViewCount(int no) {
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement( //
            "update ml_board set view_count = view_count + 1 where board_no = ?")) {


      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e); // 컴파일러가 검사하지않은 런타임익셉션 -> 개발자가 알아서 처리해라. 호출하는 시점에서 해라 (메인메서드까지 가기전에- 자바버츄얼머신까지 가기전까지)  : 검사하지않으므로 개발하는 입잔에서 편함
    }

  } // 어레이리스트 사용안하고 직접 저장 
  //파일저장 따로 필요없이 DBMS  사용하므로 편하다 

}











