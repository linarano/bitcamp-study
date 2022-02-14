// inner class 응용 II : inner 클래스와 인터페이스  
package com.eomcs.oop.ex11.c;

import java.util.ArrayList;
import java.util.List;

public class Exam0720 {

  public static void main(String[] args) {
    Musics4 m1 = new Musics4();
    m1.add("aaa.mp3");
    m1.add("bbb.mp3");
    m1.add("ccc.mp3");

    Musics4 m2 = new Musics4();
    m2.add("xxx.mp3");
    m2.add("yyy.mp3");

    // Musics4의 플레이어 객체를 생성한다.
    // 리턴 객체는 Player 규칙에 따라 만든 객체이다.
    Player p1 = m1.createPlayer();
    Player p2 = m2.createPlayer();

    p1.play();
    p2.play();
  }
}

// 음악 플레이어의 사용법을 정의한다. // 종속된 것을 음악플레이어 사용법을 인터페이스로 따로정의 
interface Player {
  void play();
}

class Musics4 {

  List<String> songs = new ArrayList<>();

  public void add(final String song) {
    songs.add(song);
  }

  public void delete(final int index) {
    songs.remove(index);
  }

  // Player 구현 객체를 리턴한다.
  // Player 구현체는 Musics4의 inner 클래스로 되어 있다.
  public Player createPlayer() {
    return new PlayerImpl(); // ==> this.new PlayerImpl();  // 바깥 클래스의 객체 주소 생략!
  }

  // 인터페이스 구현체를 inner 클래스로 정의한다.
  class PlayerImpl implements Player {
    @Override
    public void play() {
      for (final String song : Musics4.this.songs) {
        System.out.println(song);
      }
      System.out.println("-----------------------------");
    }
  }


}
// 나중에 확장성 생성해서 아예 플레이어 사용법을
//인처페이스로 따로정의한후 
//플레이사용법에 따라서 동작하는 클래스를 만든 후에, 그 클래스를 ㅣㄹ턴한다.
//확장한다.

// 시스템을 유지보수하고 확장하기 좋다는 의미는 -> 자꾸 인처페이스나 클래스들이 늘어나게되는게 단점 (자꾸만 뭐가 추가되는게 단점)
// 유지보수가 좋다는 것을 역할이 잘게잘게 나눠져있다는 뜼
//처음 그 개발자를 쓰는 초보자는 어떻게 연결되어있는지 전체적 상황을 이해하련느 정신이 없다.

//능숙해지면 편하겠지만
//그 밑에는 어마무시한 구조로 되어있따. - 스프링부트

