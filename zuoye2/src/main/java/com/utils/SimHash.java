package com.utils;

import com.hankcs.hanlp.HanLP;
import java.util.List;

public class SimHash {
    public static String getSimHash(String str){
        // 文本长度太短时HanLp无法取得关键字
        try{
            if(str.length() < 300) throw new ShortString_Exception("文本长度过短！");
        }catch (ShortString_Exception e){
            e.printStackTrace();
            return null;
        }
        // 用数组表示特征向量,取128位,从 0 1 2 位开始表示从高位到低位
        int[] a = new int[128];
        // 1、分词（使用了外部依赖hankcs包提供的接口）
        List<String> keywordList = HanLP.extractKeyword(str, str.length());//取出所有关键词
        // hash
        int size = keywordList.size();
        int i = 0;

        // 2、获取hash值
        for(String keyword : keywordList){
            StringBuilder keywordHash = new StringBuilder(gHash.getHash(keyword));
            if (keywordHash.length() < 128) {
                // hash值可能少于128位，所有在低位用0将其补齐
                int dif = 128 - keywordHash.length();
                keywordHash.append("0".repeat(Math.max(0, dif)));
            }


            // 3、加权与合并
            for (int j = 0; j < a.length; j++) {
                // 对keywordHash的每一位与'1'进行比较
                if (keywordHash.charAt(j) == '1') {a[j] += (10 - (i *10/ size) );}
                //将权重分为10级，由词频从高到低，取权重10~0
                else { a[j] -= (10 - (i *10/ size )); }
            }
            i++;
        }


        // 4、降维
        StringBuilder simHash = new StringBuilder();// 储存返回的simHash值
        for (int k : a) {
            // 从高到低进行遍历
            if (k <= 0) { simHash.append("0"); }
            else { simHash.append("1"); }
        }
        return simHash.toString();
    }
}

