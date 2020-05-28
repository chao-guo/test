package leetcode;

import java.util.Stack;
import java.util.function.Consumer;

/**
 * @author g.c
 * @date 2020年5月28日上午9:08:36
 **/
public class DecodeString {
    public String decodeString(String s) {
        String result = "";
        String[] temp = s.split("]");
        for (int i = 0; i < temp.length; i++) {
            String[] split = temp[i].split("\\[");
            int parseInt = Integer.parseInt(split[0]);
            for (int j = 0; j < parseInt; j++) {
                result = result + split[1];
            }
        }
        return result;
    }

    public String decodeString1(String s) {
        Stack<Character> stringStack = new Stack<Character>();
        Stack<String> numberStack = new Stack<String>();
        char[] charArray = s.toCharArray();
        String temp = "";
        for (char c : charArray) {
            if (c == '[') {
                int index = 0;
                for (char cc : temp.toCharArray()) {
                    if (Character.isDigit(cc)) break;
                    index++;
                }
                if (!temp.substring(0, index).equals("")) numberStack.add(temp.substring(0, index));
                if (!temp.substring(index).equals("")) numberStack.add(temp.substring(index));
                temp = "";
                stringStack.add(c);
            } else if (c == ']') {
                if (temp.equals("")) {
                    String ss1 = numberStack.pop();
                    String ss2 = numberStack.pop();
                    String temp3 = "";
                    try {
                        int ss3 = Integer.parseInt(ss2);
                        for (int i = 0; i < ss3; i++) {
                            temp3 = temp3 + ss1;
                            numberStack.add(temp3);
                        }
                    } catch (NumberFormatException e) {
                        numberStack.add(ss2 + ss1);
                    }

                    stringStack.pop();
                } else {
                    String pop = numberStack.pop();
                    stringStack.pop();
                    String temp2 = "";
                    for (int i = 0; i < Integer.parseInt(pop); i++) {
                        temp2 = temp2 + temp;
                    }
                    numberStack.add(temp2);
                    temp = "";
                }
            } else
                temp = temp + c;
        }
        String result = "";
        while (!numberStack.empty()) {
            String pop = numberStack.pop();
            String a = "";
            try {
                a = result;
                int i1 = Integer.parseInt(pop);
                for (int i = 0; i < i1 - 1; i++) {
                    result = result + a;
                }
            } catch (NumberFormatException e) {
                result = pop + result;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Consumer<String> a = System.out::println;
        String decodeString = new DecodeString().decodeString1("3[a]2[bc]");
        a.accept(decodeString);
        decodeString = new DecodeString().decodeString1("3[a2[c]]");
        a.accept(decodeString);
        decodeString = new DecodeString().decodeString1("2[abc]3[cd]1[ef]");
        a.accept(decodeString);
    }
}
