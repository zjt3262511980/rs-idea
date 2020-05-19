package com.service.impl;

import com.dao.VxDao;
import com.domain.Vx;
import com.service.VxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class VxServiceimpl implements VxService {
    @Autowired
    private VxDao vxDao;
    @Override
    public int insertvs(int userrsid, String vxid) {
        Example example=new Example(Vx.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("userrsid",userrsid);
       List<Vx> listvx =vxDao.selectByExample(example);
       if(listvx.size()==0){
           Vx vx=new Vx();
           vx.setUserrsid(userrsid);
           vx.setVxid(vxid);
           return vxDao.insertSelective(vx);
       }else {
           return 0;
       }

    }

    @Override
    public Vx selectvx(String vxsid) {
        Example example=new Example(Vx.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("vxid",vxsid);
        return vxDao.selectOneByExample(example);
    }
}
