package org.geek.test.rpc.msg;

/**
 * @author hfzhang
 * @date 2021/3/20
 */
public class Response {
    private String requestId;
    private String param;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
