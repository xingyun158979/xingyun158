package com.utils;

import org.junit.Test;

public class SimHash_test {
    @Test
    public void getHashTest(){
        //测试文本SimHash值的获取
        String str0 = Txt_IO.readTxt("txt/orig.txt");
        String str1 = Txt_IO.readTxt("txt/orig_0.8_add.txt");
        String str2 = Txt_IO.readTxt("txt/orig_0.8_dis_1.txt");
        System.out.println("文本0的SimHash值为："+SimHash.getSimHash(str0));
        System.out.println("\n");
        System.out.println("文本1的SimHash值为："+SimHash.getSimHash(str1));
        System.out.println("\n");
        System.out.println("文本2的SimHash值为："+SimHash.getSimHash(str2));
    }
}
