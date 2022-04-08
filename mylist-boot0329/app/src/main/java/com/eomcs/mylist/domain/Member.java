package com.eomcs.mylist.domain;

import java.sql.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true) // 그 객체의 주소리턴 this를 주고 주소값리턴 그 메서드의 준 객체를 다시리턴한다
//리턴된 객체에 대해서 호출하니까 같은
public class Member {
  int no;
  String name;
  String email;
  String password;
  Date registDate;

}
