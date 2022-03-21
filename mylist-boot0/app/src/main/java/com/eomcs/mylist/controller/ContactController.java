package com.eomcs.mylist.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;
import com.eomcs.mylist.service.ContactService;

@RestController 
public class ContactController {

  @Autowired
  ContactService contactService; //구체적인 클래스 대신 인터페이스를 지정한다.(아래문제 해결)
  //
  //  @Autowired
  //  ContactServiceNoneTransaction contactService; =>매번 소스코드를 상황에 맞게 변경해야한다는 단점이 있음 

  @RequestMapping("/contact/list")
  public Object list() {
    return contactService.list(); // 간단한 메서드라도 일관성을 위해서 - Dao를 바로 호출하지 못하도록 해라
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact, String[] tel) throws Exception {

    //요청 파라미터 분석 및 가공
    ArrayList<ContactTel> telList = new ArrayList<>(); 
    for (int i = 0; i < tel.length; i++) {
      String[] value = tel[i].split("_");
      if (value[1].length() == 0) {
        continue;
      }
      ContactTel contactTel = new ContactTel(Integer.parseInt(value[0]),value[1]); // 파라미터를 받으면 생성자를 추가해야함 =>ContactTel 클래스
      telList.add(contactTel);
    }
    contact.setTels(telList);

    // 서비스 객체 실행
    return contactService.add(contact);

    /*
    // 1) 트랜잭션으로 묶어서 실행할 작업을 정의
   //  => 스프링 프레임워크에서 정한 규칙에 따라 정의해야 한다.
    class ContactAddTransaction implements TransactionCallback {
      @Override
      public Object doInTransaction(TransactionStatus status) {
        // 트랜잭션으로 묶어서 할 작업을 기술한다.
        contactDao.insert(contact);
        for (int i = 0; i < tel.length; i++) {
          String[] value = tel[i].split("_");
          if (value[1].length() == 0) {
            continue;
          }
          contactDao.insertTel(new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1]));
        }
        return 1;
      }
    }

    // 2) 트랙잭션 작업을 수행한다.(연락처 등록) //내부적처리 : 스프링부트(스프링을 팩시켜놓은것) 설정안하면 우리가 다 개별적 설정해줘야함(웹MVC) 
    return transactionTemplate.execute(new ContactAddTransaction());
     */
  }

  @RequestMapping("/contact/get")
  public Object get(int no) {
    Contact contact = contactService.get(no); //데이터 처리는 서비스가 - null아니면 객체를 리턴한다.
    if (contact == null) {
      return ""; // 컨트롤러는 서비스 객체의 리턴 값에 따라 응답 데이터를 적절히 가공하여 리턴한다. 
    }
    return contact;
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact, String[] tel) throws Exception {
    // 요청파라미터 분석 및 가공
    ArrayList<ContactTel> telList = new ArrayList<>(); 
    for (int i = 0; i < tel.length; i++) {
      String[] value = tel[i].split("_");
      if (value[1].length() == 0) {
        continue;
      }
      // 연락처 변경의 경우 이미 연락처 번호를 알기때문에
      // 전화번호를 객체에 담을 떄 연락처 정보도 함께 저장 (등록과 다름)
      ContactTel contactTel = new ContactTel(contact.getNo(),Integer.parseInt(value[0]),value[1]);
      telList.add(contactTel);
    }
    contact.setTels(telList);

    //서비스 객체 실행 
    return contactService.update(contact);
  }

  @RequestMapping("/contact/delete")
  public Object delete(int no) throws Exception {
    return contactService.delete(no);
  }

}




