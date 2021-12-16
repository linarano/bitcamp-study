package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController{


  String[] contacts = new String[5];
  int size = 0;

  @RequestMapping("/contact/list")
  public Object list() {
    String[] arr = new String [size];// 배열에 저장된 값만 복사할 새 배열을 만든다.
    for (int i = 0; i < size; i++) { // 전체 배열에서 값이 들어있는 항목만 복사한다.
      arr[i] = contacts[i];
    }
    return arr; // 복사한 항목들을 담고 있는 새 배열을 리턴한다.
  }


  @RequestMapping("contact/add")
  public Object add(String name, String email, String tel, String company) {
    contacts[size++] = createCSV(name, email, tel, company);
    // v-1    
    //    String contact = name + "," + email + "," + tel + "," + company;
    //    contacts[size++] = contact;
    return size;
  }  

  @RequestMapping("contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contacts[index];
  }

  //    for(int i = 0; i < size; i++) {
  //      //  학습용
  //      //      String contact = contacts[i];// 예) "u1,u1@test.com,1111,비트캠프"
  //      //      String[] values = contact.split(",");
  //      //      if (values[1].equals(email)) {
  //      //        return contacts[i];
  //      //      }
  //
  //      // 실전
  //      if(contacts[i].split(",")[1].equals(email)) {
  //        return contacts[i];      
  //      } 
  //    }
  //    return "";


  @RequestMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    int index = indexOf(email);
    if (index == -1) {
      return 0 ;
    }

    contacts[index] = createCSV(name, email, tel, company);
    return 1;
  }

  //    for (int i = 0; i < size; i++) {
  //      if(contacts[i].split(",")[1].equals(email)) {
  //        contacts[i] = contact;
  //        return 1;
  //      }
  //    }
  //    return 0;
  //  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    remove(index);
    return 1;
  }
  //  for (int i = 0; i < size; i++) {
  //    if(contacts[i].split(",")[1].equals(email)) {
  //      for (int j = i + 1; j < size; j++) {
  //        contacts[j-1] = contacts[j]; 
  //      }
  //      size--;
  //      return 1;
  //    }
  //  }
  //  return 0;
  //}
  //기능:
  // - 입력받은 파라미터 값을 가지고 CSV형식으로 문자열을 만들어 준다.
  //
  String createCSV(String name, String email, String tel, String company) {
    return name + "," + email + "," + tel + "," + company;
  }
  //기능:
  // - 이메일로 연락처 정보를 찾는다.
  // - 찾은 연락처의 배열 인덱스를 리턴한다.
  //
  int indexOf(String email) {
    for (int i = 0; i < size; i++) {
      if(contacts[i].split(",")[1].equals(email)){
        return i ;
      }
    }    
    return -1;
  }
  //기능:
  // - 배열에서 지정한 항목을 삭제한다.
  //
  String remove(int index) {
    String old = contacts[index];
    for (int i = index + 1; i < size; i++) {
      contacts[i - 1] = contacts[i]; 
    }
    size--;
    return old;
  }

}


