package com.eomcs.mylist.controller2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao2.BookDao;
import com.eomcs.mylist.domain2.Book;

@RestController 
public class BookController {

  @Autowired
  BookDao bookDao;

  @RequestMapping("/book/list")
  public Object list() {
    return bookDao.findAll(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book) {
    bookDao.insert(book);
    return bookDao.countAll();
  }


  @RequestMapping("/book/get")
  public Object get(int no) {
    Book book = bookDao.findByNo(no);
    return book != null ? book : "";
  }

  @RequestMapping("/book/update")
  public Object update( Book book) {
    return bookDao.update(book);
  }

  @RequestMapping("/book/delete")
  public Object delete(int no) {
    return bookDao.delete(no) == null ? 0 : 1;
  }

}




//필수입력과 선택입력 확인 ! 
//날짜값이 null 일수 있으므로 디테일하게 제어!
// 