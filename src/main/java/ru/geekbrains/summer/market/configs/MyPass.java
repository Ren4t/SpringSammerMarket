package ru.geekbrains.summer.market.configs;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPass implements PasswordEncoder {
    //private static final PasswordEncoder INSTANCE = new org.springframework.security.crypto.password.NoOpPasswordEncoder();

    MyPass() {
    }

    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }

//    public static PasswordEncoder getInstance() {
//        return INSTANCE;
//    }
}