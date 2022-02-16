// 활용 - 지정한 폴더 및 그 하위 폴더까지 모두 검색하여 파일 및 디렉토리 이름을 출력하라.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0710_06 {

  public static void main(String[] args) throws Exception {

    // 결과 예)
    // /Users/bitcamp/git/test
    // src/
    //   main/
    //     java/
    //       com/
    //         Hello.java
    //         Hello2.java
    // build.gradle
    // settings.gradle
    // Hello.java
    // ...

    File dir = new File(".");
    System.out.println(dir.getCanonicalPath());

    printList(dir, 1);
  }

  static void printList(File dir, int level) {
    // 현재 디렉토리의 하위 파일 및 디렉토리 목록을 알아낸다.
    File[] files = dir.listFiles();

    // 리턴 받은 파일 배열에서 이름을 꺼내 출력한다. //재귀호출,인덴트 -> 스프링아이오씨컨터이너 동작원리 이해가능 -> @ 붙은애들 따로 추출해서 객체 생성, 폴더와 하위폴더를 따라들어가면서 파일을 찾아내는 것
    for (File file : files) {
      for (int i = 0; i < level; i++) {
        System.out.print("  "); // 들여쓰기 추가
      }

      if (file.isDirectory() && !file.isHidden()) {
        System.out.printf("%s/\n", file.getName());
        printList(file, level + 1);
      } else if (file.isFile()) {
        System.out.printf("%s\n", file.getName());
      }
    }
  }
}

//써먹는데는 다 이유가 있다. 재귀호출
//어렵지않으면 시험문제 않낸다.
//쉬운데 불구하고 (많이해보면 익숙해진다)
//사람들은 재귀호출을 어려워한다. 
//재귀호출에 익숙한지를 보는 것.
