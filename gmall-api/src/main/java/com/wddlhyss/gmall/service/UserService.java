package com.wddlhyss.gmall.service;

import com.wddlhyss.gmall.beans.UmsMember;
import com.wddlhyss.gmall.beans.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressById(String memberId);

}
