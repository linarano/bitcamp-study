package com.eomcs.mylist.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 현재 정의하는 애노테이션은 오직 클래스나 인터페이스에만 붙일 수 있게 제한한다. - 클래스에만 붙일수 있게 제한
@Retention(RetentionPolicy.RUNTIME) // 현재 정의하는 애노테이션 정보를 JVM 실행 중에 클래스 정보에서 다음 애노테이션을 추출할 수 있게 허락한다.
public @interface Component {// 객체를 자동 생성하고 싶을 떄 붙이는 애노테이션 
  String value();// 메서드 처럼 선언
}

//애노테이션을 만들때 클래스에서만 붙일 수 있고, 메서드에만 붙이거나 할 수 있는 다양함
//만들어진대로 