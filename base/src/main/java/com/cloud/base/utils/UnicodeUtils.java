package com.cloud.base.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xiaobin
 * Created by xiaobin on 2017/6/12
 * Copyright (c) 2016-2019
 */
public class UnicodeUtils {

    /**
     * Unicode还原字符串
     * @param str
     * @return
     */
    public static String convertUnicodeToNormal(String str) {
        if(StringUtils.isBlank(str)){
            return str;
        }
        String utfString = str;
        int i;
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        while ((i = utfString.indexOf("\\u", pos)) != -1) {
            sb.append(utfString.substring(pos, i));
            if (i + 5 < utfString.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(utfString.substring(i + 2, i + 6), 16));
            }
        }
        sb.append(utfString.substring(pos));
        return sb.toString();
    }

    /**
     * 字符串Unicode编码
     * @param inStr
     * @return
     */
    public static String getStrUnicode(String inStr) {
        StringBuilder unicode = new StringBuilder();
        char c;
        int bit;
        String tmp;
        for (int i = 0; i < inStr.length(); i++) {
            c = inStr.charAt(i);
            if (c > 255) {
                unicode.append("\\u");
                bit = (c >>> 8);
                tmp = Integer.toHexString(bit);
                if (tmp.length() == 1) {
                    unicode.append("0");
                }
                unicode.append(tmp);
                bit = (c & 0xFF);
                tmp = Integer.toHexString(bit);
                if (tmp.length() == 1) {
                    unicode.append("0");
                }
                unicode.append(tmp);
            } else {
                unicode.append(c);
            }
        }
        return (new String(unicode));
    }
}
