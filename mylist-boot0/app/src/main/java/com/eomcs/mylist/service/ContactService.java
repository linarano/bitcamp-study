package com.eomcs.mylist.service;

import java.util.List;
import com.eomcs.mylist.domain.Contact;


public interface ContactService {

  int add(Contact contact); 

  List<Contact> list();

  Contact get(int no);

  int update(Contact contact) ;

  int delete(int no);

}





// 똑같은 add라도 각 객체마다 하는방식이 다름 (그림 확인 )