package com.common.test;

import java.lang.reflect.Method;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;
/**
 * <p>
 * 得到当前正在测试运行的方法名称.与TestMethodContext配合使用
 * </p>
 * 
 * <b>使用说明：</b>
 * 
 * <pre>
 * 
 * @RunWith(SpringJUnit4ClassRunner.class)
 * @TestExecutionListeners(listeners = TestMethodContextExecutionListener.class)
 * public class SomeTest {
 *    @Test
 *    public void test_foo() {
 *        Assert.assertEquals("test_foo", TestMethodContext.getMethodName());
 *    }
 * }
 * </pre>
 * 
 * @see TestMethodContext
 * @author badqiu
 */
public class TestMethodContextExecutionListener  implements TestExecutionListener {
    
    public void beforeTestMethod(TestContext testContext) throws Exception {
        Method m = testContext.getTestMethod();
        TestMethodContext.setMethod(m);
    }
    
    public void afterTestMethod(TestContext testContext) throws Exception {
        TestMethodContext.clear();
    }

    public void afterTestClass(TestContext context) throws Exception {
    }

    public void beforeTestClass(TestContext context) throws Exception {
    }

    public void prepareTestInstance(TestContext context) throws Exception {
    }
}
