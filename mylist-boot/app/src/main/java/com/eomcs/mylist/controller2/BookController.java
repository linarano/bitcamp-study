package com.eomcs.mylist.controller2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao2.BookDao;
import com.eomcs.mylist.domain2.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

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
  public Object get(int index) {
    Book book = bookDao.findByNo(index);
    return book != null ? book : "";
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.remove(index) == null ? 0 : 1;
  }

  @RequestMapping("/book/save")
  public Object save() throws Exception {

    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("books.json")));

    // JSON 형식의 문자열을 다룰 객체를 준비한다. 
    ObjectMapper mapper = new ObjectMapper();

    //1) 문자열로 생성한다.
    //2) 제이슨형식의 문자열을 파일로 출력
    out.println( mapper.writeValueAsString(bookList.toString()));// 버퍼드리더로 읽으려면 한줄로 


    out.close();
    return bookList.size();
  }
}




//필수입력과 선택입력 확인 ! 
//날짜값이 null 일수 있으므로 디테일하게 제어!
// 