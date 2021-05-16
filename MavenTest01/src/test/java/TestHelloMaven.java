import org.junit.Assert;
import org.junit.Test;

import com.xxx.testMaven.HelloMaven;

public class TestHelloMaven {
  @Test
  public void testAdd() {
    final HelloMaven h = new HelloMaven();
    final int res = h.add(10, 10);
    System.out.println("test add");
    // 验证add方法执行是否正确，参数：目标值，实际值
    Assert.assertEquals(20, res);
  }
}
