package com.eomcs.mylist.dao2;

import java.io.File;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.domain2.Contact;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository  
public class JsonContactDao extends AbstractContactDao {

  String filename = "contacts.json";

  public JsonContactDao() {
    try {
      ObjectMapper mapper = new ObjectMapper();
      contactList.addAll(mapper.readValue(new File(filename), 
          mapper.getTypeFactory().constructCollectionType(List.class, Contact.class)));

    } catch (Exception e) {
      System.out.println("연락처 데이터 로딩 중 오류 발생!");
    }
  }

  @Override
  protected void save() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), contactList.toArray());
  }
}











