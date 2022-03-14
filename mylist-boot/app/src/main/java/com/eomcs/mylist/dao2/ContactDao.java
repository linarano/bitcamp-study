package com.eomcs.mylist.dao2;

import com.eomcs.mylist.domain2.Contact;

public interface ContactDao {

  int countAll();

  Object[] findAll();

  void insert(Contact contact) throws Exception;

  Contact findByEmail(String email);

  int update(Contact contact) throws Exception;

  int delete(String email) throws Exception;
}











