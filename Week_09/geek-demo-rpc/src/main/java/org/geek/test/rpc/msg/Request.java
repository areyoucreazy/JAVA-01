package org.geek.test.rpc.msg;

/**
 * @author hfzhang
 * @date 2021/3/20
 */
public class Request {

    private String requestId;
    private Object result;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
