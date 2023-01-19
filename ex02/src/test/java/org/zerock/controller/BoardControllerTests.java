package org.zerock.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"	
})
@Log4j
public class BoardControllerTests {


		@Setter(onMethod_ = {@Autowired} )
		private WebApplicationContext ctx;
		
		private MockMvc mockMvc;

		

		@org.junit.Before
		public void setup() {
			
			this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();	
			
		}
		
		
		@Test
		public void testList() throws Exception {
			
			log.info(
				mockMvc
						.perform(MockMvcRequestBuilders
						.get("/board/list"))
						.andReturn()
						.getModelAndView()
						.getModelMap());	
					}
		
		
		@Test
		public void testRegister() throws Exception {
			
			
			String resultPage = mockMvc.perform(MockMvcRequestBuilders
					.post("/board/register")
					.param("title", "테스트 새글 제목")
					.param("content", "내용은 이러이러하다")
					.param("writer", "user02020"))
			.andReturn().getModelAndView().getViewName();
					
					
					log.info(resultPage);
				}
		
		@Test
		public void testGet() throws Exception {
			
			
			log.info(mockMvc.perform(MockMvcRequestBuilders
					.get("/board/get")
					.param("bno", "27"))
					.andReturn()
					.getModelAndView()
					.getModelMap());
	
		}

		
		@Test
		public void testModify() throws Exception {
			
		 log.info(
				   mockMvc.perform(MockMvcRequestBuilders
						 .post("/board/modify")
						 .param("bno", "25" )
						 .param("title", "MockMvcRequestBuilters")
						 .param("content", "BrokenClocks")
						 .param("writer", "sza"))
				 .andReturn().getModelAndView().getViewName());
		}
		
		@Test
		public void testRemove() throws Exception {
			
			log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "25"))
					.andReturn().getModelAndView().getViewName()
					);
			
			
		}
		
		@Test
		public void testListPaging() throws Exception {
			
			log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
			.param("pageNum", "2")
			.param("amount", "10"))
			.andReturn().getModelAndView().getViewName()
			
					
					);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
