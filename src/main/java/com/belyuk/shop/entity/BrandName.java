package com.belyuk.shop.entity;

public class BrandName extends AbstractEntity {
  private String name;

  public BrandName(int id) {
    super(id);
  }

  public BrandName() {}

  public BrandName(String name) {
    this.name = name;
  }
}
