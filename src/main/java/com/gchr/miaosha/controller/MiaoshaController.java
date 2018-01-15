package com.gchr.miaosha.controller;

import com.gchr.miaosha.domain.MiaoshaOrder;
import com.gchr.miaosha.domain.MiaoshaUser;
import com.gchr.miaosha.domain.OrderInfo;
import com.gchr.miaosha.redis.RedisService;
import com.gchr.miaosha.result.CodeMsg;
import com.gchr.miaosha.result.Result;
import com.gchr.miaosha.service.GoodsService;
import com.gchr.miaosha.service.MiaoshaService;
import com.gchr.miaosha.service.MiaoshaUserService;
import com.gchr.miaosha.service.OrderService;
import com.gchr.miaosha.vo.GoodsVo;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/11 16:55
 */
@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;

    @RequestMapping("/do_miaosha")
    public Result<OrderInfo> list(Model model, MiaoshaUser user,
                       @RequestParam("goodsId")long goodsId) {
        model.addAttribute("user", user);
        if(user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        //判断库存
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if(stock <= 0) {
            return Result.error(CodeMsg.MIAO_SHA_OVER);
        }
        //判断是否已经秒杀到了
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
        if(order != null) {
            return Result.error(CodeMsg.REPEATE_MIAOSHA);
        }
        //减库存 下订单 写入秒杀订单
        OrderInfo orderInfo = miaoshaService.miaosha(user, goods);

        return Result.success(orderInfo);
    }
}
