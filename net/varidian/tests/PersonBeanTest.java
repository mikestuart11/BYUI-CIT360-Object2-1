package net.varidian.tests;

import net.varidian.junit.PersonBean;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

/** 
* PersonBean Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 3, 2015</pre> 
* @version 1.0 
*/ 
public class PersonBeanTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getName() 
* 
*/ 
@Test
public void testGetName() throws Exception {
    PersonBean test1 = new PersonBean("Jack");
    String name = test1.getName();
    assertEquals("Jack", name);

} 

/** 
* 
* Method: setName(String name) 
* 
*/ 
@Test
public void testSetName() throws Exception { 
//TODO: Test goes here... 
} 


} 
