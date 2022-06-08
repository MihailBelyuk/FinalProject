package com.belyuk.shop.service.validator;

public interface UserValidator {
  boolean validateLogin(String surname);

  boolean validatePassword(String password);

  boolean validateEmail(String eMail);

  boolean validatePhoneNumber(String phoneNumber);

  boolean validateAddress(String address);

  boolean validateUserName(String userName);
}
