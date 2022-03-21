package com.eomcs.mylist.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;
import com.eomcs.mylist.service.ContactService;

//@Service //컴포넌트, 리파지토리, 컨트롤러 다 되지만 관리위해서 통제위해서 - 서비스객체만 생성될 수 있다. : 서비스객체가 자동으로 생성된상태
public class NoneTransactionContactService implements ContactService {
  @Autowired
  ContactDao contactDao;


  @Override
  public int add(Contact contact) { // 컨트럴러에서 강해서 이미 팩스번호등을 담아줬을것
    contactDao.insert(contact);
    for (ContactTel tel : contact.getTels()) {
      tel.setContactNo(contact.getNo()); // 전화번호 입력 전에 자동생성된 연락처 번호를 생성한다.
      contactDao.insertTel(tel);
    }
    return 1;
  }

  @Override
  public List<Contact> list() {
    List<Contact> contacts = contactDao.findAll();
    for (Contact contact : contacts) {
      contact.setTels(contactDao.findTelByContactNo(contact.getNo()));
    }
    return contacts;
  }

  @Override
  public Contact get(int no) {
    Contact contact = contactDao.findByNo(no);
    if (contact != null) {
      contact.setTels(contactDao.findTelByContactNo(no));
    }
    return contact;
  }

  @Override
  public int update(Contact contact){
    int count = contactDao.update(contact);
    if (count > 0) {
      contactDao.deleteTelByContactNo(contact.getNo()); // 전화번호 변경 전에 기존 전화번호를 모두 삭제한다.
      for (ContactTel tel : contact.getTels()) {
        contactDao.insertTel(tel); //전화번호 객체 안에 이미 연락처 번호가 저장되어 있다.
      }
    }
    return count;
  }

  @Override
  public int delete(int no) {
    contactDao.deleteTelByContactNo(no);//전화번호먼저지우고, 연락처번호 지우고
    return contactDao.delete(no);
  }
}  


// 똑같은 add라도 각 객체마다 하는방식이 다름 (그림 확인 )