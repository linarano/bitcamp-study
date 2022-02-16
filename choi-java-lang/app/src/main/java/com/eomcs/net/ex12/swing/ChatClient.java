package com.eomcs.net.ex12.swing;//더 풍부판 UI -  그래서 설정이 좀더 복잡

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ChatClient extends JFrame {


  private static final long serialVersionUID = 1L;
  //다른 메서드가 접근하도록 인스턴스 변수에 답자(원래는 생성자 블럭범위 안에 있었음 )
  Socket socket;
  DataInputStream in;
  DataOutputStream out;
  String nickname; // 계속 사용해야하니까. - 기본으로   null값으로 셋팅된다(인스턴스필드)

  JTextField addressTf = new JTextField(35);
  JTextField portTf =new JTextField(4);
  JButton connectBtn = new JButton("연결!");
  JTextArea messageListTa = new JTextArea();
  JTextField messageTf = new JTextField(40); //     어차피 컴파일하면 생성자에 첫부분으로 선언하는 걸로 바뀌니까 상관

  public ChatClient() {
    //기본생성자 자동생성    default
    // 대화명을 먼저 입력하도록 
    String title = " 대화명을 입력하세요.\n(2자 이상) ";
    while(true) {
      nickname = JOptionPane.showInputDialog(title);
      System.out.println(nickname);

      if (nickname == null) { // 기
        System.exit(0);
      } else if (nickname.length() >= 2) { //  가독성측면에서 이게 더 낫다.
        break;
      } 
      title = "대화명을 다시입력하세요 \n(2자이상)";
    }
    setTitle("채팅!! - " + nickname);

    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        if (connectBtn.getText().equals("종료")) { // 
          try {
            out.writeUTF("\\quit");
            out.flush();
          } catch (Exception ex) { 
          }
        }
        try {in.close();} catch (Exception ex) {}
        try {out.close();} catch (Exception ex) {}
        try {socket.close();} catch (Exception ex) {}
        System.exit(0);
      }
    });
    setSize(500,400); 

    Container contentPanel = this.getContentPane();
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    //3.35.214.230

    topPanel.add(addressTf); 

    topPanel.add(portTf); // 


    // 액션리스터 인처페이스를 구현한 어떤 클래스의 객체주소를 주고 싶다(공통)
    // 1) 로컬 클래스(가장정석- 기초) - 굳이 객체1번 만드는데 굳이 클래스를 만드냐 ->2) : 자바는 매번 클래스에 담아서 함수를 사용했다. 자바스크립트와 같은 스크립트 언어와 달리 함수주소만 줄 수 없었따. 좀더 비슷하게
    //    class MyActionListener implements ActionListener {
    //      @Override
    //      public void actionPerformed(ActionEvent e) {
    //      }
    //    }
    //    connectBtn.addActionListener(new MyActionListener());

    // 2) 익명 클래스
    //    connectBtn.addActionListener(new ActionListener() {
    //      @Override
    //      public void actionPerformed(ActionEvent e) {
    //      }
    //    });

    // 3) 람다(lambda) 문법 (극단적 단축)
    //    connectBtn.addActionListener(e -> System.out.println("연결 버튼 눌렀음!"));

    // 4) 메서드 레퍼런스- 액션리스너 구현하지않았다하더라도 기존기능과 비슷하다면 가져다 써라  - 인터페이스는 없지만, 원하는 인터페이스와 같은 형식이면 과감하게 가져다쓰자라는 의미
    connectBtn.addActionListener(this::connectChatServer); // 메서드 주소넘기니까 얘를 호출해라. 챗클라이언트 클래스의 - 기존의 똑같은 기능과 형식의 메서드가 있다면, 인터페이스 구현하지말고 - 기존코드 재사용 
    //인스턴스 주소와함께 -인스턴스메서드이므로  이자리에 원래 인터페이스 객체를 줘야하는데, 동일한 형식의 반드시 인터페이스객체, 추상메서드가 반드시 1개, 이름일 달라도 시그니처가 같다면, 파라미터타입과 갯수, 대신 호출

    //객체주소를 줘야되
    //단 메서드의 파라미터 타입이 인터페이스, 추상메서드가 1개 있어야 쓸수 있다. -람다니 메서드레퍼런스 모두 (확인해야함. 인터페이스고 메서드가 1개인지 꼭 확인 - 위의 Window와 비교)

    topPanel.add(connectBtn);

    contentPanel.add(topPanel, BorderLayout.NORTH);

    // 메시지 어리어를 스크롤 팬에 붙여서 // 다시 컨테이너에 붙인다.  // 스크롤전담하는 객체가 있다 //aWt = 자체에 갖고있음 필요할 것 같으니까 객체로 떼어 버린거 (역할을 분리)
    JScrollPane scrollPanel = new JScrollPane(messageListTa);
    contentPanel.add( scrollPanel, BorderLayout.CENTER);

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));


    bottomPanel.add(messageTf);

    JButton sendBtn = new JButton("보내기!");
    sendBtn.addActionListener(this::sendMessage);
    bottomPanel.add(sendBtn);

    contentPanel.add(bottomPanel, BorderLayout.SOUTH);

    messageTf.addActionListener(this::sendMessage);

    this.setVisible(true);


  }
  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); //metal과 동일  -> 운영체제와 상관없이 동일한 모양
    //javax.swing.plaf.nimbus.NimbusLookAndFeel
    //com.sun.java.swing.plaf.motif.
    //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");\
    //com.sun.java.swing.plaf.windows.WindowsLookAndFeel
    //
    //모르면 출력해봐//  System.out.println(UIManager.getCrossPlatformLookAndFeelClassName());
    // UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

    new ChatClient();

  }

  public void connectChatServer(ActionEvent e) { //인스턴스 메서드 쓰려면 인스턴스 주소를 줘야함  
    System.out.println("서버에 연결하기!");
    //System.out.println(addressTf.getText());
    //System.out.println(portTf.getText());

    if(connectBtn.getText().equals("연결")) {
      try {
        socket = new Socket(
            addressTf.getText(),
            Integer.parseInt(portTf.getText()));

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        out.writeUTF(nickname);
        out.flush();

        new MessageReceiver(in).start();// 특정일만 함. 서버에서 데이터를 보내면 읽고 뿌리는 역할 - 서버와 연결하면 바로 일 시작 

      }catch(Exception ex){
        //창을 클로즈할 떄닫아야함
        JOptionPane.showMessageDialog(this,"서버 연결오류","실행오류!",JOptionPane.ERROR_MESSAGE);

      }

      connectBtn.setText("종료");
    } else {
      try {
        out.writeUTF("\\quit");
        out.flush();
      } catch (Exception ex) { 
      }
      connectBtn.setText("연결");
      messageListTa.setText("");
    }
  }
  public void sendMessage(ActionEvent e) { //인스턴스 메서드 쓰려면 인스턴스 주소를 줘야함  // JVM Stack에 로컬변수로 준다. 
    System.out.println("메시지보내기");
    //int[] arr =int [4];
    //String 클래스의 변수/메서드? length
    //int 클래스의 변수/메서드? length

    if(messageTf.getText().length() ==0){ //메서드
      return;
    }

    try{

      out.writeUTF(messageTf.getText());
      out.flush();
      messageTf.setText("");// 메세지 보낸후, 사용자 입력 부분 클리어


      //이 기능에 특화된 쓰레드를 만들었으므로 해당 기능 제거 
      //      String respense = in.readUTF();
      //      messageListTa.append(respense+"\n");

    }catch (Exception ex){
      JOptionPane.showMessageDialog(this,"메시지 전송 오류!","실행오류!",JOptionPane.ERROR_MESSAGE);
    }
  }

  // 서버에서 메세지를 보내면  그 일만 뿌려 - 서버와 연결되는 순간 가동 (서버메세지 리스너) - 메세지를 받는 역할만 하는 애를 만들었으니, 
  class MessageReceiver extends Thread {
    DataInputStream in;

    public MessageReceiver(DataInputStream in) {
      this.in = in;
    }
    @Override
    public void run() {
      while (true) {
        try{
          String message = in.readUTF();
          if (message.equals("<![QUIT[]]>")) { // 일반적으로 잘 쓰지않는 텍스트를 사용하여 일종의 명령어로 사용
            break; // 런메서드 실행을 마치면 스레드는 종료한다.   - 쓰레드의 객체정보를 보관해놨다가 살았는지 죽었는지 확인 가능 
          }
          messageListTa.append(message+"\n");

        }catch (Exception e){
        }
      }
    }
  }
} // 여기다 두면 그대로 접근가능 
//ChatClient 객체들 그대로 쓸 수 있음 


