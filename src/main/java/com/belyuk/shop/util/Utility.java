package com.belyuk.shop.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Utility {
  private static final Utility instance = new Utility();

  private Utility() {}

  public static Utility getInstance() {
    return instance;
  }

  public String encodePassword(String password) {
    return DigestUtils.md5Hex(password);
  }
}
