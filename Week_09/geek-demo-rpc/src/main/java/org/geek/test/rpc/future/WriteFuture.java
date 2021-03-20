package org.geek.test.rpc.future;

import org.geek.test.rpc.msg.Response;

import java.util.concurrent.Future;

/**
 * @author hfzhang
 * @date 2021/3/21
 */
public interface WriteFuture<T> extends Future<T> {

    Throwable cause();

    void setCause(Throwable cause);

    boolean isWriteSuccess();

    void setWriteResult(boolean result);

    String requestId();

    T response();

    void setResponse(Response response);

    boolean isTimeout();


}

