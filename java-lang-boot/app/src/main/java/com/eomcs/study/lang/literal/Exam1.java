//리터럴 : 자바에서 값을 표현한 것
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lang/literal/exam1")
public class Exam1 {

  @RequestMapping("/test1")
  public String test1() {
    //문자열을 표현하는 방법
    return "홍길동";
  }

  @RequestMapping("/test2")
  public char test2() {
    //문자를 표현하는 방법
    return '홍';
  }

  @RequestMapping("/test3")
  public int tes3() {
    //정수를 표현하는 방법
    return 100;
  }

  @RequestMapping("/test4")
  public double test4() {
    //부동소수점을 표현하는 방법
    return 3.14;
  }

  @RequestMapping("/test5")
  public boolean test5() {
    //논리 값을 표현하는 방법
    return false;
  }

  @RequestMapping("/test6")
  public Object test6() {
    //주소가 지정되지 않았음을 표현하는 방법
    return null;
  }

}
