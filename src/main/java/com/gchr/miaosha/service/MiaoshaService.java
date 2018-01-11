package com.gchr.miaosha.service;

import com.gchr.miaosha.domain.MiaoshaUser;
import com.gchr.miaosha.domain.OrderInfo;
import com.gchr.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/11 16:57
 */
@Service
public class MiaoshaService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Transactional
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
        //减库存 下订单 写入秒杀订单
        goodsService.reduceStock(goods);
        //order_info maiosha_order
        return orderService.createOrder(user, goods);
    }

}
