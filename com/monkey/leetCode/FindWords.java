package com.monkey.leetCode;

import java.util.ArrayList;

/**
 * Created by xugenli on 2017/7/5.
 */
public class FindWords {
    public static void main(String[] args) {
        char[] qRow = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] aRow = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] zRow = {'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        int result = -1;
        ArrayList<String> cache = new ArrayList<String>();

        for (int i = 0; i < words.length; i++) {
            result = ifContain(qRow, words[i]) + ifContain(aRow, words[i]) + ifContain(zRow, words[i]);
            if(result==1){
                cache.add(words[i]);
            }
        }

        String[] arrString = (String[])cache.toArray(new String[cache.size()]);


        System.out.println(arrString.toString());


    }

    public static int ifContain(char[] cac, String words) {
        for (int i = 0; i < cac.length; i++) {
            if (words.indexOf(cac[i]) != -1) {
                return 1;
            }
        }
        return 0;
    }

}
