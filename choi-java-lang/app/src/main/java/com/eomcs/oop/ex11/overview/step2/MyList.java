package com.eomcs.oop.ex11.overview.step2;

import java.util.Arrays;

public class MyList {
  Object[] arr = new Object[10];
  int size;

  public void add(Object obj) {
    if (size == arr.length){ 
      arr = Arrays.copyOf(arr,arr.length + (arr.length >> 1)); // 나누기 2한것과 같음 기존보다 절반정도 더큰 배열 만듬 1.5 //  이제 반복문 돌려서 꺼낼필요없음 -클래스의 도구를 사용하라. 
    }   
    arr[size++] = obj; //  size는 항상 현재집어넣을 위치를 가리킴 
  }


  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException();// 런타임익셥션의 자손이므로 - 개발자 편의를 위해  - 예외를 던지면 항상 받는쪽에서 트라이캐치 또는 쓰로우쓰롤 선언 상위에 던져 
    } // 강제하지않으니까 프로그램 짜기가 편함. -    //예외가 발생했을때 무시하라는게 아니라. 처리하긴 처리해야하지만 매번 그걸 쓸때마다 꼬박꼬박 적을 필요없다. 
    return arr[index];
    //일반익셉션개열이면 호출하는 쪽에서도 적어줘야함 / 만드는 쪽에서도 적어줘야하지만 
    //최소 메인메서드 위치, 적절한 위치에서 일반익셉션이든 ,런타임익셉션이든 반드시 걸러내야함.  메인마져 안받으면 버츄얼머신까지 가면 무조건 프로그램을 종료해버린다. 
  } 

  public int size() {
    return size;// 메서드이름과 필드명이 같아도 상관없다. 
  }

  // 배열 테스트하기 좋음 - 삭제가 많이 나온다. ***** - 최소자격이 된다. 
  public Object remove (int index) {
    if(index <0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException();
    } 

    Object old = arr[index];

    for(int i = index ; i < (size-1) ; i++) { // 맨마지막까지 반복문을 돌것 ㄱ
      arr[i] = arr[i+1];// 할당연산자 - 복사하는거지 옮기는게 아님 //' 앞으로 값을 떙긴다.라는 표현은 " 레퍼런스카운터가 1개증가 하므로 2개가 되므로 가비지컬렉션 - 레퍼런스를 증가하지않기 위해서 
    }
    //--size
    arr[--size] = null; //  배열의 크기를 줄이고, 마지막 항목에 들어있는 값을  null로 초기화하여 객체의 레퍼런스를 줄인다. // 객체를 자동으로 초기화하는 시스템인경우(GC와 같이), 더이상 객체를 쓰지않을때는 객체를 참조하는 레퍼런스가 없도록 유념해서 관리 - 프로페셔널한것 
    return old;
  }
}

// 배열의 끝을 지운다면 앞으로 땡길게 없어서 반복문을 돌면 안된다. 
//참조하는 주소가 있으면 가비지가 되지않는다.  -> 쓰는데는 지장이 없다. 사이즈는 줄었으니까 
//근데 이걸 주소를 그대로 놔두면 가비지가 되지않는다.
//따라서 맨 마지막은 

//그 객체의 주소를 참조하고 있는 변수가 없을 떄 우리는 그 변수를 가비지라고 한다. 


//객체의 주소를 저장한 배열이라면
//
