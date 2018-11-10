package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.*;
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
        IFIec104Service service = (IFIec104Service) applicationContext.getBean("FIec104ServiceImpl");
        FIec104Example example = new FIec104Example();
//        example.setOrderByClause("'name'");
        Result result = service.query(example);
        System.out.println(result);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        ICModbusTcpService service = (ICModbusTcpService) applicationContext.getBean("CModbusTcpSericeImpl");

        CModbusTcp cModbusTcp = new CModbusTcp();
        cModbusTcp.setName("cmbs");
        cModbusTcp.setWeight(101);
        cModbusTcp.setMainIp("10.1.0.1");
        cModbusTcp.setPort(8080);

        Result result = service.saveICModbusTcp(cModbusTcp);
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
