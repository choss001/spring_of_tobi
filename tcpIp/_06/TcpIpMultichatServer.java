package tcpIp._06;

import org.h2.tools.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;

public class TcpIpMultichatServer {
  HashMap clients;

  TcpIpMultichatServer(){
    clients = new HashMap();
    Collections.synchronizedMap(clients);
  }
  public void start(){
    ServerSocket serverSocket = null;
    Socket socket = null;
    try{
      serverSocket = new ServerSocket(7777);
      System.out.println("서버가 시작되었습니다.");

      while (true) {
        socket = serverSocket.accept();
        System.out.println("["+socket.getPort()+"]"+"에서 접속하였습니다.");
        ServerReceiver thread= new ServerReceiver();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static class ServerReceiver extends Thread{
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    ServerReceiver(Socket socket) {
      this.socket = socket;
    }

  }
}

