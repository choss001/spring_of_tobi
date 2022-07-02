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
        System.out.println("test 이상하다 서버");
        String str = "한글 깨짐";
        System.out.println("test!!!test  : "+ str.getBytes());

        findCharSet(str.getBytes());
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

    public static String findCharSet(byte[] data) {
        StringBuffer buffer = new StringBuffer();

        Map map = Charset.availableCharsets();

        String[] values = (String[])map.keySet().toArray(new String[0]);

        for (int i = 0; i < values.length; i++) {
            buffer.append("[" + values[i] + "] = ");
            try {
                buffer.append(new String(data, values[i]));
            } catch (Exception ex) {
                buffer.append("*ERROR* (" + ex.getClass().getName() + ")");
            }
            buffer.append("\n");
        }

        return buffer.toString();
    }

}
