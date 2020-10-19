package chao.juc.inpractice.taskexec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName SocketSender.java
 * @Description TODO
 * @createTime 2020年07月02日 10:19:00
 */
public class SocketSender {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8099);) {
                sendMessage(socket);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        //向服务端发送信息
        byte[] b = "客户端：向服务端发送文字，\"这是一行测试....\"".getBytes();
        outputStream.write(b);
        outputStream.flush();
        System.out.println("发送完毕！");
        //接受服务端的返回值
        InputStream inputStream = socket.getInputStream();
        int count = 0;
        while (count == 0) {
            count = inputStream.available();
        }
        byte[] recv = new byte[count];
        inputStream.read(recv);
        String strRecv = new String(recv);
        System.out.println("客户端：接受到服务端的文字：" + strRecv);
    }
}