package com.matthem.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void show() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c", "a");
        System.out.println(list.subList(1, 4));
    }

    // str -> "aghAyYrdR"
    // chars -> ['a', 'g', 'h', 'A', 'y', 'Y', 'r', 'd', 'R']
    // newChars = ['a', 'A', 'y', 'Y', 'r', 'R']
    // return -> "y"
/*    public static char lexicalValue(String str) {
        char[] newChars = new char[str.length()];
        char[] chars = str.toCharArray();
        String ch;

        for (int i = 0; i < chars.length - 1; i++) {
            if(charArrContains(newChars, chars[i])) continue;
            if(Character.isLowerCase(chars[i])) {
                ch = String.valueOf(chars[i]).toUpperCase();
                if (str.contains(ch))
                    newChars[i] = chars[i];
            } else if(Character.isUpperCase(chars[i])) {
                ch = String.valueOf(chars[i]).toLowerCase();
                if (str.contains(ch))
                    newChars[i] = chars[i];
            }
        }

        for (char c: newChars)
            if(Character.isLowerCase(c))

    }

    private static boolean charArrContains(char[] newChars, char aChar) {
        for (char c : newChars)
            if(c == aChar) return true;
        return false;
    }*/
}
