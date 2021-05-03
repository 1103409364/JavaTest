import java.util.Objects;

public class Hello {
  public static void main(final String[] args) {
    final int[] arr2 = {1, 2};
    System.out.println(arr2[0]);
  }
}

class Test {
  int i;
  String s;

  public void h() {
    System.out.println("hh");
  }

  @Override
  public String toString() {
    return "Test{" +
            "i=" + this.i +
            ", s='" + this.s + '\'' +
            '}';
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Test test = (Test) o;
    return this.i == test.i && this.s.equals(test.s);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.i, this.s);
  }
}