package chao.javabase.rpc;

import chao.javabase.rpc.server.Server;

import java.io.IOException;

/**
 * @author chao.guo
 * @Date 2022/5/6 15:34
 */
public class Test {
    public static void main(String [] arg){
        new Thread( () ->  {
            try {
                Server server = new Server(12000);
                server.start();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        } ).start();
    }
}
