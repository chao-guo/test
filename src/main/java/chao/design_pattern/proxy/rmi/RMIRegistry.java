package chao.design_pattern.proxy.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * @author chao.guo
 * @version 1.0.0
 * @ClassName RMIRegistry.java
 * @Description TODO
 * @createTime 2020年06月27日 00:01:00
 */
public class RMIRegistry {
    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
