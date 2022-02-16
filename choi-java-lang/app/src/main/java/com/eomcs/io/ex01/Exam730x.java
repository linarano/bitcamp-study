// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Exam730x {

  public static void main(String[] args) throws Exception { //mian이 스태틱, 같은 스태틱멤버만 가능해 

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir);
  }

  static void printClasses(File dir) throws IOException { //exception의 서브 
    System.out.println(dir.getCanonicalPath());

    class JavaClassFilter implements FileFilter {
      @Override
      public boolean accept(File pathname) {
        // TODO Auto-generated method stub
        return false;
      }
    }

    File[] files = dir.listFiles();
    for(File f : files) {
      System.out.println(f.getName());
    }
  }

}


