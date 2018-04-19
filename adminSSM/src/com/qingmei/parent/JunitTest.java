package com.qingmei.parent;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath*:applicationContext.xml","classpath*:spring-mvc.xml" })  
public abstract class JunitTest  extends AbstractJUnit4SpringContextTests {  
	
} 