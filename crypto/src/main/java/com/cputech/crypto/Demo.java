package com.cputech.crypto;

/**
 * Created by song on 2017/10/9.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.security.interfaces.RSAPrivateKey;

import static com.cputech.crypto.AESUtil.AES_CBC_Decrypt;


public class Demo {
    public static void main(String[] args) throws Exception {
        //获取私钥
        RSAPrivateKey privateKey = RSAUtil.getPrivateKey("private.pem");
        //读取已经公钥加密的AES密钥文件--记录AES加密时候产生的随机数
        String encodedSecrete = IOUtil.getContent("key.secrete");
        //解密该随机数
        String secrete = RSAUtil.decrypt(encodedSecrete, privateKey);
        //读取加密过的申请文件
        byte[] encodedFileBytes = IOUtil.inputStreamToBytes(Demo.class.getResourceAsStream("/files.kgj"));
        //文件转码和解密,输入上面解析出的随机数
        byte[] decoded = AES_CBC_Decrypt(encodedFileBytes, AESUtil.genSkc(secrete), false);
        FileOutputStream fileOutputStream = new FileOutputStream(new File("申请文件.zip"));
        fileOutputStream.write(decoded);
        fileOutputStream.flush();
    }
}