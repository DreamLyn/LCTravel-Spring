package com.lv.travel;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.filter.DelegatingFilterProxy;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/spring_global.xml"})
public class BaseJunitTest {
	
}
