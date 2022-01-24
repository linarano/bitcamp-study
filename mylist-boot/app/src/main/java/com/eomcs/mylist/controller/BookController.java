package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController 
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    System.out.println("BookController() 호출됨!");
    try { 

      BufferedReader in = new BufferedReader (new FileReader("books.json"));

      ObjectMapper mapper = new ObjectMapper();

      //1) 객체를 JSON 형식의 ㅁ누자열로 생성한다.
      //=>어레이리스트에서 보드배열ㅇ르 꺼낸후, 제이슨 문자열로 만든다. 
      //String jsonStr = mapper.writeValueAsString(bookList.toArray()); // 어레이리스트에서 배열만 쏙 꺼내라 - 배열이 3개면 3개를 꺼낸다.

      Book[] books = mapper.readValue(mapper.writeValueAsString(bookList.toArray()), Book[].class);// 보드배열 클래스정보를 넘겨야함. 그 객체의 배열이라면 배열 표시를 하면된다. 

      //3) 배열 객체를 ArrayList에 저장한다.
      //반복문을 돌릴 수도있음
      //=> 다음과 같이 배열에서 한개씩 꺼내 목록에 추가할 수 있다. 
      // for(Book book: books) {
      // bookList.add(book);
      // }

      //=> 다음과 같이 addAll()을 호출하여 배열을 목록에 추가할 수 있다.
      // bookList.addAll(books);

      //=> 다음과 같이 생성자를 통해 배열을 목록에 추가할 수 있다.
      bookList = new ArrayList();
      in.close();

    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩중 오류 발생!");
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