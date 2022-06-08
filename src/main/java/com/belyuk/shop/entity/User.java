package com.belyuk.shop.entity;

public class User extends AbstractEntity {
  private int userId;
  private UserStatus userStatus;
  private String lastName;
  private String name;
  private String password;
  private String eMail;
  private String phoneNumber;

  public User() {
  }

  public User(int userId, UserStatus userStatus, String lastName, String name, String password, String eMail, String phoneNumber) {
    this.userId = userId;
    this.userStatus = userStatus;
    this.lastName = lastName;
    this.name = name;
    this.password = password;
    this.eMail = eMail;
    this.phoneNumber = phoneNumber;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public UserStatus getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(UserStatus userStatus) {
    this.userStatus = userStatus;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String geteMail() {
    return eMail;
  }

  public void seteMail(String eMail) {
    this.eMail = eMail;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (userId != user.userId) return false;
    if (userStatus != user.userStatus) return false;
    if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
    if (name != null ? !name.equals(user.name) : user.name != null) return false;
    if (password != null ? !password.equals(user.password) : user.password != null) return false;
    if (eMail != null ? !eMail.equals(user.eMail) : user.eMail != null) return false;
    return phoneNumber != null ? phoneNumber.equals(user.phoneNumber) : user.phoneNumber == null;
  }

  @Override
  public int hashCode() {
    int result = userId;
    result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
    result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("userId=").append(userId);
    sb.append(", userStatus=").append(userStatus);
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", eMail='").append(eMail).append('\'');
    sb.append(", phoneNumber='").append(phoneNumber).append('\'');
    sb.append('}');
    return sb.toString();
  }

}
