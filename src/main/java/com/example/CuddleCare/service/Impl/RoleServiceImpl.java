package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.RoleDao;
import com.example.CuddleCare.entity.Role;
import com.example.CuddleCare.service.RoleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    
    @Override
    public Role createRole(String role) {
        return roleDao.save(new Role(role));
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.findByRoleName(roleName);
    }
}
