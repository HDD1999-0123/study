package com.hdd.service;

import com.hdd.bean.Express;
import com.hdd.dao.BaseExpressDao;
import com.hdd.service.ExpressService;
import org.junit.Test;

public class ExpressServiceTest {



    @Test
    public void insert() {
        Express e = new Express("12311","李伟杰","18516955565","顺丰快递","18888888888","666666");
        boolean flag = ExpressService.insert(e);
        System.out.println(flag);
    }
}
