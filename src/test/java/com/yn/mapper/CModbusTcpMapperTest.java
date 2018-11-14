package com.yn.mapper;

import com.yn.entity.*;
import com.yn.smo.IUsermgrService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : CModbusTcpMapperTest
 * @Description：CModbusTcpMapper测试类
 * @Date ：Created in 14:45 2018/10/31
 */
public class CModbusTcpMapperTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-sqlite.xml");
    }

    @Test
    public void selectByExample() throws Exception {
        UsermgrMapper mapper = (UsermgrMapper) applicationContext.getBean("usermgrMapper");
        Usermgr example = new Usermgr();
        example.setPassword("ceshi");
        example.setPassword("1");
        Usermgr usermgr = mapper.selectByPrimaryKey("ceshi");
        System.out.println(usermgr.toString());
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        CAbcipMapper mapper = (CAbcipMapper) applicationContext.getBean("CAbcipMapper");
        CAbcip recod = new CAbcip();
        recod.setName("ccip");
        recod.setWeight(101);
        recod.setMainIp("10.1.0.1");
        recod.setPort(8080);
        int i = mapper.updateByPrimaryKey(recod);
        System.out.println(i);
    }

    @Test
    public void delByPrimaryKey() throws Exception {
        CModbusTcpMapper mapper = (CModbusTcpMapper) applicationContext.getBean("CAbcipMapper");
        CModbusTcp cModbusTcp = new CModbusTcp();
        cModbusTcp.setName("cmbs");
        int i = mapper.deleteByPrimaryKey(cModbusTcp.getName());
        System.out.println(i);
    }
}
