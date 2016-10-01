package sequencegenerator.service;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by silva on 18.09.16..
 */

public class PasswordService {

    public static String getPasswordHash(String password) {


        String hasshedPassword = DigestUtils.sha1Hex(password);

        return hasshedPassword;


    }

}