//스윙의 다른점 - 컨테이너 (여러계층) 를 꺼내씀. , add 안하는 영역은 사라지면서 영역이 넓어짐 - J프레임에 바로 붙이면 안됨
//aWT - 프로엠위에다가 에드 컴퍼넌트배치 
//OS에 상관없이 동일하게 버튼을 그릴 수 있음 

// 자바는 운영체제없이 바꿀수 있다. 
//기존에 AWT 진짜 버튼을 운영체제가 만들었다면 스윙은 윈도우가 그냥 Plain을 만들어주고, 자바에서 직접 구체화 그림 => 운영체제 상관없이 UI를 그릴 수 있다.

//투박하고 종속적이지만 속도는 훨씬 빠름
//그러나 스윙은 속도가 느림 빈상자를 받아서 

//윈도우매니저(데스크탑매니저)

//set- 1개등록
//add 여러개 등록

//메서드레퍼런스 - 기존의 만들어놓은걸 재사용하자라는 의미
//..기존것 구현 의미없음

//형식만 같다면 메서드를 갖다 붙이자
//connectChatServe(ActionEvent e)  - 


//자바스크립트-키이벤트- 검사해야함
//자바의 액션이벤트- 엔터치는 키이벤트 - 액션이벤트 다시 발생시켜 - 검사과정 생략 - 입력박스입력후 액션이벤트가 발생하도록 기능있고, 액션이벤트가 발생했을때 호출메서드
//애드액션리스너와 있다.

//자바버츄얼 머신은 매니저 //메인을 호출하는건 메인 쓰레드 -----**** JVM이 직접호출하는 것이 아님 