package com.utils;

import org.junit.Test;

import java.text.DecimalFormat;

public class HaiMing_test {
    DecimalFormat df = new DecimalFormat("#0.00");
    @Test
    public void getHaiMingDistanceTest() {
        //测试海明距离的计算
        String str0 = Txt_IO.readTxt("txt/orig.txt");
        String str1 = Txt_IO.readTxt("txt/orig_0.8_add.txt");
        int distance = HaiMing.getHaiMing(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("海明距离：" + distance);

    }

    @Test
    public void getHaiMingDistanceFailTest() {
        // 测试str0.length()!=str1.length()的情况
        String str0 = "111100";
        String str1 = "1000";
        System.out.println(HaiMing.getHaiMing(str0, str1));
    }

    @Test
    public void getSimilarityTest() {
        //测试相似度的计算
        String str0 = Txt_IO.readTxt("txt/orig.txt");
        String str1 = Txt_IO.readTxt("txt/orig_0.8_dis_10.txt");
        String str2 = Txt_IO.readTxt("txt/orig_0.8_dis_1.txt");
        int distance1 = HaiMing.getHaiMing(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        int distance2= HaiMing.getHaiMing(SimHash.getSimHash(str0), SimHash.getSimHash(str2));
        double similarity1 = HaiMing.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        double similarity2 = HaiMing.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str2));
        System.out.println("str0和str1的海明距离: " + distance1);
        System.out.println("str0和str1的相似度:" + df.format(100*similarity1)+"%");
        System.out.println("str0和str2的海明距离: " + distance2);
        System.out.println("str0和str2的相似度:" + df.format(100*similarity2)+"%");



    }
}