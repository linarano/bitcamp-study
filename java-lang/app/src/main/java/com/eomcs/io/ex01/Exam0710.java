// 활용 - 지정한 폴더 및 그 하위 폴더까지 모두 검색하여 파일 및 디렉토리 이름을 출력하라.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0710 {

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

    // 리턴 받은 파일 배열에서 이름을 꺼내 출력한다.
    for (File file : files) {

      printIndent(level);

      if (file.isDirectory() && !file.isHidden()) {
        System.out.printf("%s/\n", file.getName());
        printList(file, level + 1);
      } else if (file.isFile()) {
        System.out.print("\\-- ");
        System.out.printf("%s\n", file.getName());
      }
    }
  }

  static void printIndent(int level) {
    for (int i = 0; i < level; i++) {
      System.out.print("  ");
    }
  }

}

// spring IOC 기반 기술이 될것
//재귀호출 밑 파일탐색 - 폴더와 폴더를 따라들어가는 것.
//윈도우 트리 

//삭제할때 맨 아래폴더를 삭제하면서 따라올간다. 

//손코딩으로 기술면접때 많이 나온다. (손코딩은 연봉 높은 곳) - 지원자가 많으니 골라서 뽑는다. 
//복사붙여넣기 할때 구글검색 안하고도 자신으 ㅣ실력으로 하는 사람을 뽑는다는 의미 