package com.main;

import com.utils.HaiMing;
import com.utils.SimHash;
import com.utils.Txt_IO;

import java.text.DecimalFormat;

public class Main0 {
    public static void main(String[] args) {
        //保留二位小数的格式
        DecimalFormat df = new DecimalFormat("#0.00");

        //分别输入所用及保存文件地址
        String s1 = args[0];
        String s2 = args[1];
        String resultFileName = args[2];
        // 通过输入的路径名读取对应的文件，将文件内容转化为字符串
        String str0 = Txt_IO.readTxt(s1);
        String str1 = Txt_IO.readTxt(s2);

        // 计算字符串对应的simHash值
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);

        // 由simHash值计算出相似度
        double similarity = HaiMing.getSimilarity(simHash0, simHash1);
        // 在运行窗口中显示相似度，并把相似度写入最后的结果文件中
        System.out.println("Duplcate Checking Rate："+df.format(similarity*100)+"%");
        Txt_IO.writeTxt(similarity, resultFileName);
    }
}

