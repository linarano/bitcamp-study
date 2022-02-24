package com.eomcs.mylist;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoMaker {
  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);

    int[] numbers = {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 
        16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 
        31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45
    };

    //숫자위치 바꾸기
    for (int i = 0; i < 100; i++) {
      int x = (int) (Math.random() * 45);
      int y = (int) (Math.random() * 45);
      int temp = numbers[x];
      numbers[x] = numbers[y];
      numbers[y] = temp;
    }


    ArrayList<Integer> lottoNumbers = new ArrayList<>();
    for (int pickNumber : numbers) {
      lottoNumbers.add(pickNumber);
    }

    System.out.println("자동번호 추첨- 총 7회");
    keyScan.nextLine();


    int count = 0;
    int check = 0;


    while (lottoNumbers.size() > 0) {

      System.out.printf("  %2s ", lottoNumbers.remove((int) (Math.random() * lottoNumbers.size())));


      if((++count % 6) == 0) { 
        System.out.printf("[%2d회 ] %n", ++check);
        System.out.println("-------------------------------"); 
        keyScan.nextLine();
      }

      if(lottoNumbers.size() < 4) {
        System.out.printf("추첨완료");
        break; 
      }
    } 

    keyScan.close();
  }
}
