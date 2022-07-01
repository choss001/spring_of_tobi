import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        while (true) {
            try{
                serverSocket = new ServerSocket(7777);
                Socket socket = serverSocket.accept();
                System.out.println(getTime()+ socket.getInetAddress()+
                        "로부터 연결요청이 들어왔습니다.");

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

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
