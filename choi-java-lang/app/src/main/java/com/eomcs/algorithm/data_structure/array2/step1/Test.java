package com.eomcs.algorithm.data_structure.array2.step1;

import com.eomcs.algorithm.data_structure.array2.step2.Score;

public class Test {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add(new Score("홍길동", 100, 100, 100));
    list.add(new Score("안중근", 100, 100, 100));
    list.add(new Score("유관순", 100, 100, 100));
    list.add(new Score("윤봉길", 100, 100, 100));
    list.add(new Score("김상옥", 100, 100, 100));
    list.add(new String("오호라"));

    for (int i = 0; i < list.size(); i++) {
      // 불편1:
      // 목록에서 값을 꺼낼때마다 원래의 타입으로 형변한 한후 사용해야한다.
      //      
      Score s= (Score) list.get(i); // 문법적으로 Object를 꺼내도록 되어있으므로 컴파일러에게 알려줘
      System.out.printf("%s:%d, %f\n", s.name, s.sum, s.aver);
    }
  }
}
