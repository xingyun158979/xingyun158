package com.main;

import com.utils.SimHash;
import org.testng.annotations.Test;
import com.utils.HaiMing;
import com.utils.Txt_IO;

import java.text.DecimalFormat;

public class Main0_test {
    //将所有增删改的文件与原文对比，计算并显示保留了二位小数的查重率
    @Test
    public void origOrigTest(){
        DecimalFormat df = new DecimalFormat("#0.00");
        String str0 = Txt_IO.readTxt("txt/orig.txt");
        String str1 = Txt_IO.readTxt("txt/orig.txt");
        String ansFileName = "txt/ansAndOrigTest.txt";
        double ans = HaiMing.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("原文查重率："+df.format(ans*100)+"%");
        Txt_IO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origAddTest(){
        DecimalFormat df = new DecimalFormat("#0.00");
        String str0 = Txt_IO.readTxt("txt/orig.txt");
        String str1 = Txt_IO.readTxt("txt/orig_0.8_add.txt");
        String ansFileName = "txt/ansAndAddTest.txt";
        double ans =HaiMing.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("增添文本查重率："+df.format(ans*100)+"%");
        Txt_IO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origDelTest(){
        DecimalFormat df = new DecimalFormat("#0.00");
        String str0 = Txt_IO.readTxt("txt/orig.txt");
        String str1 = Txt_IO.readTxt("txt/orig_0.8_del.txt");
        String ansFileName = "txt/ansAndDelTest.txt";
        double ans = HaiMing.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("删除文本的查重率："+df.format(ans*100)+"%");
        Txt_IO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origDis1Test(){
        DecimalFormat df = new DecimalFormat("#0.00");
        String str0 = Txt_IO.readTxt("txt/orig.txt");
        String str1 = Txt_IO.readTxt("txt/orig_0.8_dis_1.txt");
        String ansFileName = "txt/ansAndDis1Test.txt";
        double ans = HaiMing.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("修改1文本查重率："+df.format(ans*100)+"%");
        Txt_IO.writeTxt(ans, ansFileName);
    }



    @Test
    public void origDis10Test(){
        DecimalFormat df = new DecimalFormat("#0.00");
        String str0 = Txt_IO.readTxt("txt/orig.txt");
        String str1 = Txt_IO.readTxt("txt/orig_0.8_dis_10.txt");
        String ansFileName = "txt/ansAndDis10Test.txt";
        double ans = HaiMing.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("修改10文本查重率："+df.format(ans*100)+"%");
        Txt_IO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origDis15Test(){
        DecimalFormat df = new DecimalFormat("#0.00");
        String str0 = Txt_IO.readTxt("txt/orig.txt");
        String str1 = Txt_IO.readTxt("txt/orig_0.8_dis_15.txt");
        String ansFileName = "txt/ansAndDis15Test.txt";
        double ans = HaiMing.getSimilarity(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("修改15文本查重率："+df.format(ans*100)+"%");
        Txt_IO.writeTxt(ans,ansFileName);
    }
}
