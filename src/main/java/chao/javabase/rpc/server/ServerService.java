package chao.javabase.rpc.server;

import chao.javabase.rpc.Entity.Request;
import chao.javabase.rpc.Entity.Response;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 接收客户端发过来的请求
 *
 * @author chao.guo
 * @Date 2022/5/5 14:44
 */
public class ServerService implements Runnable {

    private Socket sockClient;

    private Map<String, Class> serviceRegistry = new HashMap<>();

    private Response response = new Response();

    public ServerService(Socket sockClient) {
        super();
        this.sockClient = sockClient;
    }

    @Override
    public void run() {
        try {
            OutputStream out = sockClient.getOutputStream();
            //建好连接后，从socket中获取输入流，并建立缓存区进行读取
            InputStream in = sockClient.getInputStream();

            ObjectInputStream objIn = new ObjectInputStream(in);
            ObjectOutputStream objOut = new ObjectOutputStream(out);

            //获取请求数据，强转参数类型
            Object param = objIn.readObject();
            Request request = null;
            if (!(param instanceof Request)) {
                response.setMessage("参数错误");
                objOut.writeObject(response);
                objOut.flush();
                return;
            } else {
                request = (Request) param;
            }

            //查找并执行服务方法
            System.out.println("要执行的类型为：" + request.getClassName());
            Class<?> service = serviceRegistry.get(request.getClassName());
            if (service != null) {
                Method method = service.getMethod(request.getMethodName(), request.getParamTypes());
                Object result = method.invoke(service.newInstance(), request.getParams());
                //得到结果并返回
                response.setObj(result);
            }
            objOut.writeObject(response);
            objOut.flush();
            out.close();
            in.close();
            sockClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerService(Class iface, Class imp) {
        this.serviceRegistry.put(iface.getName(), imp);
    }
}
