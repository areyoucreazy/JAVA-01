package org.geek.test.rpc.future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hfzhang
 * @date 2021/3/21
 */
public class SyncWriteMap {
    public static Map<String, WriteFuture> syncKey = new ConcurrentHashMap<String, WriteFuture>();
}
