package com.wddlhyss.gmall.user.controller;

import com.wddlhyss.gmall.beans.UmsMember;
import com.wddlhyss.gmall.beans.UmsMemberReceiveAddress;
import com.wddlhyss.gmall.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Reference
    UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public String index() {
        return "hello user";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }

    @RequestMapping("getReceiveAddressById")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressById(String memberId) {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressById(memberId);
        return umsMemberReceiveAddresses;
    }
}
