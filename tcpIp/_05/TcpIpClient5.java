package tcpIp._05;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient5 {
  public static void main(String[] args) {
    try{
      String serverIp = "127.0.0.1";
      Socket socket = new Socket(serverIp, 7777);

      System.out.println("서버에 연결되었습니다.");
      TcpIpServer5.Sender sender = new TcpIpServer5.Sender(socket);
      TcpIpServer5.Receiver receiver = new TcpIpServer5.Receiver(socket);

      sender.start();
      receiver.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
