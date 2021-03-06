package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@Log4j
public class DataSourceTests {
	@Setter(onMethod_ = { @Autowired })
	  private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	
	// hikari cp test !!
	@Test
	public void testConnection() {
		 try (Connection con = dataSource.getConnection()){
		      log.info(con);
		      
		    }catch(Exception e) {
		      fail(e.getMessage());
		    }
		  }

	// mybatis test !!
	@Test
	public void testConnection2(){ 
		
		try(SqlSession session = sessionFactory.openSession()){
			 Connection con = session.getConnection();
			log.info(con);
			log.info(session);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
}