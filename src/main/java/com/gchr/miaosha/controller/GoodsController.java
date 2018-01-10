package com.gchr.miaosha.controller;

import com.gchr.miaosha.domain.MiaoshaUser;
import com.gchr.miaosha.redis.RedisService;
import com.gchr.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/10 20:59
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_list")
    public String list(Model model, MiaoshaUser user) {
        model.addAttribute("user", user);
        return "goods_list";
    }
}
