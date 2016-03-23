package cn.javass.spring.chapter8;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ConfigurableObjectInputStream;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ibatis.sqlmap.client.SqlMapSession;

import cn.javass.spring.chapter7.UserModel;
import cn.javass.spring.chapter7.dao.IUserDao;
import junit.framework.Assert;

public class IbatisTest {

	private static SqlMapClient sqlMapClient;

	@BeforeClass
	public static void setUpClass() {
		String[] configLocations = new String[] { "classpath:chapter7/applicationContext-resources.xml",
				"classpath:chapter8/applicationContext-ibatis.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		sqlMapClient = ctx.getBean(SqlMapClient.class);
	}

	@Before
	public void setUp() throws SQLException {
		sqlMapClient.update("UserSQL.createTable");
	}

	@After
	public void tearDown() throws SQLException {
		sqlMapClient.update("UserSQL.dropTable");
	}

	@Test
	public void testFirst() throws SQLException {

		UserModel model = new UserModel();
		model.setMyName("test");
		SqlMapSession session = null;

		try {
			session = sqlMapClient.openSession();
			beginTransaction(session);
			session.insert("UserSQL.insert", model);
			commitTransaction(session);

		} catch (SQLException e) {
			rollbackTransaction(session);
			throw e;
		} finally {
			closeSession(session);
		}

	}

	private void closeSession(SqlMapSession session) {
		// TODO Auto-generated method stub
		session.close();
	}

	private void rollbackTransaction(SqlMapSession session) throws SQLException {
		// TODO Auto-generated method stub
		if (session != null) {
			session.endTransaction();
		}
	}

	private void commitTransaction(SqlMapSession session) throws SQLException {
		// TODO Auto-generated method stub
		session.commitTransaction();

	}

	private void beginTransaction(SqlMapSession session) throws SQLException {
		// TODO Auto-generated method stub
		session.startTransaction();

	}

	@Test
	public void testSqlMapClientTemplate() {
		SqlMapClientTemplate sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
		final UserModel model = new UserModel();
		model.setMyName("myName");
		sqlMapClientTemplate.insert("UserSQL.insert", model);
		// 通过回调允许更复杂操作
		sqlMapClientTemplate.execute(new SqlMapClientCallback<Void>() {

			@Override
			public Void doInSqlMapClient(SqlMapExecutor session) throws SQLException {
				// TODO Auto-generated method stub
				session.insert("UserSQL.insert", model);
				return null;
			}
		});

	}

	@Test
	public void testBestPractive() {
		String[] configLocations = new String[] { "classpath:chapter7/applicationContext-resources.xml",
				"classpath:chapter8/applicationContext-ibatis.xml" };

		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		IUserDao userDao = ctx.getBean(IUserDao.class);
		UserModel model = new UserModel();
		model.setMyName("test");
		userDao.save(model);
		Assert.assertEquals(1, userDao.countAll());

	}

	@Test
	public void testMybatisBestPractice() {
		String[] configLocations = new String[] { "classpath:chapter7/applicationContext-resources.xml",
				"classpath:chapter8/applicationContext-mybatis.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		IUserDao userDao = ctx.getBean(IUserDao.class);
		UserModel model = new UserModel();
		model.setMyName("myName");
		userDao.save(model);
		Assert.assertEquals(1, userDao.countAll());
	}

}
