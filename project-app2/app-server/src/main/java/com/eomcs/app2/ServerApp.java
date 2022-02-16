package com.eomcs.app2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.app2.table.ScoreTable;
import com.eomcs.app2.vo.Score;

public class ServerApp {

  ScoreTable scoreHandler = new ScoreTable();

  public static void main(String[] args) {
    new ServerApp().service();
  }

  public void service() {
    try (ServerSocket serverSocket = new ServerSocket(3306);) {
      System.out.println("서버 실행 중...");

      while (true) {
        try (
            Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());) {


          System.out.println("클라이언트가 접속했습니다.");

          while (true) {
            String command = in.readUTF();
            if (command.equals("quit")) {
              break;
            }
            try {
              switch (command) {
                case "insert":
                  Score score = (Score) in.readObject();
                  int count = ScoreTable.insert(score);
                  out.writeUTF("success");
                  out.writeInt(count);
                  break;
                case "selectList":
                  Score[] scores = ScoreTable.selectList();
                  out.writeUTF("success");
                  out.writeObject(scores);
                  break;
                case "selectOne":
                  int no = in.readInt();
                  score = ScoreTable.selectOne(no);
                  out.writeUTF("success");
                  out.writeObject(score);
                  break;
                case "update":
                  no = in.readInt();
                  score = (Score) in.readObject();
                  count = ScoreTable.update(no, score);
                  out.writeUTF("success");
                  out.writeInt(count);
                  break;
                case "delete":
                  no = in.readInt();
                  count = ScoreTable.delete(no);
                  out.writeUTF("success");
                  out.writeInt(count);
                  break;
                default:
                  out.writeUTF("fail");
                  out.writeUTF("해당 명령을 지원하지 않습니다.");
              }
              out.flush();
            } catch (Exception e) {
              out.writeUTF("fail");
              out.writeUTF("실행 오류: " + e.getMessage());
              out.flush();
            }
          } // while (true)
          System.out.println("클라이언트와의 연결을 끊었습니다.");

        } catch (Exception e) {
          System.out.println("클라이언트와 통신 중 오류 발생!");
        }

      } // while (true)
    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
    }

    System.out.println("종료!");
  }
}




// 명령어가 없거나 실패했을 수도 -> 항상 작업의 실행결과 리턴 
// switch 덩어리가 하나의 변수, 재사용 // if문과 다름

// 실무에서는 인스턴스메서드를 많이씀- 객체 생성때문에 
// 따로 설명을 붙일 필요 없다. -> 간결하게 리팩토링하면 기능별로 메서드 분류 -> 클래스로 따로 분류
//각 기능마다 메서드를 따로 -> 각 부속품을 따로 
// 메서드 사용활용
//리팩토링
//초심자는 잘하는 것 상관없어
//익숙해지느냐가 문제 

//정답없다.
//강의자료 다 부질없다. -> 회사가서 코딩하지 이걸쓰지않는다.
// 오늘 짠 소스 소중히 주석막아놓을 필요있나? 오늘 짠 소스 내일 보면 챙피하다. 
// 관리직으로 갈것인가 개발자로 갈것인가 - 일신우일신 - 한달 전에 짠 소스코드가 대단히 느껴지면 기술직이 안맞음
//한달전 ,하루전 짠 소스는 쓰레기처럼 느껴져야한다.(내가 발전을 하지않았다는 뜻 
//한창 실력이 늘때 - 내가 이전에 짠 소스코드가 폭발적으로 성장
// 잘보관해야지 이런 생각하지마
//필요없으면 지우고
//필요하면 작성하고 -> 점점 간결해질것 
// 팀프로젝트를 하는데 회의를 하다보면 처음 방향과 약간 달라지는 경우가 있어 -> 자기가 애썬 짠 코드가 기능이 변경되면 버려야되니까 그게 싫은것
//어떻게 해서든 기능이 바뀌면 잘됐다고 하고 코딩경험을 더 늘릴 생각을 해야하는데 
//아까워하지마라 코드변경을 해라.
// 새코드 짜고 싶지 기존걸 변경하고 싶지않아한다. -> 리팩토링을 무시하지마라.
//기능을 바꿨으면 하고 싶었는데 
//남이 기능을 바꾼다고하면 기분이 나쁘게 생각하는 수강생이 많은데 그러지마라
// 한줄 이라도 더해야 코딩경험이 늘어나는 것
// 방향이 낫다고 생각하면 코딩을 바꾸면된다.

//지금 우리가 필요한건 코딩경험을 많이하는 것
//최소한의 노력 -> 최대한의 결과(기성개발자)
//우리는 최대한의 코드로 -> 최소한의 기능 완성  : 많이 코딩해봐라
//지금 우리에게 필요한것

// 오토언박싱 - Stirng 하고는 상관없어. 그리고 엔터치면 찌거끼가 남기때문에 그것까지 처리고민해줘야함  원시타입 -> 래퍼객체로 바꾸는 것
//Integer num = new Integer(keyScan.nextLine()); // 박싱
//int n = num.intValue();        // 언박싱

//잘만든 코드 열친구 안부럽다 ->퇴근시간을 앞당겨주는 아름다운 메서드 자


// lang.ex06.450

//직접접근 못하게 필드에 -> 적절하게 조정 . 세밀하게 조정조건을 붙일 수 잇음. 나중에 바꿀려면 다 뜯어고쳐야함 .필드에 직접 엑세스하는 것보다 각 메서드를 통해서 하는게 낫다.
//값을 맘대로 넣을 수 있느 방법을 막을 방법 이없음 
//필드에 직접 엑세스하면 유효하지않은 값 설정할 수 있으므로 -> 캡슐화 접근제어 
//=>  메서드를 ㅇ통해서 넣도록 유됴 - 유효하지않은 값이 들어가는것을 일정부분 막을 수 있음 

//하나의 클래스의 여러게 메서드 -> 분리시키자 
//프로픔트는 어차피 프로그램 종료6까지 

//domain =VO갮 객체(Value Object)의 경우 = VO