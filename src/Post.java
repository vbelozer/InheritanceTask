public abstract class Post {

    protected int maxSize;
    private String author;
    private String date;
    private String message;
    private String type;
    //private String type = (new String[] {"post", "repost", "comment"})[]

    public Post(String author, String date, String message, String type){
        this.author = author;
        this.date = date;
        this.message = message;
        this.type = type;
    }

    public String getAuthor(){
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public void showContent(){
        System.out.println("Author is " + this.getAuthor());
        System.out.println("Date is " + this.getDate());
        System.out.println("Message is " + this.getMessage());
        System.out.println("Type is " + this.getType());
    }

    public abstract int getMaxRecordSize();
}
