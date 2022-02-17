// 폴더 정보 조회 - java.io.File 클래스
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    // File 클래스
    // => 디렉토리나 파일을 다룰 때 사용하는 클래스이다.
    // => 디렉토리나 파일을 생성, 삭제, 변경할 수 있다.

    // 현재 디렉토리를 조회
    // => '.' 으로 표현한다.
    // => JVM을 실행하는 위치가 현재 폴더이다. //이클립스에서 실행하면 현재폴더는 무조건 프로젝트폴더다. java-lang/app property로 확인
    // => 이클립스 : 프로젝트 디렉토리를 가리킨다.
    // => 콘솔 : 현재 명령어를 실행하는 위치를 가리킨다.
    //
    File currentDir = new File("./src/main/java");
    System.out.printf("폴더명: %s\n", currentDir.getName());
    System.out.printf("경로: %s\n", currentDir.getPath());
    System.out.printf("절대경로: %s\n", currentDir.getAbsolutePath());
    System.out.printf("계산된 절대경로: %s\n", currentDir.getCanonicalPath());
    //long v = currentDir.getTotalSpace()/1024;
    //System.out.printf("바꾼거 총크기: %d\n",v);

    System.out.printf("총크기: %d\n", currentDir.getTotalSpace());
    System.out.printf("남은크기: %d\n", currentDir.getFreeSpace());
    System.out.printf("가용크기: %d\n", currentDir.getUsableSpace());// 다른용도로 확보된 공가있으면 프리스페이스라도 못쓴다. - 별도로 분리시킨거 뺴고 - 우리가 실제 쓸수잇는것

    System.out.printf("디렉토리여부: %b\n", currentDir.isDirectory());
    System.out.printf("파일여부: %b\n", currentDir.isFile());
    System.out.printf("감춤폴더: %b\n", currentDir.isHidden());
    System.out.printf("존재여부: %b\n", currentDir.exists());
    System.out.printf("실행가능여부: %b\n", currentDir.canExecute()); // 접근가능하냐 
  }
}

