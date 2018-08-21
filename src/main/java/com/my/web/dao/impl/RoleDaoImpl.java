package com.my.web.dao.impl;

import com.my.web.common.dao.AbsDaoImpl;
import com.my.web.dao.RoleDao;
import com.my.web.entity.Role;
import com.my.web.entity.RoleExample;
import org.springframework.stereotype.Service;

@Service
public class RoleDaoImpl extends AbsDaoImpl<Role,RoleExample> implements RoleDao {
}
