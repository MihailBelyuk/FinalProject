package com.belyuk.shop.entity;

import java.math.BigDecimal;
import java.sql.Blob;

public class Item extends AbstractEntity {
  private String name;
  private BrandName brandName;
  private ItemCategory itemCategory;
  private BigDecimal price;
  private boolean inStock;

  public Item(int id) {
    super(id);
  }

  public Item() {
    super();
  }
public Item(String name,BrandName brandName,ItemCategory itemCategory,BigDecimal price,boolean inStock){
    this.name = name;
    this.brandName = brandName;
    this.itemCategory = itemCategory;
    this.price = price;
    this.inStock=inStock;
}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BrandName getBrandName() {
    return brandName;
  }

  public void setBrandName(BrandName brandName) {
    this.brandName = brandName;
  }

  public ItemCategory getItemCategory() {
    return itemCategory;
  }

  public void setItemCategory(ItemCategory itemCategory) {
    this.itemCategory = itemCategory;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public boolean isInStock() {
    return inStock;
  }

  public void setInStock(boolean inStock) {
    this.inStock = inStock;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Item item = (Item) o;

    if (inStock != item.inStock) return false;
    if (name != null ? !name.equals(item.name) : item.name != null) return false;
    if (brandName != null ? !brandName.equals(item.brandName) : item.brandName != null) return false;
    if (itemCategory != item.itemCategory) return false;
    return price != null ? price.equals(item.price) : item.price == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
    result = 31 * result + (itemCategory != null ? itemCategory.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    result = 31 * result + (inStock ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Item{");
    sb.append("name='").append(name).append('\'');
    sb.append(", brandName=").append(brandName);
    sb.append(", itemCategory=").append(itemCategory);
    sb.append(", price=").append(price);
    sb.append(", inStock=").append(inStock);
    sb.append('}');
    return sb.toString();
  }
}
