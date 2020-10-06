package com.san22.api_fetch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {
    @SerializedName("images")
    @Expose
    private String images;

    @SerializedName("id")
    @Expose
    private String id;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
