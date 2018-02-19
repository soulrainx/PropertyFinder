package test.propertyfinder.com.propertyfinder.propertylist.Model;


import com.google.gson.annotations.SerializedName;

/**
 * Entity Class representing a Property
 */
public class Property {


    Integer id;

    String thumbnail;

    String thumbnail_big;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail_big() {
        return thumbnail_big;
    }

    public void setThumbnail_big(String thumbnail_big) {
        this.thumbnail_big = thumbnail_big;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageCount() {
        return imageCount;
    }

    public void setImageCount(String imageCount) {
        this.imageCount = imageCount;
    }

    public String getPrice_value() {
        return price_value;
    }

    public void setPrice_value(String price_value) {
        this.price_value = price_value;
    }

    public int getPrice_value_raw() {
        return price_value_raw;
    }

    public void setPrice_value_raw(int price_value_raw) {
        this.price_value_raw = price_value_raw;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    String price;

    int bathrooms;

    int bedrooms;

    String category_id;

    String title;

    String subject;

    String type;

    String imageCount;

    String price_value;

    int price_value_raw;

    String currency;

    @SerializedName("lat")
    Float latitude;

    @SerializedName("long")
    Float longitude;
}
