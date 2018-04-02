package com.example.demo.sec;

//Voici les constantes que nous avons utilisées dans la mise en œuvre ci-dessus.
public class SecurityConstant {
    // Authorization Bearer uheauhehgy3u231uh
    public static final String SECRET = "secre";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    //static final String SIGN_UP_URL = "/users/sign-up";
    public static final long EXPIRATION_TIME = 864_000_000L; //10jours

//    public static void main(String[] args) {
//        System.out.println(TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
//    }
}
