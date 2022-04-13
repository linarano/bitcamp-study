package com.eomcs.mylist.service.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.service.BoardService;

public class DefaultBoardService implements BoardService {


  SqlSessionFactory sqlSessionFactory;

  public DefaultBoardService(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory =sqlSessionFactory;
  }

  @Override
  public int add(Board board) { // 매번 이렇게 해야함
    // 주의!
    // - 스레드 마다 SqlSession이 구분되어야 한다. 즉 클라이언트 간의 트랜잭션이 분리되어야 한다.
    // - 따라서 스레드가 서비스 메서드를 호출하는 시점에서 SqlSession을 얻어 DAO를 준비해야 한다.
    // SQL 세션 객체는 무조건 구분되어야한다./세션마다 커밋과 롤백이 따로 있음 
    SqlSession session = sqlSessionFactory.openSession(); // 미리 만들어놓을 수없음 왜냐? 쓰레드마다 SqlSession이 달라야함
    BoardDao boardDao = session.getMapper(BoardDao.class);// 호출될때마다 맵퍼가 boardDAO 객체 자동생성
    return boardDao.insert(board);
  }

  @Override
  public List<Board> list() {
    try {
      SqlSession session = sqlSessionFactory.openSession(); // 미리 만들어놓을 수없음 왜냐? 쓰레드마다 SqlSession이 달라야함
      BoardDao boardDao = session.getMapper(BoardDao.class);
      return boardDao.findAll();
    }catch (RuntimeException e) {
      throw e;
    }
  }


  @Override
  public Board get(int no) {
    try (SqlSession session = sqlSessionFactory.openSession();){ // 쓰면 바로바로 닫아주지않으면 버벅이게 된다
      BoardDao boardDao = session.getMapper(BoardDao.class);
      Board board = boardDao.findByNo(no);
      if (board != null) {
        boardDao.increaseViewCount(no);
      }
      session.commit();
      return board;
    }catch (RuntimeException e) {
      throw e;
    }
  }
  // 마이바티스는 커밋롤백도 다 직접 통제해줘야함  - 이전에는 @ gorufgownJTek 

  @Override
  public int update(Board board) {
    try ( SqlSession session = sqlSessionFactory.openSession(); ) {
      // 미리 만들어놓을 수없음 왜냐? 쓰레드마다 SqlSession이 달라야함
      BoardDao boardDao = session.getMapper(BoardDao.class);
      int count = boardDao.update(board);
      return count;
    }catch (RuntimeException e) {
      throw e;
    }
  }

  @Override
  public int delete(Board board) {
    try( SqlSession session = sqlSessionFactory.openSession(); ){
      // 미리 만들어놓을 수없음 왜냐? 쓰레드마다 SqlSession이 달라야함
      BoardDao boardDao = session.getMapper(BoardDao.class);
      int count = boardDao.delete(board);
      session.commit();
      return count;
    }catch (RuntimeException e) {
      throw e;
    }
  }
}







