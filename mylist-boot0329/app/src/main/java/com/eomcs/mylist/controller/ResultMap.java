package com.eomcs.mylist.controller;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResultMap {
  public static final String SUCCESS ="success"; //셋터를 통해서만 접근하게금. 외부에서 접근못하도록 
  public static final String FAIL= "fail";

  private String status;
  private Object data;
}

//@Accessors(fluent = true) 필드이름으로 겟터셋터가 만들어진다 
//요즘 트렌드 get/set 접두어로 안붙이고 롬벅쓰는 사람은

//제이슨으로 바꾸는 쪽에서 못받아들임
//스프링에서 자바 객체를 제이슨객체로 바꿀때 겟셋메서드로 찾음
//겟셋대신 필드명을 가지고 할려고 했더니 에러 
//다만 셋메서드의 리턴값은  ResultMap
// 자바에서는 프로퍼티를 겟메서드, 셋메서드로 인식하기때문에 
// 안드로이 등의 다른언어와 다르게 

//오타가 날 가능성이 있기때문에 상수값을 선언해라 