package com.wzq.ssmcrud.test;

import com.github.pagehelper.PageInfo;
import com.wzq.ssmcrud.bean.Juvenile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MVCTest {

    @Autowired
    private WebApplicationContext context;
    //虚拟mvc请求，获取到处理结果
    private MockMvc mockMvc;

    @Before
    public void initMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void  testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getJuveniles").param("pn","1")).andReturn();
        //请求成功以后，请求域中会有pageInfo，我们取出pageInfo进行验证
        MockHttpServletRequest request = result.getRequest();
        System.out.println(request);
        PageInfo<Juvenile> pi = (PageInfo) request.getAttribute("pageInfo");
        System.out.println(request.getAttribute("pageInfo"));
        System.out.println(pi);
        System.out.println();
        System.out.println("当前页码：  " + pi.getPageNum());
        System.out.println("总页码:  " + pi.getPages());
        System.out.println("总记录数：  " + pi.getTotal());
        System.out.println("在页面需要连续显示的页码");
        int[] nums = pi.getNavigatepageNums();
        for(int i = 0;i < nums.length;i++){
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
        //获取juvenile数据
        List<Juvenile> list = pi.getList();
        for(Juvenile juvenile : list){
            System.out.println("juvenileName:" + juvenile.getjName());
        }
    }


}
