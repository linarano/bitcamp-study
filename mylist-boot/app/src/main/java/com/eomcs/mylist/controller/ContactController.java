package com.eomcs.mylist.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

//1) 생성자에서 FileReader 객체를 준비한다.
//2) 파일에서 문자를 읽어 출력한다.
//3) 파일을 더이상 읽을 수 없으면 반복문을 종료한다.
//4) 파일에서 읽은 문자를 버퍼에 담았다가 줄바꿈 코드를 만나면 출력한다. 
//5) 한 줄 출력한 다음에 버퍼를 비운다.
//6) 한 줄의 CSV 데이터를 읽어 분석한 후 Contact 객체에 담아서 목록에 추가한다.
//7) CSV 데이터로 Contact 객체를 초기화시키는 일을 Contact 객체의 생성자로 옮긴다.
//8) Contact 클래스의 valueOf() 스태틱 메서드를 사용하여 CSV 데이터로 객체를 생성한다.
//9) while 문 정리!
//

@RestController 
public class ContactController {

  ArrayList contactList;

  public ContactController() throws Exception {
    contactList = new ArrayList();
    System.out.println("ContactController() 호출됨!");

    try { 

      BufferedReader in = new BufferedReader (new FileReader("contacts.json"));

      // JSON 문자열을 다룰 객체 준비
      ObjectMapper mapper = new ObjectMapper();

      // 1) JSON 파일에서 문자열을 읽어 온다.
      // => 읽어 온 문자열은 배열 형식이다.
      String jsonStr = in.readLine();

      // 2) JSON 문자열을 가지고 자바 객체를 생성한다.
      // => 배열 형식의 JSON 문자열에서 Board의 배열 객체를 생성한다.
      Contact[] contacts = mapper.readValue(jsonStr, Contact[].class);// 보드배열 클래스정보를 넘겨야함. 그 객체의 배열이라면 배열 표시를 하면된다. 


      // 3) 배열 객체를 ArrayList 에 저장한다.
      // => 다음과 같이 배열에서 한 개씩 꺼내 목록에 추가할 수 있다.
      //      for (Board board : boards) {
      //        boardList.add(board);
      //      }

      // => 다음과 같이 addAll()을 호출하여 배열을 목록에 추가할 수 있다.
      //      boardList.addAll(boards);

      // => 다음과 같이 생성자를 통해 배열을 목록에 추가할 수 있다.
      // contactList.addAll(contacts);

      contactList = new ArrayList(contacts);
      in.close();

    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩중 오류 발생!");
    }
  }

  @RequestMapping("/contact/list")
  public Object list() {
    return contactList.toArray(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    contactList.add(contact);
    return contactList.size();
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contactList.get(index);
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.getEmail());
    if (index == -1) {
      return 0;
    }

    return contactList.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    contactList.remove(index);
    return 1;
  }

  @RequestMapping("/contact/save")
  public Object save() throws Exception {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contacts.json")));

    // JSON 형식의 문자열을 다룰 객체를 준비한다. 
    ObjectMapper mapper = new ObjectMapper();

    //1) 문자열로 생성한다.
    //2) 제이슨형식의 문자열을 파일로 출력
    out.println( mapper.writeValueAsString(contactList.toString()));// 버퍼드리더로 읽으려면 한줄로 


    out.close();
    return contactList.size();
  }

  int indexOf(String email) {
    for (int i = 0; i < contactList.size(); i++) {
      Contact contact =  (Contact) contactList.get(i);
      if (contact.getEmail().equals(email)) { 
        return i;
      }
    }
    return -1;
  }
}




