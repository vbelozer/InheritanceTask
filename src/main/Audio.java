package main;

public class Audio extends Media implements IPlayable {

    private int lengthInSec;

    public Audio(String author, String date, String message, PostTypes type, int lengthInSec) {
        super(author, date, message, type);
        this.extensions = new String[] {"mp3", "mp4"};
        this.lengthInSec = lengthInSec;
    }

    @Override
    public String[] getExtensions(){
        return extensions;
    }

    public int getLengthInSec() {
        return lengthInSec;
    }

    public int getLenthFromSecToMin() {
        return getLengthInSec() / 60;
    }

    @Override
    public int getMaxRecordSize() {
        return this.maxSize + 10;
    }

    public void play() {
        System.out.println("Play: " + this.getExtensions());
    }
}
