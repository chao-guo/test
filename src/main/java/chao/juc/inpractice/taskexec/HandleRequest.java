package chao.juc.inpractice.taskexec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName HandleRequest.java
 * @Description TODO
 * @createTime 2020年07月02日 11:06:00
 */
public class HandleRequest {
    static void handleRequest(Socket connection) {
        // request-handling logic here
        try (InputStream in = connection.getInputStream();) {

            int count = 0;
            while (count == 0) {
                count = in.available();
            }
            byte[] b = new byte[count];
            in.read(b);
            String str = new String(b);
            // 向客户端发送确认消息
            OutputStream outer = connection.getOutputStream();
            byte[] b_out = "已经收到，返回消息码200".getBytes();
            outer.write(b_out);
            outer.flush();
            System.out.println("处理消息中");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("服务端：" + str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
