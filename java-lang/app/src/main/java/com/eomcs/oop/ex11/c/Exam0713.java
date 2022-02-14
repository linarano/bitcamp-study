// inner class 응용 I : 리랙토링  
package com.eomcs.oop.ex11.c;

import java.util.ArrayList;
import java.util.List;

public class Exam0713 {

  public static void main(String[] args) {
    Musics3 m1 = new Musics3();
    m1.add("aaa.mp3");
    m1.add("bbb.mp3");
    m1.add("ccc.mp3");

    Musics3 m2 = new Musics3();
    m2.add("xxx.mp3");
    m2.add("yyy.mp3");

    // 바깥 클래스의 인스턴스를 사용하는 inner 클래스라면
    // inner 클래스의 객체를 만드는 역할도 
    // 바깥 클래스가 하는데 유지보수에 더 낫다.
    // => GRASP 설계 기법에서 "정보를 가진자가 그 일을 하라.(Information Expert)"를 적용. - 어떤 클래스에게 어떤 책임(roll ,responsibility)를 맡길건지 정신
    Musics3.Player p1 = m1.createPlayer(); //플레이어는 뮤직이 쓴다. 따라서 플레이어도 만들게 해라. 
    Musics3.Player p2 = m2.createPlayer();// 뮤직정보 가진자가 플레이어를 만들어라라는 의미
    // 팩토리 메서드 //
    p1.play();
    p2.play();
  }
}


class Musics3 {

  List<String> songs = new ArrayList<>();

  public void add(final String song) {
    songs.add(song);
  }

  public void delete(final int index) {
    songs.remove(index);
  }

  // inner 클래스의 객체를 생성하는 역할을 바깥 클래스가 맡는다.
  public Player createPlayer() {
    return new Player(); // ==> this.new Player();  // 바깥 클래스의 객체 주소 생략!
  }

  class Player {
    public void play() {
      for (final String song : Musics3.this.songs) {
        System.out.println(song);
      }
      System.out.println("-----------------------------");
    }
  }

  // 규칙없이 플레이어 객체 생성 - 이터레이터 생성하는 것과 비교 
}

// 스태틱 클래스이든 // 논 스태틱 클래스이든 둘다 번거로운 일이다.
//훨씬편한 설계기법은 팩토리메서드로 만들어라 .

//코드를 볼때 사람과 대화하는 것처럼 개발해라. - 그 코드가 사람과 자바버츄얼머신 ,컴파일과 대화하는 것처럼 짜라 -객체지향프로그램은 
//말하고 설명할때 마치 도구를 사용하듯이 - 이러케해야 프로그램 코드가 객체지향다움

//말로 설명하기 어렵다면 - 물흐르듯이 안된다면 - 객체지향프로그램을 잘짜면 코드가 잘읽힌다. 매끄럽게
//마치 클쓰는 것처럼 

//글쓸때 말로 내뱉여 보는거랑 똑같음 

//그동안 플레이어를 쓰려는 쪽에서 만드는게 아니라(예제720)이 만든 것 

//이제는 뮤직이 만든다. - 플레이어를 음악믕ㄹ 만드는 쪽에서 공급을 한다. 


