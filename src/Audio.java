public class Audio extends Media {

    private int lengthInSec;

    public Audio(String author, String date, String message, String type, int lengthInSec) {
        super(author, date, message, type);
        this.extensions = new String[] {"mp3", "mp4"};
        this.lengthInSec = lengthInSec;
    }

    @Override
    public String[] getExtensions(){
        return extensions;
    }

    public int getLengthInSec(){
        return lengthInSec;
    }

    public int getLenthFromSecToMin(){
        return getLengthInSec() / 60;
    }

    @Override
    public int getMaxRecordSize() {
        return this.maxSize + 10;
    }
}
