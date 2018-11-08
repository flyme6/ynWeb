package com.yn.mapper;

import com.yn.entity.*;
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
        CModbusTcpRtuMapper mapper = (CModbusTcpRtuMapper) applicationContext.getBean("CModbusTcpRtuMapper");
        CModbusRtu recod = new CModbusRtu();
        CModbusTcpRtuExample example = new CModbusTcpRtuExample();
        List<Map<String, Object>> maps = mapper.selectByExample(example);
        System.out.println(maps.toString());
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
        CModbusTcpMapper mapper = (CModbusTcpMapper) applicationContext.getBean("CModbusTcpMapper");
        CModbusTcp cModbusTcp = new CModbusTcp();
        cModbusTcp.setName("cmbs");
        cModbusTcp.setWeight(101);
        cModbusTcp.setMainIp("10.1.0.1");
        cModbusTcp.setPort(8080);
        int i = mapper.updateByPrimaryKey(cModbusTcp);
        System.out.println(i);
    }

    @Test
    public void delByPrimaryKey() throws Exception {
        CModbusTcpMapper mapper = (CModbusTcpMapper) applicationContext.getBean("CModbusTcpMapper");
        CModbusTcp cModbusTcp = new CModbusTcp();
        cModbusTcp.setName("cmbs");
        int i = mapper.deleteByPrimaryKey(cModbusTcp.getName());
        System.out.println(i);
    }
}
