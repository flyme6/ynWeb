package com.yn.controller;

import com.yn.common.Result;
import com.yn.controller.systemConfig.common.commonController;
import com.yn.entity.General;
import com.yn.entity.TcpExample;
import com.yn.smo.ITcpService;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class commonceController {
    private MockMvc mockMvc;
    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        commonController controller = new commonController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetSequence() {
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/systemConfig/common/goAdd"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            int status = mvcResult.getResponse().getStatus();
            System.out.println("请求状态码：" + status);
            String result = mvcResult.getResponse().getContentAsString();
            System.out.println("接口返回结果：" + result);
//            JSONObject resultObj = JSON.parseObject(result);
            // 判断接口返回json中success字段是否为true
//            Assert.assertTrue(resultObj.getBooleanValue("success"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
