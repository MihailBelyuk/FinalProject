package com.belyuk.shop.entity.service.validator;

/** The interface User validator. */
public interface UserValidator {

  /**
   * Validate password boolean.
   *
   * @param password the password
   * @return the boolean
   */
  boolean validatePassword(String password);

  /**
   * Validate email boolean.
   *
   * @param eMail the e mail
   * @return the boolean
   */
  boolean validateEmail(String eMail);

  /**
   * Validate phone number boolean.
   *
   * @param phoneNumber the phone number
   * @return the boolean
   */
  boolean validatePhoneNumber(String phoneNumber);

  /**
   * Validate user name boolean.
   *
   * @param userName the user name
   * @return the boolean
   */
  boolean validateUserName(String userName);

  /**
   * Validate last name boolean.
   *
   * @param lastName the last name
   * @return the boolean
   */
  boolean validateLastName(String lastName);
}
