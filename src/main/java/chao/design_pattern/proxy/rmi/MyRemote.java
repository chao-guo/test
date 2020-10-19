package chao.design_pattern.proxy.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程调用接口
 *
 * @author chao.guo
 * @Description 供客户调用的远程方法
 * @createTime 2020年06月26日 23:34:00
 */
public interface MyRemote extends Remote {
    /**
     *
     * @return 对象必须是 Serialize类型
     * @throws RemoteException
     */
    public String sayHello() throws RemoteException;
}
