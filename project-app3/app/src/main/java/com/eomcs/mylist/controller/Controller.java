package com.eomcs.mylist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 페이지 컨트롤러가 반드시 갖춰야 할 기능
// => 프론트 컨트럴러(caller)가 페이지컨트롤러(callee)를 사용할 떄 호출하는 규칙(항상 인터페이스)
// => 콜리, 또는 콜러를 만들때가 있다. 둘다 만들어야하는지 판단을 내려야함
public interface Controller {
  String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
