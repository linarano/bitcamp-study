//리터럴 : 숫자를 표현한느 다양한 방법 - 진수법
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lang/literal/exam2")
public class Exam2 {

  @RequestMapping("/test1")
  public int test1() {
    //10진수(숫자를 표현할 때 기본적으로 많이 사용)
    return 100;
  }

  @RequestMapping("/test2")
  public int test2() {
    //8진수
    return 0144;
  }

  @RequestMapping("/test3")
  public int tes3() {
    //2진수 binary
    return 0b0110_0100;
  }

  @RequestMapping("/test4")
  public int test4() {
    //16진수 (문자의 코드값을 표현할 때 많이 사용)
    return 0x64;
  }



}
