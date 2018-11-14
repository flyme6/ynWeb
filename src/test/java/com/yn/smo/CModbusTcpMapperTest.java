package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.*;
import com.yn.mapper.ComMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-sqlite.xml","spring/applicationContext-service.xml");
    }

    @Test
    public void selectByExample() throws Exception {
        IUsermgrService service = (IUsermgrService) applicationContext.getBean("usermgrServiceImpl");
        Usermgr example = new Usermgr();
        example.setUsername("ceshi");
        example.setPassword("1");
//        TcpExample example = new TcpExample();
//        example.setOrderByClause("'name'");
        Result result = service.query(example);

        System.out.println(result);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        IGeneralService service = (IGeneralService) applicationContext.getBean("generalServiceImpl");
        General recod = new General();
        recod.setProjectName("new");
        recod.setEnableRedun(1);
        recod.setIp1("192.168.5.10");
        recod.setIp2("192.168.5.11");
        recod.setIp3("1");
        GeneralExample example = new GeneralExample();
        Result result = service.add(recod, example);
        System.out.println(result);
    }

    @Test
    public void delByPrimaryKey() throws Exception {
        ICModbusTcpService service = (ICModbusTcpService) applicationContext.getBean("CModbusTcpSericeImpl");

        CModbusTcp cModbusTcp = new CModbusTcp();
        cModbusTcp.setName("cmbs5");

        Result result = service.delICModbusTcp(cModbusTcp);
        System.out.println(result);
    }
}
