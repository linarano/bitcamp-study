package com.eomcs.mylist.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;
import com.eomcs.mylist.service.ContactService;


//전통적인 오퍼레이션 방법 
@Service
public class DefaultContactService implements ContactService {
  //DefaultContactServiceImpl
  @Autowired
  ContactDao contactDao;

  @Override
  @Transactional // 다음 메서드는 트랜잭션 안에서 실행하도록 설정한다.
  public int add(Contact contact) {
    contactDao.insert(contact);
    for (ContactTel tel : contact.getTels()) {
      tel.setContactNo(contact.getNo()); // 전화번호 입력 전에 자동 생성된 연락처 번호를 설정한다.
      contactDao.insertTel(tel);
    }

    public List<Contact> list() {
      List<Contact> contacts = contactDao.findAll();
      for (Contact contact : contacts) {
        contact.setTels(contactDao.findTelByContactNo(contact.getNo()));
      }
      return contacts;
    }

    public Contact get(int no) {
      Contact contact = contactDao.findByNo(no);
      if (contact != null) {
        contact.setTels(contactDao.findTelByContactNo(no));
      }
      return contact;
    }

    @Transactional
    public int update(Contact contact) {
      DefaultTransactionDefinition def = new DefaultTransactionDefinition();
      def.setName("t1"); 
      def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

      TransactionStatus status = transactionManager.getTransaction(def);
      try {
        int count = contactDao.update(contact);
        if (count > 0) {
          contactDao.deleteTelByContactNo(contact.getNo()); // 전화번호 변경 전에 기존 전화번호를 모두 삭제한다.
          for (ContactTel tel : contact.getTels()) {
            contactDao.insertTel(tel); // 전화번호 객체에 안에 이미 연락처 번호가 저장되어 있다.
          }
        }
        transactionManager.commit(status);
        return count;

      } catch (Exception e) {
        transactionManager.rollback(status);
        throw e;
      }
    }

    @Transactional
    public int delete(int no) {
      contactDao.deleteTelByContactNo(no);
      int count = contactDao.delete(no);


      throw e;
    }
  }


}







