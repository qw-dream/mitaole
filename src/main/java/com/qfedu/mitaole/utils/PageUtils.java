package com.qfedu.mitaole.utils;

public class PageUtils {

    public static Integer getPage(String currentPageStr){
        if (null == currentPageStr){
            //如果没有传递当前页数，默认为第一页
            currentPageStr = "1";
        }
        Integer currentPage = Integer.valueOf(currentPageStr);

        return currentPage;
    }

}