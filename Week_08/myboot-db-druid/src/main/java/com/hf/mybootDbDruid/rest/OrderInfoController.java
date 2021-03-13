package com.hf.mybootDbDruid.rest;

import com.hf.mybootDbDruid.entity.OrderInfo;
import com.hf.mybootDbDruid.entity.TOrder;
import com.hf.mybootDbDruid.service.OrderInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author hfzhang
 * http://localhost:8080/swagger-ui.html
 * @date 2021/3/3
 */
@RestController
@RequestMapping("/order")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation(value = "批量添加订单",notes = "批量添加订单")
    @RequestMapping(value = "/addOrderInfo", method = RequestMethod.POST)
    public int[] addBatchOrderInfo(@RequestBody OrderInfo orderInfo){
        try {
            List<OrderInfo> orderInfoList = new ArrayList<>();
            for(int i=0;i<1000000;i++){
                orderInfoList.add(orderInfo);
            }
            orderInfoService.saveBatchOrderInfo(orderInfoList);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "添加订单-sharding",notes = "添加订单-sharding")
    @RequestMapping(value = "/addTOrder", method = RequestMethod.POST)
    public int addTOrder(@RequestBody TOrder tOrder){
        try {
            Random random = new Random();
            int abs = Math.abs(random.nextInt());
            tOrder.setUserId(abs);
            tOrder.setStatus("hfzhang");
            return orderInfoService.addTOrder(tOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @ApiOperation(value = "批量添加订单-sharding",notes = "批量添加订单-sharding")
    @RequestMapping(value = "/addTOrderBatch", method = RequestMethod.GET)
    public int addTOrderBatch(){
        try {
            TOrder tOrder = null;
            List<TOrder> orderInfoList = new ArrayList<>();
            for(int i=0;i<1000000;i++){
                tOrder = new TOrder();
                tOrder.setUserId((i+1));
                tOrder.setStatus("ceshi"+(i+1));
                orderInfoList.add(tOrder);
            }
            orderInfoService.addTOrderBatch(orderInfoList);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

//    public static void main(String[] args) {
//        for(int i=0;i<100;i++){
//            System.out.println(577608701352325121L%29);
//        }
//    }
}
