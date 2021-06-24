import java.util.Random;

public abstract class Media extends Post {

    protected String[] extensions;

    public Media(String author, String date, String message, String type){
        super(author, date, message, type);
        this.maxSize = 40;
    }

    public abstract String[] getExtensions();

    public void printRandomExtension(){
        int random = new Random().nextInt(extensions.length - 1 );
        System.out.println("Random extension for message " + getMessage() + " is " + extensions[random]);
    }

    @Override
    public int getMaxRecordSize() {
        return this.maxSize;
    }
}
