package org.sang.healthyfoodmvp.model;

/**
 * Created by 王松 on 2016/10/8.
 */

public class FoodEntity {
    private String img;
    private String keywords;
    private String description;

    public FoodEntity() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodEntity(String img, String keywords, String description) {
        this.img = img;
        this.keywords = keywords;
        this.description = description;
    }
}
