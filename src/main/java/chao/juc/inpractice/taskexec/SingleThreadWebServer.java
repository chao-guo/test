package chao.juc.inpractice.taskexec;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadWebServer extends HandleRequest {
    public static void main(String[] args) throws IOException {
        try (ServerSocket socket = new ServerSocket(8099);) {
            while (true) {
                Socket connection = socket.accept();
                handleRequest(connection);
            }
        }
    }
}