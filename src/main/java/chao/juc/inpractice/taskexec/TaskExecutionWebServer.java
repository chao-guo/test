package chao.juc.inpractice.taskexec;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName TaskExecutionWebServer.java
 * @Description TODO
 * @createTime 2020年07月02日 13:56:00
 */
public class TaskExecutionWebServer extends HandleRequest {
    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8099);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };
            exec.execute(task);
        }
    }
}
