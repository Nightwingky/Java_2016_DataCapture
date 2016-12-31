package com.nightwingky.vo;

/**
 * Created by nightwingky on 16-12-30.
 */

public class ContentVO {

    private String contentImageURL;
    private String contentTitle;
    private String contentPrice;

    public ContentVO() {
    }

    public ContentVO(String contentImageURL, String contentTitle, String contentPrice) {
        this.contentImageURL = contentImageURL;
        this.contentTitle = contentTitle;
        this.contentPrice = contentPrice;
    }

    public String getContentImageURL() {
        return contentImageURL;
    }

    public void setContentImageURL(String contentImageURL) {
        this.contentImageURL = contentImageURL;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentPrice() {
        return contentPrice;
    }

    public void setContentPrice(String contentPrice) {
        this.contentPrice = contentPrice;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                "contentImageURL='" + contentImageURL + '\'' +
                ", contentTitle='" + contentTitle + '\'' +
                ", contentPrice='" + contentPrice + '\''
        );

        return stringBuilder.toString();
    }
}
