package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	System.out.println( "Strat-----------" );
    	//spring jdbc template
    	ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
    	StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
    	Student s=new Student();
    	s.setId(3);
    	s.setName("Monish");
    	s.setCity("Muzaffarpur");
    	int r=studentDao.insert(s);
    	System.out.println(r+" rows added");
    	
    }
}
