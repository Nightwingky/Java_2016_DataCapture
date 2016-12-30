package com.nightwingky.vo;

/**
 * Created by nightwingky on 16-12-30.
 */

public class ContentVO {

    private String newsIconUrl;
    private String newsTitle;
    private String newsContent;

    public ContentVO() {
    }

    public ContentVO(String newsIconUrl, String newsTitle, String newsContent) {
        this.newsIconUrl = newsIconUrl;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    public String getNewsIconUrl() {
        return newsIconUrl;
    }

    public void setNewsIconUrl(String newsIconUrl) {
        this.newsIconUrl = newsIconUrl;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                "newsIconUrl='" + newsIconUrl + '\'' +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\''
        );

        return stringBuilder.toString();
    }
}
