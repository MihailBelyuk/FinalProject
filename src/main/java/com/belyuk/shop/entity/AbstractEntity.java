package com.belyuk.shop.entity;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
  private int id;

  public AbstractEntity(int id) {
    this.id = id;
  }

  public AbstractEntity() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AbstractEntity that = (AbstractEntity) o;

    return id == that.id;
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("AbstractEntity{");
    sb.append("id=").append(id);
    sb.append('}');
    return sb.toString();
  }
}
