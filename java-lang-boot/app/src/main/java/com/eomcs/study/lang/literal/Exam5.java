//리터럴 : 문자 리터럴
package com.eomcs.study.lang.literal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang/literal/exam5")
public class Exam5 {

  @RequestMapping("/test1")
  public String test1() {
    return "문자1: " + 'A'+","+'가';
  }

  @RequestMapping("/test2")
  public String test2() {
    return  "문자2: " + '\u0041'+","+'\uac00';//문자에 대한 유니코드 값을 지정해도 된다.
  }

  @RequestMapping("/test3")
  public String test3() {
    return "문자3: " + (char)0x41+","+(char)0xac00; //문자 코드를 정수값으로 지정한다.
  }//대신 문자를 가리키는 코드임을 표시한다.

  @RequestMapping("/test4")
  public String test4() {
    return "문자4: " + (char)65+","+(char)44032; //문자의 코드 값은 그냥 정수값이다.
    //대신 문자를 가리키는 코드임을 표시해야한다.
  }

}

