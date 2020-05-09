package com.zsn.blog.util;

import org.pegdown.PegDownProcessor;

/**
 * @ClassName MarkdownToHtml
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 9:24
 * @Version 1.0
 **/
public class MarkdownToHtml {

    public static String markDownToHtml(String makeDownStr) {
        PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
        return pdp.markdownToHtml(makeDownStr);
    }
}
