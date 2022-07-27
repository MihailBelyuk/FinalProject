package com.belyuk.shop.command.constant;

public enum AttributeParameterName {
  ;
  // attributes
  // user
  public static final String USER_ID_ATTR = "user_id";
  public static final String USER_ROLE_ATTR = "user_role";
  public static final String LAST_NAME_ATTR = "last_name";
  public static final String NAME_ATTR = "name";
  public static final String PASSWORD_ATTR = "password";
  public static final String EMAIL_ATTR = "e_mail";
  public static final String PHONE_NUMBER_ATTR = "phone_number";
  public static final String ALL_USERS_ATTR = "all_users";
  public static final String REGISTRATION_SUCCESSFUL_ATTR = "registration_successful";
  public static final String EMPTY_LAST_NAME_ATTR = "empty_last_name";
  public static final String WRONG_INPUT_LAST_NAME_ATTR = "wrong_input_last_name";
  public static final String EMPTY_NAME_ATTR = "empty_name";
  public static final String WRONG_INPUT_NAME_ATTR = "wrong_input_name";
  public static final String EMPTY_PASSWORD_ATTR = "empty_password";
  public static final String WRONG_INPUT_PASSWORD_ATTR = "wrong_input_password";
  public static final String EMPTY_E_MAIL_ATTR = "empty_email";
  public static final String WRONG_INPUT_E_MAIL_ATTR = "wrong_input_email";
  public static final String EMPTY_PHONE_NUMBER_ATTR = "empty_phone_number";
  public static final String WRONG_INPUT_PHONE_NUMBER_ATTR = "wrong_input_phone_number";
  public static final String LOGGED_USER_PAGE_ATTR = "logged_user_page";
  public static final String LOGGED_USER_ATTR = "logged_user";
  public static final String LOGOUT_ATTR = "logout";
  public static final String LOGIN_MSG_ATTR = "login_msg";
  public static final String USER_EXISTS_ATTR = "user_exists";

  // item
  public static final String ALL_ITEMS_ATTR = "all_items";
  public static final String FIELDS_MUST_BE_FILLED_ATTR = "fields_must_be_filled";
  public static final String ITEMS_IN_CART_ATTR = "items_in_cart";
  public static final String SEARCH_ITEMS_ATTR = "search_items";
  public static final String NO_MATCHING_ITEMS_ATTR = "no_matching_items";
  public static final String OUT_OF_STOCK_ATTR="out_of_stock";

  // common
  public static final String CURRENT_PAGE_ATTR = "current_page";
  public static final String LOCALIZATION_ATTR = "localization";

  // cart
  public static final String CART_ATTR = "cart";

  // parameters
  // user
  public static final String COMMAND = "command";
  public static final String RU_PARAMETER = "ru";
  public static final String EN_PARAMETER = "en";
  public static final String LOCALE_PARAM = "locale_param";
  public static final String USER_ID_PARAM = "userId";
  public static final String USER_ROLE_PARAM = "role";
  public static final String LAST_NAME_PARAM = "last_name";
  public static final String NAME_PARAM = "name";
  public static final String PASSWORD_PARAM = "password";
  public static final String EMAIL_PARAM = "e_mail";
  public static final String PHONE_NUMBER_PARAM = "phone_number";

  // item
  public static final String ITEM_CATEGORY = "item_category";
  public static final String BRAND = "brand";
  public static final String ITEM_NAME = "item_name";
  public static final String DESCRIPTION = "description";
  public static final String STOCK = "stock";
  public static final String PICTURE = "picture";
  public static final String PRICE = "price";
  public static final String SEARCH = "search";

  //cart
  public static final String ITEMS_IN_CART="items_in_cart";
  public static final String EMPTY_CART="empty_cart";
}
