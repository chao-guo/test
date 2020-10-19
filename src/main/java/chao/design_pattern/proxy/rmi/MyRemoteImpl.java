package chao.design_pattern.proxy.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName MyRemoteImpl.java
 * @Description TODO
 * @createTime 2020年06月26日 23:51:00
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    
    public MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says,'Hey'";
    }
}
