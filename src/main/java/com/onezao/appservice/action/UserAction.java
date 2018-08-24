package com.onezao.appservice.action;

import com.onezao.appservice.bean.RestFulBean;
import com.onezao.appservice.bean.UserBean;
import com.onezao.appservice.service.UserService;
import com.onezao.appservice.util.ZaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ywl5320 on 2017-10-2.
 *
 *  注册接口：/user/register.do
 *
 * 登录接口：/user/loginbypwd.do
 */
@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;


    /**
     * 注册
     * @param userBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/register.do", method= RequestMethod.PUT)
    public RestFulBean<UserBean> register(@RequestBody UserBean userBean)
    {
        return userService.registorServer(userBean);
    }

    /**
     * 登录
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/loginbypwd.do", method= RequestMethod.POST)
    public RestFulBean<UserBean> loginByPwd(String phone, String password)
    {
        System.out.println("phone:" + phone);
        return userService.login(phone, password);
    }

    /**
     * 详情
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/userinfo.do", method= RequestMethod.GET)
    public RestFulBean<UserBean> userInfo(String phone)
    {
        System.out.println("phone : " + phone + "  Time ： " + ZaoUtils.getSystemTimeHello());
        return userService.userinfo(phone);
    }
}