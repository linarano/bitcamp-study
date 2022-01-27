// 추상 클래스와 추상 메서드의 활용: 적용 전
package com.eomcs.oop.ex07.b;

import java.util.Arrays;

public class Exam01 {

  static int[] createRandomNumbers(final int size) { //
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = i;
    }

    int count = size >> 1; // 1/2로 나눈것 오른쪽 이동 - 10만을 5만 교환
    for (int i = 0; i < count; i++) {
      int index1 = (int)(Math.random() * size); 
      int index2 = (int)(Math.random() * size);
      int temp = arr[index1];
      arr[index1] = arr[index2];
      arr[index2] = temp;
    }
    return arr;
  }

  public static void main(String[] args) {

    int[] values = createRandomNumbers(100000);
    int[] values2 = Arrays.copyOf(values, values.length); //  같은값을 갖는 배열 리턴 - 마찬가지로 10만개배열


    BubbleSort s1 = new BubbleSort();
    QuickSort s2 = new QuickSort();

    // 두 개의 정렬 객체가 서로 다른 타입이기 때문에
    // 정렬을 수행하고 출력할 메서드를 따로 따로 만들어야 한다.
    // 클래스의 사용법도 달라서 불편하다.
    // BubbleSort 객체는 run()을 호출해야 하고,
    // QuickSort 객체는 start()를 호출해야 한다.
    //
    display(s1, values);
    display(s2, values2);

  }

  // 정렬을 수행하는 객체와 값을 주면
  // 그 값을 정렬한 후 출력하는 메서드이다.
  static void display(BubbleSort sorter, int[] values) {

    //System.out.println("[정렬 전]");
    //printNumbers(values);

    long start = System.currentTimeMillis();

    // BubbleSort 사용법에 맞춰 정렬을 수행한다.
    sorter.run(values);

    long end = System.currentTimeMillis();
    System.out.printf("걸린시간: %d\n", end - start);

    //System.out.println("[정렬 후]--------------------------");
    //printNumbers(values);
  }

  static void display(QuickSort sorter, int[] values) {

    //System.out.println("[정렬 전]");
    //printNumbers(values);

    long start = System.currentTimeMillis();

    // QuickSort 사용법에 맞춰 정렬을 수행한다.
    sorter.start(values, 0, values.length - 1); // 시작과 끝 줘야함 

    long end = System.currentTimeMillis();
    System.out.printf("걸린시간: %d\n", end - start);

    //System.out.println("[정렬 후]--------------------------");
    //printNumbers(values);
  }

  static void printNumbers(int[] values) {
    for (int  value : values) {
      System.out.print(value + ",");
    }
    System.out.println();
  }
}



// 각메서드가 어떻게 동작하는지 무시하고 
//일단 추상클래스가 왜필요한지 배우는것다.
//알고리즘- 어떠방식으로 돌아가게 할것이냐 - 실행속도 * 알고리즘의 중요성
//sort는 왠만하면 다 공개되어있음 
//정렬, 자료구조 알고리즘 공부하고 직접구현이유 - 조건문,반복문,배열, 값을 다루는 방법을 훈련하는 방식으로 컴공에서 공부한다. -문법, 알고리즘차이(방법론)-실행효율이 극도라 달라진다.
//알고리즘 다루다보면 자바랭귀지(프로그래밍언어) 익숙해질 수 있다.

//회사에서 알고리즘 시험보는 이유 - 3개월정도 쓰면서 검증하기에는 회사가 널널하지않음, 실력측정단기간에 확인하기 좋기떄문에

//게시판, 회원관리,로그인,로그아웃,쇼핑몰- 카카오에 들어가기는 힘들어.
//최소시험통과 - 알고리즘 통과후, 기술면접 
//언어에 숙련된 인재를 추려낸후, 자신회사에 맞는데를 뽑겠다.

// 따라서 첫관문 통과 - 따로 준비해야함 알고리즘 준비.
//감각적으로 푸는게 아니라 연습이필요함. 
//이직을 위해서는 6개월정도 공부하면서 투자해야함. 
//경력이 쌓였다가 푸는것아니다. 
//시험을 위한공부를 해야함. 



