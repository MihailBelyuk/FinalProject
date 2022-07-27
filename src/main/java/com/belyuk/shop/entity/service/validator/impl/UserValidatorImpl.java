package com.belyuk.shop.entity.service.validator.impl;

import com.belyuk.shop.entity.service.validator.UserValidator;

public class UserValidatorImpl implements UserValidator {

  private static final String USER_LAST_NAME_REGEXP = "\\p{Alpha}{1,45}";
  private static final String USER_PASSWORD_REGEXP = ".{5,45}";
  private static final String USER_NAME_REGEXP = "\\p{Alpha}{1,45}";
  private static final String USER_EMAIL_REGEXP =
      "^\\w{0,14}(\\.|\\-?)\\w{0,14}@\\w{3,14}\\.\\p{Lower}{2,3}$";
  private static final String USER_PHONE_NUMBER_REGEXP = "^\\+\\d{2,3}\\s\\d{2,3}\\s\\d{7}";
  private static final String USER_ADDRESS_REGEXP = ".{5,45}";
  private static UserValidatorImpl instance = new UserValidatorImpl();

  private UserValidatorImpl() {}

  public static UserValidatorImpl getInstance() {
    return instance;
  }

  @Override
  public boolean validatePassword(String password) {
    if (password == null) {
      return false;
    }
    return password.matches(USER_PASSWORD_REGEXP);
  }

  @Override
  public boolean validateEmail(String eMail) {
    if (eMail == null) {
      return false;
    }
    return eMail.matches(USER_EMAIL_REGEXP);
  }

  @Override
  public boolean validatePhoneNumber(String phoneNumber) {
    if (phoneNumber == null) {
      return false;
    }
    return phoneNumber.matches(USER_PHONE_NUMBER_REGEXP);
  }

  @Override
  public boolean validateUserName(String userName) {
    if (userName == null) {
      return false;
    }
    return userName.matches(USER_NAME_REGEXP);
  }

  @Override
  public boolean validateLastName(String lastName) {
    if (lastName == null) {
      return false;
    }
    return lastName.matches(USER_LAST_NAME_REGEXP);
  }
}
