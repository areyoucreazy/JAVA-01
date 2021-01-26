package com.hf.job04.router;

import java.util.List;

/**
 * Create by hfzhang
 *
 * @date 2021/1/26
 */
public interface HttpEndpointRouter {

    String route(List<String> urls);
}
