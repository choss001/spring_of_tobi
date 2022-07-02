package tcpIp._04;

import java.io.IOException;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer4 implements Runnable{

    ServerSocket serverSocket;
    Thread[] threadArr;

    public static void main(String[] args) {
        TcpIpServer4 server = new TcpIpServer4(5);
    }

    public TcpIpServer4(int num) {
        try{
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void run() {

    }

    static String getTime(){
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
