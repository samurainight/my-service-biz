package com.my.web.dao.mapper;

import com.my.web.common.mapper.IMapper;
import com.my.web.entity.Role;
import com.my.web.entity.RoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RoleMapper extends IMapper<Role,RoleExample> {

}