package com.nightwingky.vo;

/**
 * Created by nightwingky on 17-1-1.
 */
public class ItemDescriptionVO {

    private String itemContentTitle;
    private String itemPicURL;
    private String itemDescription;

    public ItemDescriptionVO() {
    }

    public ItemDescriptionVO(String itemContentTitle, String itemPicURL, String itemDescirption) {
        this.itemContentTitle = itemContentTitle;
        this.itemPicURL = itemPicURL;
        this.itemDescription = itemDescirption;
    }

    public String getItemContentTitle() {
        return itemContentTitle;
    }

    public void setItemContentTitle(String itemContentTitle) {
        this.itemContentTitle = itemContentTitle;
    }

    public String getItemPicURL() {
        return itemPicURL;
    }

    public void setItemPicURL(String itemPicURL) {
        this.itemPicURL = itemPicURL;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ItemDescriptionVO{" +
                "itemContentTitle='" + itemContentTitle + '\'' +
                ", itemPicURL='" + itemPicURL + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                '}');

        return stringBuilder.toString();
    }
}
