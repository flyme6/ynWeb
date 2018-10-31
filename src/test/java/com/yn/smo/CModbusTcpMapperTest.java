package com.yn.smo;

import com.yn.common.Result;
import com.yn.entity.CModbusTcpExample;
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
        ICModbusTcpService service = (ICModbusTcpService) applicationContext.getBean("CModbusTcpImpl");
        CModbusTcpExample example = new CModbusTcpExample();
        Result result = service.queryICModbusTcp(example);
        System.out.println(result);
    }
}
