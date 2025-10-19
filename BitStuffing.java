public class BitStuffing {
    public static void main(String[] args) {
        String s = "01110111011111011111";
        Stuff s1 = new Stuff();
        s1.bitStuff(s);
        Unstuff s2 = new Unstuff();
        s2.bitUnstuff("011101110111110111110");
    }
}

class Stuff {
    String bitStuff(String s) {
        int c = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            res.append(s.charAt(i));
            if (s.charAt(i) == '1') {
                c++;
                if (c == 5) {
                    res.append("0");
                    c = 0;
                }
            } else {
                c = 0;
            }
        }
        String result = res.toString();
        System.out.println("Stuffed: " + result);
        return result;
    }
}

class Unstuff {
    String bitUnstuff(String s) {
        int c = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res.append(ch);
            if (ch == '1') {
                c++;
                if (c == 5 && i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    i++;
                    c = 0;
                }
            } else {
                c = 0;
            }
        }
        String result = res.toString();
        System.out.println("Unstuffed: " + result);
        return result;
    }
}
