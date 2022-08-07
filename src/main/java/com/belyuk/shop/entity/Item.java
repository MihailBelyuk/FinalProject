package com.belyuk.shop.entity;

<<<<<<< HEAD
import java.io.Serial;
import java.math.BigDecimal;
import java.util.Arrays;

public class Item extends AbstractEntity {

  @Serial
  private static final long serialVersionUID = 1L;
  private ItemCategory itemCategory;
  private String brandName;
  private byte[] imageBytes;
=======
import java.io.InputStream;
import java.math.BigDecimal;

public class Item extends AbstractEntity {

  private ItemCategory itemCategory;
  private String brandName;
  private InputStream picture;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
  private String name;
  private String description;
  private BigDecimal price;
  private boolean inStock;
  private String encodedImage;

  public Item(int id) {
    super(id);
  }

  public Item() {
    super();
  }

  public Item(
      ItemCategory itemCategory,
      String brandName,
<<<<<<< HEAD
      byte[] imageBytes,
=======
      InputStream picture,
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
      String name,
      String description,
      BigDecimal price,
      boolean inStock) {
    this.itemCategory = itemCategory;
    this.brandName = brandName;
<<<<<<< HEAD
    this.imageBytes = imageBytes;
    this.name = name;
    this.description = description;
=======
    this.picture=picture;
    this.name = name;
    this.description=description;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
    this.price = price;
    this.inStock = inStock;
  }

  public ItemCategory getItemCategory() {
    return itemCategory;
  }

  public void setItemCategory(ItemCategory itemCategory) {
    this.itemCategory = itemCategory;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

<<<<<<< HEAD
  public byte[] getImageBytes() {
    return imageBytes;
  }

  public void setImageBytes(byte[] imageBytes) {
    this.imageBytes = imageBytes;
=======
  public InputStream getPicture() {
    return picture;
  }

  public void setPicture(InputStream picture) {
    this.picture = picture;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public String getEncodedImage() {
    return encodedImage;
  }

  public void setEncodedImage(String encodedImage) {
    this.encodedImage = encodedImage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Item item = (Item) o;

    if (inStock != item.inStock) return false;
    if (itemCategory != item.itemCategory) return false;
    if (brandName != null ? !brandName.equals(item.brandName) : item.brandName != null) return false;
<<<<<<< HEAD
    if (!Arrays.equals(imageBytes, item.imageBytes)) return false;
    if (name != null ? !name.equals(item.name) : item.name != null) return false;
    if (description != null ? !description.equals(item.description) : item.description != null) return false;
    if (price != null ? !price.equals(item.price) : item.price != null) return false;
    return encodedImage != null ? encodedImage.equals(item.encodedImage) : item.encodedImage == null;
=======
    if (picture != null ? !picture.equals(item.picture) : item.picture != null) return false;
    if (name != null ? !name.equals(item.name) : item.name != null) return false;
    if (description != null ? !description.equals(item.description) : item.description != null) return false;
    return price != null ? price.equals(item.price) : item.price == null;
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (itemCategory != null ? itemCategory.hashCode() : 0);
    result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
<<<<<<< HEAD
    result = 31 * result + Arrays.hashCode(imageBytes);
=======
    result = 31 * result + (picture != null ? picture.hashCode() : 0);
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    result = 31 * result + (inStock ? 1 : 0);
    result = 31 * result + (encodedImage != null ? encodedImage.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Item{");
    sb.append("itemCategory=").append(itemCategory);
<<<<<<< HEAD
    sb.append(", brandName='").append(brandName).append('\'');
    sb.append(", imageBytes=").append(Arrays.toString(imageBytes));
=======
    sb.append(", brandName=").append(brandName);
    sb.append(", picture='").append(picture).append('\'');
>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2
    sb.append(", name='").append(name).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", price=").append(price);
    sb.append(", inStock=").append(inStock);
    sb.append(", encodedImage='").append(encodedImage).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
