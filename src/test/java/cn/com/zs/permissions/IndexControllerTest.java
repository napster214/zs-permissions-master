//package cn.com.zs.permissions;
//
//
//import cn.com.zs.permissions.web.IndexController;
//import org.hamcrest.Matchers;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
///**
// * 标题:
// * <p>
// * 描述:
// * <p>
// * 版权: Copyright (c) 2017
// * <p>
// * 公司: 广州点睿信息科技有限公司
// * <p>
// *
// * @author 张顺
// * @version 1.0
// * @created 2017/12/27-10:17
// */
//@RunWith(SpringRunner.class)
//@WebMvcTest(IndexController.class)
//@AutoConfigureRestDocs(outputDir = "target/snippets")
//public class IndexControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void shouldReturnDefaultMessage() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/helloword"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                .string(Matchers.containsString("helloword")))
//                .andDo(MockMvcRestDocumentation.document("home"));
//    }
//}
