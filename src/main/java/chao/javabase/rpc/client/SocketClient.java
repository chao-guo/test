package chao.javabase.rpc.client;

import chao.javabase.rpc.Entity.Request;
import chao.javabase.rpc.Entity.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 建立socket连接,发送请求并将接收服务器返回信息
 *
 * @author chao.guo
 * @Date 2022/5/6 14:41
 */
public class SocketClient {

    private Socket sock;

    public SocketClient() {
    }

    public Object invoke(Request request, String ip, int port) throws IOException {
        sock = new Socket(ip, port);
        InputStream in = sock.getInputStream();
        OutputStream out = sock.getOutputStream();
        ObjectOutputStream objOut;
        ObjectInputStream objIn;
        Response response = null;
        try {
            objOut = new ObjectOutputStream(out);
            objOut.writeObject(request);
            objOut.flush();
            objIn = new ObjectInputStream(in);
            Object res = objIn.readObject();
            if (res instanceof Response) {
                response = (Response) res;
            } else {
                throw new RuntimeException("返回对象不正确！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
            in.close();
            sock.close();
            return response.getObj();
        }
    }


}
