public class Method {
  public static void main(String[] args) {
    // 调用其他类的方法，实参和形参必须一一对应，不能多也不能少
    Car.run("F1");
  }
}

class Car {
  public static void run(String name) {
    System.out.println(name + " speed 0km/h 50km/h 500km/h");
    Method.main(null);
  }
}