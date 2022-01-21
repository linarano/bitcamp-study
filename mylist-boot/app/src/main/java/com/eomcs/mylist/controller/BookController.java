package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController 
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    System.out.println("BookController() 호출됨!");
    // 데코레이터 교체,. 왕창읽어와 반복문 돌릴 필요없음 

    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.ser2"))); // 실무에서는 바로씀 주객체에 데코레이터 객체를 연결, 따로 만들지않고 직접넘긴다.  
      bookList = (ArrayList) in.readObject();
      in.close();

    }catch (Exception e) {
      System.out.println("독서록 데이터를 로딩하는 중 에러 발생");
    }
  }

  @RequestMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book) {
    bookList.add(book);
    return bookList.size();
  }


  @RequestMapping("/book/get")
  public Object get(int index) {
    if (index < 0 || index >= bookList.size()) {
      return "";
    }
    return bookList.get(index);
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
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.ser2"))); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.
    // 2) 다음과 같이 목록 자체를 serialize 할 수 도 있다.
    out.writeObject(bookList);

    out.close();
    return bookList.size();
  }
}




//필수입력과 선택입력 확인 ! 
//날짜값이 null 일수 있으므로 디테일하게 제어!
// 