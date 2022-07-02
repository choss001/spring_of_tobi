package tcpIp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class TcpIpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        while (true) {
            try{
                serverSocket = new ServerSocket(7777);
                System.out.println(" port : " +
                        serverSocket.getLocalPort());
                Socket socket = serverSocket.accept();
                System.out.println(getTime()+ socket.getInetAddress()+
                        "accept message");

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("[Notice] Test Message from Server");

                dos.close();
                socket.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static String getTime(){
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
