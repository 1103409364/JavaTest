class ThiTest {
  public static void main(String[] args) {
    Customer c1 = new Customer("张三");
    Customer c2 = new Customer("张四");
    c1.shopping();
    c2.shopping();
    Console.log(c1);
  }
}

class Customer {
  String name;

  public Customer() {
  }

  public Customer(String name) {
    this.name = name;
  }

  public void shopping() {
    Console.log(this.name + "在购物 this" + this); // this 指向 当前对象
  }

  // 报错 Cannot make a static reference to the non-static field
  // public static void doSomething() {
  // Console.log(name);
  // }
}

class WeChat {
  String name;
  String nikeName;
  String phone;

  public WeChat(String name, String nikeName, String phone) {
    this.name = name;
    this.nikeName = nikeName;
    this.phone = phone;
  }
}