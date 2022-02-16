package com.eomcs.algorithm.data_structure.array2.step2;

import java.util.Arrays;

//ArrayList 클래스에서 다룰 항목의 타입을 파라미터로 받는다. (외부에서 값을 받는다 => 파라미터)
//=> 외부에서 타입 정보를 받는 파라미터 =>  "타입 파라미터" 라고 부른다.
public class ArrayList<itemType> {// 어레이리스트에 답을 그 항목의 타입 변수명선언

  private static final int DEFAULT_CAPACITY = 5;
  private Object[] elementData;
  private int size;

  public ArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      elementData = new Object[DEFAULT_CAPACITY];
    } else {
      elementData = new Object[initialCapacity];
    }
  }

  public boolean add(itemType e) {// 제약을 거는 것
    if (size == elementData.length) {
      grow();
    }
    elementData[size++] = e;
    return true;
  }

  private void grow() {
    //System.out.println("오호라! 배열을 늘리자.");
    int newCapacity = elementData.length + (elementData.length >> 1);
    elementData = Arrays.copyOf(elementData, newCapacity);
    /*
    Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
    for (int i = 0; i < elementData.length; i++) {
      newArray[i] = elementData[i];
    }
    elementData = newArray;
     */
  }


  public void add(int index, itemType element) { //타입변수, 레퍼런스변수
    if (size == elementData.length) {
      grow();
    }
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    for (int i = size; i > index ; i--) {
      elementData[i] = elementData[i - 1];
    }
    elementData[index] = element;
    size++;
  }

  @SuppressWarnings("unchecked") // 경고에 대해서 억제 - 타입이 체크되지않은 경고를 
  public itemType get(int index) { // 아이템 타입에 들어있는 리턴
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    return (itemType)elementData[index];
  }

  public Object set(int index, Object element) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    Object old = elementData[index];
    elementData[index] = element;
    return old;
  }

  public Object remove(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }

    Object old = elementData[index];

    System.arraycopy(
        elementData, // 복사 대상
        index + 1, // 복사할 항목의 시작 인덱스
        elementData, // 목적지
        index, // 복사 목적지 인덱스
        this.size - (index + 1) // 복사할 항목의 개수
        );
    /*
    for (int i = index; i < size - 1; i++) {
      elementData[i] = elementData[i + 1];
    }
     */

    size--;
    elementData[size] = null;
    // 쓰지 않는 인스턴스의 주소를 제거하여
    // 가비지 될 수 있게 한다.

    return old;
  }

  public int size() {
    return this.size;
  }

  public Object[] toArray() {
    Object[] arr = Arrays.copyOf(elementData, this.size);
    //System.out.println(elementData == arr); //false
    return arr;
    /*
    Object[] arr = new Object[this.size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = elementData[i];
    }
    return arr;
     */
  }
}




