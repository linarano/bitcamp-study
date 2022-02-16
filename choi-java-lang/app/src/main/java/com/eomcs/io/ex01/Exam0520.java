// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기 II - 디렉토리와 파일 구분 
package com.eomcs.io.ex01;

import java.io.File;
import java.sql.Date;

public class Exam0520 {

  public static void main(String[] args) throws Exception {

    File dir = new File(".");

    // 파일이나 디렉토리 정보를 File 객체로 받기
    // => File은 디렉토리와 파일을 통칭하는 용어다.
    //
    File[] files = dir.listFiles();

    for (File file : files) {
      System.out.printf("%s   %s %12d %s\n",
          file.isDirectory() ? "d" : "-", // 조건연산자 "-" 파일 
              new Date(file.lastModified()),//java.util- 영어형식으로 리턴, java.util.DATE.sql (서브클래스임)
              file.length(),
              file.getName());
    }

  }

}


