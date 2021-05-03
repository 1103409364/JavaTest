public class Student {
  int age;
  String name;
  static String school = "蓝翔技校";

  // 构造方法
  public Student(int age, String name) {
    this.name = name;
    this.age = age;
  }

  // 实例方法
  public void sayHi() {
    Console.log("Hi! my name is " + this.name + " " + this.age + " old");
  }

  // 静态方法不可通过 实例.的方式调用
  public static void doSomeThing() {
    Console.log("静态方法");
  }
}
