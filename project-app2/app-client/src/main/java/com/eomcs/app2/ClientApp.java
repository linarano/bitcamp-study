package com.eomcs.app2;

import com.eomcs.app2.handler.ScoreHandler;
import com.eomcs.app2.net.ScoreTableProxy;
import com.eomcs.util.Prompt;

public class ClientApp {

  public static void main(String[] args) {
    new ClientApp().service();
  }

  public void service() { // 이젠 네트워크통신 - 클라이언트에서 안함 
    try {
      ScoreTableProxy scoreTableProxy = new ScoreTableProxy("localhost",3336);
      ScoreHandler scoreHandler = new ScoreHandler(scoreTableProxy); // 서버연결 

      while (true) {
        printMenu();
        String input = Prompt.promptString("명령> ");

        if (checkQuit(input)) {
          scoreTableProxy.close(); // 서버개발자가 만들어준걸 우리는 이용할뿐. 
          break;
        }

        try {
          switch (input) {
            case "1": scoreHandler.create(); break;
            case "2": scoreHandler.list(); break;
            case "3": scoreHandler.detail(); break;
            case "4": scoreHandler.update(); break;
            case "5": scoreHandler.delete(); break;
            default:
              System.out.println("올바른 메뉴 번호를 입력하세요!");
          }
        } catch (Exception e) {
          System.out.println("실행 중 오류 발생: " + e.getMessage());
        }

        System.out.println();
      }
    } catch (Exception e) {
      System.out.println("서버와 통신하는 중 오류 발생: " + e.getMessage());
    }

    System.out.println("종료!");
  }

  private void printMenu() {
    System.out.println("메뉴:");
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 상세");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
  }

  private boolean checkQuit(String input) {
    return input.equals("quit") || input.equals("exit");
  }
}

/*
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.app2.handler.ScoreHandler;
import com.eomcs.util.Prompt;

public class ClientApp {



  public static void main(String[] args) {
    new ClientApp().service(); // 임시변수 만들지 말고 바로 집어넣어서 호출 - 인스턴스 메서드
  }

  public void service() { // 인스턴스메서드
    try(Socket socket = new Socket("localhost",3336); // in-in// 서로 입력대기상태 통신 안될 수도있음 , // 서버와 클라이언트간 맞대응을 해야하는데 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); // 먼저 데이터를 보내는 쭉이면 출력스트림 - 그 반대 읽는 쪽이면 입력스트림
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());){
      // 파일입출력과 소켓통신과 다르다. - 가능하면 순서를 지켜라 안된이유 - 클라이언과 서버 모두 상대방이 출력준비가 끝나기를 기다림
      // 아무런 에러도 없이 일종의 블록킹상태로 있는게 미치게 만든다.
      // 네트워크 통신에서는 서로 아귀가 딱 맞는게 중요해 // 섬세한게 맞으면 그때부터는 일사처리 
      System.out.println("서버와 연결되었음!");

      ScoreHandler scoreHandler = new ScoreHandler(in, out); // 서버와 통신할 수 있도록 보내자 -> 단순히 어레이리스트 저장이 아님

      while (true) {

        printMenu();      
        String input = Prompt.promptString("명령 > "); // 할당연산자는 오른쪽이 먼저 실행된다. 

        if(checkQuit(input)) {
          out.writeUTF("quit"); // 서버랑 클라이언트끼리 약속
          break;
        } 

        try { // 절대 시스템을 종료하지않으므로 예외처리는 중요하다 
          switch (input) {
            case "1": scoreHandler.create(); break; // 각반별로 스코어핸들러를 만들 수 있기 때문에 인스턴스메서드로 
            case "2": scoreHandler.list();   break;
            case "3": scoreHandler.detail(); break;
            case "4": scoreHandler.update(); break;
            case "5": scoreHandler.delete(); break;
            default:
              System.out.println("올바른 메뉴 번호를 입력하세요!");
          }
        } catch(Exception e) {
          System.out.println("실행 중 오류 발생: " + e.getMessage());
        }

        System.out.println();
      }
    }catch(Exception e) {
      System.out.println("서버와 통신하는 중 오류 발생 :" + e.getMessage());
    }
    System.out.println("종료!");
  }

  private void printMenu() {
    System.out.println("메뉴:");
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 상세");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
  }


  private boolean checkQuit(String input) {
    return input.equals("quit") || input.equals("exit"); // 둘중의 하나라도 참이면 참  - 리턴값 블린
  } 
}

 */

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