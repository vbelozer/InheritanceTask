package main;

import main.abstracts.Post;
import main.interfaces.IPrintable;

public class TextPost extends Post implements IPrintable {

    private String additionalInfo;

    public TextPost(String author, String date, String message, PostTypes type) {
        super(author, date, message, type);
        this.maxSize = 10;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(String info) {
        this.additionalInfo = info;
    }

    public String addAdditionalInfoToMessage() {
        return getMessage()+ getAdditionalInfo();
    }

    @Override
    public int getMaxRecordSize() {
        return this.maxSize;
    }

    public void print() {
        System.out.println("Text with additional info is printed: " + addAdditionalInfoToMessage());
    }

}
