public class Main { // 类体中放方法等，类体中不能直接写输出语句，要写在入口中。
  // 程序入口，类体中只能有一个入口。
  /**
   * 
   * @param args 形参 args，参数类型 字符串数组
   */
  public static void main(String[] args) {
    // String s = "字符串字符串字符串字符串"; // 字符串要用双引号
    // String f = s.replaceAll("字", "111"); // + i;

    // System.out.println(f);
    Student s1 = new Student(18, "小明");
    s1.sayHi();
    // The static method doSomeThing() from the type Student should be accessed in a
    // static way
    // s1.doSomeThing();
    Student.doSomeThing();
    // The static field Student.school should be accessed in a static
    // wayJava(570425420)
    Console.log("学校：" + s1.school);
  }
}

// public 不是必须的，如果有，public 修饰的类必须与文件名一致，一个 java 文件中只能有一个 public 类
//
// The public type Main1 must be defined in its own file
// class B {
// public static void main(String[] args) {
// System.out.println("class B");
// }
// }

// 一个文件中可以有多个类，多个入口，想从哪个入口进去就加载哪个类。java B
// 实际项目中一般不会这么写，一个程序一个入口就够了