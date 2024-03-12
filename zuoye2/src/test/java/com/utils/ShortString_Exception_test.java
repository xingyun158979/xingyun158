package com.utils;

import org.junit.Test;

public class ShortString_Exception_test {
    @Test
    public void shortStringExceptionTest(){
        //测试文本长度小于300的情况
        System.out.println(SimHash.getSimHash("今天是周二，明天是周三"));
    }
}