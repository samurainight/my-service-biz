package com.my.web.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.my.web.common.IRedisService;
import com.my.web.dao.RoleDao;
import com.my.web.entity.Role;
import com.my.web.entity.RoleExample;
import com.my.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private IRedisService redisService;
    @Override
    public List<Role> getName(String name) {
        List<Role> list=redisService.getList(name,Role.class);
        return list;
    }

    @Override
    public List<Role> fetchRoleList() {
        RoleExample roleExample=new RoleExample();
        roleExample.createCriteria().andStatusEqualTo(0).andSubsystemIdEqualTo(3L);
        roleExample.setOrderByClause("id desc");
        List<Role> list=roleDao.selectByExample(roleExample);
        redisService.setList("role",list);
        return list;
    }
}
