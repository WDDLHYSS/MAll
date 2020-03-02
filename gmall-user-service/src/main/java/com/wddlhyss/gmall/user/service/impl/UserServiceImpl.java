package com.wddlhyss.gmall.user.service.impl;

import com.wddlhyss.gmall.beans.UmsMember;
import com.wddlhyss.gmall.beans.UmsMemberReceiveAddress;
import com.wddlhyss.gmall.service.UserService;
import com.wddlhyss.gmall.user.mapper.UmsMemberReceiveAddressesMapper;
import com.wddlhyss.gmall.user.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsMemberReceiveAddressesMapper umsMemberReceiveAddressesMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers = userMapper.selectAll();
        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressById(String memberId) {

        /*Example e = new Example(UmsMemberReceiveAddress.class);
        e.createCriteria().andEqualTo("memberId",memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressesMapper.selectByExample(e);*/

        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressesMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddresses;
    }
}
