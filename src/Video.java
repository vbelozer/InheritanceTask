public class Video extends Media {

    private boolean soundOn;

    public Video(String author, String date, String message, String type, boolean soundOn) {
        super(author, date, message, type);
        this.extensions = new String[]{"avi", "mov", "mpg"};
        this.soundOn = soundOn;
    }

    public boolean getSoundOn(){
        return soundOn;
    }

    public void changeSoundToOff(){
        if (getSoundOn()){
            soundOn = false;
            System.out.println("Sound was deactivated for " + this.getMessage());
        }
    }

    @Override
    public String[] getExtensions(){
        return extensions;
    }

    @Override
    public int getMaxRecordSize() {
        return this.maxSize + 70;
    }
}
