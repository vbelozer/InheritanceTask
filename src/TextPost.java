public class TextPost extends Post {

    private String additionalInfo;

    public TextPost(String author, String date, String message, String type){
        super(author, date, message, type);
        this.maxSize = 10;
    }

    public String getAdditionalInfo(){
        return this.additionalInfo;
    }

    public void setAdditionalInfo(String info){
        this.additionalInfo = info;
    }

    public String addAdditionalInfoToMessage(){
        return getMessage()+ getAdditionalInfo();
    }

    @Override
    public int getMaxRecordSize() {
        return this.maxSize;
    }

}
