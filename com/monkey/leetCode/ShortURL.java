package com.monkey.leetCode;

import java.util.Hashtable;
import java.util.Random;

/**
 * Created by xugenli on 2017/6/26.
 */

public class ShortURL {

    //hash table could have duplicate key, not value.
    Hashtable urlPool = new Hashtable();

    String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int baseLength = base.length();
    Random random = new Random();
    StringBuffer buffer = new StringBuffer();

    //generate random six figure number
    public String randomSixFigureNumber() {
        buffer.setLength(0);
        for (int i = 0; i < 6; i++) {
            char value = base.charAt(random.nextInt(baseLength));
            buffer.append(value);
        }
        return buffer.toString();
    }

    //check if the random shortUrl exits

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = randomSixFigureNumber();
        while (urlPool.containsValue(shortUrl)) {
            shortUrl = randomSixFigureNumber();
        }

        urlPool.put(shortUrl,longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String url = urlPool.get(shortUrl).toString();
        return url;
    }

    public static void main(String[] args) {
        ShortURL a = new ShortURL();
        String shortUrl = a.encode("https://leetcode.com/problems/design-tinyurl");
        String longUrl = a.decode(shortUrl);
        System.out.println(shortUrl);
        System.out.println(longUrl);
    }


}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
