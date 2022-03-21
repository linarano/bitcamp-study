package com.eomcs.mylist.dao2;

import com.eomcs.mylist.domain2.Book;

public interface BookDao {

  int countAll();

  Object[] findAll();

  void insert(Book book) throws Exception;

  Book findByNo(int no);

  int update(int no, Book book) throws Exception;

  int delete(int no) throws Exception;
}











