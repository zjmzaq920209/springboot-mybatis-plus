package com.example.springboottest.test;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @PackageName: com.example.springboottest.test
 * @className: RSA
 * @Description:
 * @Author: Jingmeng
 * @Date: 2020/12/1 17:19
 **/
public class RSA {



    private static Map<Integer, String> keyMap = new HashMap<>(); // 用于封装随机产生的公钥与私钥

    public static void main(String[] args) throws InvalidKeyException {
      //生成公钥和私钥
      genKeyPair();
      //加密字符串
      String message = "df723820";
      System.out.println("随机生成的公钥为:" + keyMap.get(0));

      System.out.println("随机生成的私钥为:" + keyMap.get(1));


      //用公钥加密
      String messageEn = encrypt(message, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCXbPPaDmA4YeTNM2+FD06qq2mTN0mAvKa543fZ+pyjyVps4vpLvTdEb6F0tia+z/n3zbrp+JpqnHUDjS0bII64D1GkK9W55K97uGUzHJPHj452H+w2H+DdeJf2NrL/C530uL5LAs+ZtOIIZCeOKMIy5wDB82mqTqJF8LQfPnEAcwIDAQAB");
      System.out.println("加密后的字符串为:" + messageEn);


      //私钥解密
      String messageDe = decrypt(messageEn, "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJds89oOYDhh5M0zb4UPTqqraZM3SYC8prnjd9n6nKPJWmzi+ku9N0RvoXS2Jr7P+ffNuun4mmqcdQONLRsgjrgPUaQr1bnkr3u4ZTMck8ePjnYf7DYf4N14l/Y2sv8LnfS4vksCz5m04ghkJ44owjLnAMHzaapOokXwtB8+cQBzAgMBAAECgYBQY/Zd+K3aoRYgXsNA5+yCrTgCgSKTpxP4siuJ3QPV7GsGTcZF+XFi8sTLunx9Ztq1VVJ7LpGEMgXpWcTtlu5NNj2ME2dTgHQgOEMtckMxjUHxIY8RcAG4MRN8QzvcZzOycI0pJVKgfHvO6feH4Jj5KiOuP6kMvEy7dUq8/jyIgQJBAMYdWjMQwymHAD9SGPtUPtUCBvJshaL/M9k+sDkI3wsEKZ5fNksxIYuuN2yjw1oMAw4bA+fjXovZhJsNu8GA5EECQQDDq1X65JD1p8g0YRbtDfkq1RUVyl0flVp2HFGiC1bF+vw26k63Gwu0xTfeC9MMGVIAV/+yOIOCJHjUowYlq6ezAkAPYwQ4ZxrhRMzuHhA2pOpkXM3xUiBm8m8ydj31kAzSrDYXSMnMuTojwRoo4+cuPTSXid2Zyvzy26gC6uQkOUCBAkBm9yeEonihvMv+vESrNBo1bvHsiJPeheKXmqleg2cDQeMtJrmLY4ESfGG8yC4kBMMBCU21xEV326d2Bd+7PQw/AkEAn33M3mq9ESRr89QCholS734PsOheDbynSZnwo76Ij+CZ7myDHgVo8RGXFj8sTY3Os9Q2xUuBEiozQkpmZcDrYQ==");
      System.out.println("还原后的字符串为:" + messageDe);
    }

    //随机生成密钥对
    public static void genKeyPair() {
      // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
      KeyPairGenerator keyPairGen = null;

      try {
        keyPairGen = KeyPairGenerator.getInstance("RSA");
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }

      // 初始化密钥对生成器，密钥大小为96-1024位
      assert keyPairGen != null;
      keyPairGen.initialize(1024, new SecureRandom());
      // 生成一个密钥对，保存在keyPair中
      KeyPair keyPair = keyPairGen.generateKeyPair();
      RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
      RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
      String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
      // 得到私钥字符串
      String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
      // 将公钥和私钥保存到Map
      keyMap.put(0, publicKeyString);  //0表示公钥
      keyMap.put(1, privateKeyString);  //1表示私钥
    }

    /** RSA公钥加密
     * @param str  加密字符串
     * @param publicKey  公钥
     * @return  密文
     */
    public static String encrypt(String str, String publicKey) throws InvalidKeyException {
      //base64编码的公钥
      byte[] decoded = Base64.decodeBase64(publicKey);
      RSAPublicKey pubKey = null;
      String outStr = null;

      try {
        pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
      } catch (InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException e) {
        e.printStackTrace();
      }
      //RSA加密
      return outStr;
    }

    /**  RSA私钥解密
     * @param str   加密字符串
     * @param privateKey  私钥
     * @return  铭文
     */
    public static String decrypt(String str, String privateKey) {
      //64位解码加密后的字符串
      byte[] inputByte = Base64.decodeBase64(str.getBytes(StandardCharsets.UTF_8));
      //base64编码的私钥
      byte[] decoded = Base64.decodeBase64(privateKey);
      RSAPrivateKey priKey = null;
      //RSA解密
      Cipher cipher = null;
      String outStr = null;

      try {
        priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        outStr = new String(cipher.doFinal(inputByte));
      } catch (InvalidKeySpecException | NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
        e.printStackTrace();
      }
      return outStr;
    }


}
