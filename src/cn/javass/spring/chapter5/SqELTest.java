package cn.javass.spring.chapter5;

import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import junit.framework.Assert;

public class SqELTest {

	@Test
	public void helloWorld(){
		ExpressionParser parser = new SpelExpressionParser();
		
		Expression expression = parser.parseExpression("('HEllo'+'world').concat(#end)");
		EvaluationContext ctx =new StandardEvaluationContext();
		ctx.setVariable("end", "?");
		Assert.assertEquals("HElloworld?", expression.getValue(ctx));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testClassTypeExpression(){
		ExpressionParser parser = new SpelExpressionParser();
		//java.lang包类访问
		Class<String> result1 =parser.parseExpression("T(String)").getValue(Class.class);
		Assert.assertEquals(String.class, result1);
		
		//其他包类访问
		String expression = "T(cn.javass.spring.chapter5.SqELTest)";
		Class<String> result2 =parser.parseExpression(expression).getValue(Class.class);
		Assert.assertEquals(SqELTest.class, result2);
		//类静态字段访问
		int result3 =parser.parseExpression("T(Integer).MAX_VALUE").getValue(int.class);
		Assert.assertEquals(Integer.MAX_VALUE, result3);
		//类静态方法调用
		int result4 = parser.parseExpression("T(Integer).parseInt('1')").getValue(int.class);
		Assert.assertEquals(1, result4);
	}
	
	@Test
	public void testVariableExpression(){
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context =new StandardEvaluationContext();
		context.setVariable("variable", "haha");
		String result1 = parser.parseExpression("#variable").getValue(context,String.class);
		Assert.assertEquals("haha", result1);
		context = new StandardEvaluationContext("haha");
		String result2=parser.parseExpression("#root").getValue(context,String.class);
		Assert.assertEquals("haha", result2);
		String result3 =parser.parseExpression("#this").getValue(context,String.class);
		Assert.assertEquals("haha", result3);
	}
	
	@Test
	public void testFunctionExpression() throws NoSuchMethodException, SecurityException{
		ExpressionParser parser = new SpelExpressionParser();
		StandardEvaluationContext context = new StandardEvaluationContext();
		Method parseInt = Integer.class.getDeclaredMethod("parseInt", String.class);
		context.registerFunction("parseInt", parseInt);
		context.setVariable("parseInt2", parseInt);
		String expression1 ="#parseInt('3')==#parseInt2('3')";
		boolean result1 = parser.parseExpression(expression1).getValue(context,boolean.class);
		Assert.assertEquals(true, result1);
	}
	
	@Test
	public void testAnnotationExpression(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter5/el2.xml");
		SpELBean helloBean1 = ctx.getBean("helloBean1", SpELBean.class);
		Assert.assertEquals("Hello World!",helloBean1.getValue());
		SpELBean helloBean2 = ctx.getBean("helloBean2", SpELBean.class);
		Assert.assertEquals("haha", helloBean2.getValue());
		
	}
}
