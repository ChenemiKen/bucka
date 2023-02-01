package com.chenemiken.bucka.security;

public class SecurityConstants {
  public static  final String SECRET_KEY = "fl7;hf8@gH5yM8!fU4-e"; //Your secret should
  public  static final int TOKEN_EXPIRATION = 7200000; //7200 seconds = 2 hours.
  public static final String BEARER = "Bearer "; //Authorization : "Bearer " + Token
  public static final String AUTHORIZATION = "Authorization"; //Authorization : "Bearer " + Token
//  public static final String REGISTER_PATH = "/user/register"; //Public path that client calls to register
}
