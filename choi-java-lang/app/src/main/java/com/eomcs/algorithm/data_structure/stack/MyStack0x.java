package com.eomcs.algorithm.data_structure.stack;

import java.util.EmptyStackException;
import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

// 1) Stack 을 구현하기 위해 기존에 작성한 MyLinkedList를 상속 받는다.
public class MyStack0x<E> extends MyLinkedList<E> {

  public E push(E item) {
    add(item);
    return item;
  }

  public E pop() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    return remove(size()-1);
  }

  public E peek() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    return get(size() - 1);
  }

  public boolean empty() {
    return size() == 0;
  }
  @SuppressWarnings("unchecked")
  @Override
  public MyStack0x<E> clone() throws CloneNotSupportedException {
    MyStack0x<E> newStack = new MyStack0x<>();
    Object[] values = this.toArray();
    for (Object value : values) {
      newStack.push((E)value);
    }
    return newStack;
  }
}
