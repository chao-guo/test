package chao.javabase.rpc.Entity;

import java.io.Serializable;

/**
 * @author chao.guo
 * @Date 2022/5/5 14:51
 */
public class Response implements Serializable {


    private String message;

    private Object obj;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
