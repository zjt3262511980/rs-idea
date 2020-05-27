package com.service.impl;

import com.dao.CompackDao;
import com.domain.Compack;
import com.service.CompackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompackServiceimpl implements CompackService {
    @Autowired
    private CompackDao compackDao;

    @Override
    public Compack selectcompack() {
        return compackDao.selectByPrimaryKey(1);
    }

    @Override
    public int updatecomp(Compack compack) {
        return compackDao.updateByPrimaryKeySelective(compack);
    }
}
