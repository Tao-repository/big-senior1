package io.hbt.commerce.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.hbt.commerce.dao.AdministratorMapper;
import io.hbt.commerce.po.Administrator;
import io.hbt.commerce.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator getByUsername(String username) {
        return administratorMapper.getByUsername(username);
    }

    @Override
    public Administrator getById(Integer administratorId) {
        return administratorMapper.selectByPrimaryKey(administratorId);
    }

    @Override
    public void update(Administrator administrator) {
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

    @Override
    public Page<Administrator> getList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Administrator> page = administratorMapper.getList();
        return page;
    }

    @Override
    public Integer create(Administrator administrator) {
        return administratorMapper.insertSelective(administrator);
    }

    @Override
    public void delete(Integer adminstratorId) {
        administratorMapper.deleteByPrimaryKey(adminstratorId);
    }

    @Override
    public void batchDelete(List<Integer> administratorIds) {
        administratorMapper.batchDelete(administratorIds);
    }

    @Override
    public Administrator getByEmail(String email) {
        Administrator administrator = administratorMapper.selectByEmail(email);
        return administrator;
    }
}
