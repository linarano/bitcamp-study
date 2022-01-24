package com.eomcs.openapi.json.test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test02 {

  public static void main(String[] args) throws Exception {
    String jsonStr = "[{\"name\":\"소보루\", \"maker\":\"안데르센\"}, {\"name\":\"소보루\", \"maker\":\"안데르센\"}]";

    ObjectMapper mapper = new ObjectMapper();

    Phone[] objs = mapper.readValue(jsonStr, Phone[].class);// 다 name,maker를 갖고있으므로, 알수없으므로 알려줘야한다. 

    for (Phone obj : objs) {
      System.out.println(obj);
    }
  }

}
