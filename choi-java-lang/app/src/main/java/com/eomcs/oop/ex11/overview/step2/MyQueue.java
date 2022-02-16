package com.eomcs.oop.ex11.overview.step2;

public class MyQueue extends MyList {

  public void offer(Object obj) {
    this.add(obj);
  }

  public Object poll() {
    if (size == 0) {
      return null;
    }
    return remove(0);
  }

}

//아예 값을 껀내다. 맨앞의 껏을 꺼낸다. 
