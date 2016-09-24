package sequencegenerator.service;

/**
 * Created by silva on 18.09.16..
 */

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordService {

    public static String getPasswordHash(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
}