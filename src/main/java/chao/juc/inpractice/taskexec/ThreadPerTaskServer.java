package chao.juc.inpractice.taskexec;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName ThreadPerTaskServer.java
 * @Description TODO
 * @createTime 2020年07月02日 10:43:00
 */
public class ThreadPerTaskServer extends HandleRequest {
    public static void main(String[] args) throws IOException {
        try (ServerSocket socket = new ServerSocket(8099);) {
            while (true) {
                final Socket connection = socket.accept();
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        handleRequest(connection);
                    }
                };
                new Thread(task).start();
            }
        }
    }
}
