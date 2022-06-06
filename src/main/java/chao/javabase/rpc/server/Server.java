package chao.javabase.rpc.server;

import chao.javabase.rpc.service.StudentService;
import chao.javabase.rpc.service.impl.StudentServiceImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chao.guo
 * @Date 2022/5/5 14:35
 */
public class Server {

    private ServerSocket serverSocket;

    private int svrPort;

    public Server(int port) throws IOException {
        this.svrPort = port;
        serverSocket = new ServerSocket(this.svrPort);
    }

    public void start() {
        ThreadPoolExecutor theadPool = new ThreadPoolExecutor(5, 10, 200, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        while (true) {
            try {
                Socket sock = serverSocket.accept();
                ServerService service = new ServerService(sock);
                service.registerService(StudentService.class, StudentServiceImpl.class);
                theadPool.execute(service);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
