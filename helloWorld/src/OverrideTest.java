public class OverrideTest {

  public static void main(String[] args) {
    Bird f = new Bird("菲尼克斯");
    // b.eat();
    // b.move();
    // b.move();
    // b.move(1);
    Animal d = new Dog("旺财"); // 向上转型
    // d.move();

    Master master = new Master();
    master.feed(d);
    master.feed(f);
    // Dog dog = (Dog) (new Animal());
    // dog.wan();
  }

}

class Master {
  // 形参使用父类型，使用多态保证扩展性。想养其他动物可以创建新的动物类。
  public void feed(Animal a) {
    System.out.println("喂" + a.getName());
    a.eat();
  }
}

class Animal {
  private String name;

  public Animal() {
    this("动物");
  }

  public Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void move() {
    System.out.println("移动");
  }

  public void eat() {
    System.out.println(this.name + "吃饭");
  };
}

class Dog extends Animal {
  public Dog() {
    super();
  }

  public Dog(String name) {
    super(name);
  }

  public void wan() {
    System.out.println("汪汪汪");
  }
}

class Bird extends Animal {
  public Bird() {
    super();
  }

  public Bird(String name) {
    super(name);
  }

  @Override
  public void move() {
    // super.move();
    System.out.println(this.getName() + "飞翔");
  }

  // 重载，继承之后有了一个 move 无参方法
  public void move(int i) {
    System.out.println(this.getName() + "move" + i);
  }
}
