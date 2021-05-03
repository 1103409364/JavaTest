public class TestFind {
    public static void main(final String[] args) {
        final String s = "aaabbbdddddccccceeeeeeeeee";
        final Find f = new Find();
        f.findRepeat(s);
    }
}

// 寻找重复次数最多的字符串
class Find {
    public void findRepeat(final String s) {
        int maxLength = 0;
        char targetChar = s.charAt(0);
        final int length = s.length();
        int i = 0, j = 1;
        while (i < length - 1) {
            if (j == length - 1) {
                if (j - i >= maxLength) {
                    maxLength = j - i;
                    targetChar = s.charAt(j - 1);
                    System.out.println(maxLength);
                }
                break;
            }
            if (s.charAt(i) != s.charAt(j)) {
                if (j - i >= maxLength) {
                    maxLength = j - i;
                    targetChar = s.charAt(j - 1);
                    System.out.println(maxLength);
                }
                i = j;
            }
            j++;
        }
        System.out.println("重复次数最多的字符" + targetChar);
    }
}
