package com.eomcs.openapi.json.test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test01 {

  public static void main(String[] args)throws Exception {
    String jsonStr ="{\"name\":\"소보루\", \"maker\":\"안데르센\"}";

    ObjectMapper mapper = new ObjectMapper();

    Phone obj = mapper.readValue(jsonStr, Phone.class);// 다 name,maker를 갖고있으므로, 알수없으므로 알려줘야한다. 
    System.out.println(obj);

  }

}
