package com.jwj.russianblue.core.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-datasource.xml", "classpath:spring-context.xml" })
@TransactionConfiguration(transactionManager = "coreTransactionManager", defaultRollback = true)
@Transactional("coreTransactionManager")
public class GenericTest extends AbstractTest {

	static void jndiSetup() throws Exception {
		SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
		builder.bind("java:comp/env/jdbc/core",new SimpleDriverDataSource(new SQLServerDriver(),
				"jdbc:sqlserver://localhost;database=russianblue", "sa", "admin") );
		builder.activate();
	}

	@BeforeClass
	public static void beforeClass() throws Exception {
//		jndiSetup();
	}

	@AfterClass
	public static void afterClass() {
		// reserved
	}

}
