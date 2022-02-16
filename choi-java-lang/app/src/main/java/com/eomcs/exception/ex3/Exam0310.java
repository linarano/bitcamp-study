// 던지는 예외를 메서드에 선언하기
package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0310 {

  // 메서드에서 발생되는 예외는 메서드 선언부에 모두 나열해야 한다.
  static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
    if (i == 0)
      throw new Exception();
    else if (i == 1)
      throw new RuntimeException();
    else if (i == 2)
      throw new SQLException();
    else
      throw new IOException();
  }

  public static void main(String[] args) {}

}

//원래는다 적어야되지만 (원칙)
// 상위클래스를 선언한다면 (하위클래스) 안적어도 가능 
// 빵, 소보루, 팥빵 