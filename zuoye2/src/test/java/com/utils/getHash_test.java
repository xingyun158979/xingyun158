package com.utils;

import org.junit.Test;

public class getHash_test {
    @Test
    public void getHashTest(){
        //测试字符串Hash值的获取
        String[] strings = {"我", "是", "软件工程", "学院", "的", "学生"};
        for (String string : strings) {
            String stringHash = gHash.getHash(string);
            System.out.println(stringHash.length());
            System.out.println(stringHash);
            System.out.println("\n");
        }
    }

}
