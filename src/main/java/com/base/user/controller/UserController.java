package com.base.user.controller;

import com.alibaba.fastjson.JSON;
import com.base.user.module.User;
import com.base.user.service.IUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userServiceImpl;


    @RequestMapping("/crud")
    public String crud(){
        return "page/user_crud";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, User user){
        this.userServiceImpl.add(user);
        request.setAttribute("result", "添加用户成功!");
        return "page/success";
    }

    @RequestMapping("/deleteById")
    public String deleteById(HttpServletRequest request, String id){
        this.userServiceImpl.deleteById(id);
        request.setAttribute("result", "删除用户成功");
        return "page/success";
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request,User user){
        this.userServiceImpl.update(user);
        request.setAttribute("result", "修改用户成功");
        return "page/success";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public String findById(HttpServletRequest request, HttpServletResponse response, String id) throws IOException {
        User user = this.userServiceImpl.findById(id);
        /*request.setAttribute("result", "查询用户成功");
        return "page/success";*/
        return JSONObject.fromObject(user).toString();
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(HttpServletRequest request){
        List<User> userList = this.userServiceImpl.findAll();
        /*request.setAttribute("result", "查询用户列表成功");
        return "page/success";*/
        /*JsonConfig config = new JsonConfig();       //自定义JsonConfig用于过滤Hibernate配置文件所产生的递归数据
        config.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            private String format = "yyyy-MM-dd HH:mm:ss";

            @Override
            public Object processArrayValue(Object o, JsonConfig jsonConfig) {
                return this.process(o);
            }

            @Override
            public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
                return this.process(o);
            }

            private Object process(Object value) {
                if (value instanceof Date) {
                    SimpleDateFormat sdf = new SimpleDateFormat(this.format, Locale.UK);
                    return sdf.format(value);
                } else {
                    return value == null ? "" : value.toString();
                }
            }
        });     //格式化日期*/
        return JSONArray.fromObject(userList).toString();
    }
}
