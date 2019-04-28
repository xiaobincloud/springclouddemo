/*
 * Copyright (c) 2013-2015, 成都友漾健康科技有限公司
 * Created by qingyu on 2017/1/23.
 */
package com.cloud.base.utils;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptUtils {

    private static Logger logger= LoggerFactory.getLogger(PasswordEncryptUtils.class);
    public static final String encryptPassword(String password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            return Hex.encodeHexString(md5.digest());
        } catch (NoSuchAlgorithmException e) {
            logger.debug("密码加密异常:{}",e);
        }
        return null;
    }
}
