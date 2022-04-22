package com.eomcs.mylist.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.service.BoardService;

@Service
public class DefaultBoardService implements BoardService {

  BoardDao boardDao;

  public DefaultBoardService(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  //자동생성될꺼니까  -> 맵퍼스캔
  //  SqlSessionFactory sqlSessionFactory;
  //
  //  public DefaultBoardService(SqlSessionFactory sqlSessionFactory) {
  //    this.sqlSessionFactory = sqlSessionFactory;
  //  }

  @Transactional
  @Override
  public int add(Board board) {
    return boardDao.insert(board);
  }

  @Override
  public List<Board> list(int pageSize, int pageNo) {
    return boardDao.findAll(pageSize, ((pageNo - 1) * pageSize));

  }

  @Transactional
  @Override
  public Board get(int no) {
    Board board = boardDao.findByNo(no);
    if (board != null) {
      boardDao.increaseViewCount(no);
    }
    return board;
  }

  @Transactional
  @Override
  public int update(Board board) {
    return boardDao.update(board);// 보드디에이오 자체가 자동으로 만들어짐
  }

  @Transactional // 에러 뜨면 롤백 , 에러안뜨면 커밋
  @Override
  public int delete(Board board) {
    return boardDao.delete(board);
  }

  @Override
  public int size() {
    return boardDao.countAll();
  }
}


// 설정할수록 코드는 간결




