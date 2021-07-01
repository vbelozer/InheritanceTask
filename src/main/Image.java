package main;

public class Image extends Media implements IPrintable {

    private int resizeCoefficient;

    public Image(String author, String date, String message, PostTypes type, int resizeCoefficient) {
        super(author, date, message, type);
        this.extensions = new String[] {"jpeg", "png", "jpg"};
        this.resizeCoefficient = resizeCoefficient;
    }

    public int getResizeCoefficient() {
        return resizeCoefficient;
    }

    public void setResizeCoefficient(int resizeCoefficient) {
        this.resizeCoefficient = resizeCoefficient;
    }

    public void resizeImage() {
        System.out.println("The image was resized with coefficient " + getResizeCoefficient());
    }

    @Override
    public String[] getExtensions() {
        return extensions;
    }

    @Override
    public int getMaxRecordSize() {
        return this.maxSize;
    }

    public void print() {
        System.out.println("Image is printed: " + this.getMessage());
    }
}
