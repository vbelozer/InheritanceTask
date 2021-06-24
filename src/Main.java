public class Main {
    public static void main(String[] args){

        final Post post1 = new TextPost("Vika", "29.01.2021", "Hi!", "Repost");
        final Media post2 = new Image("Vika", "29.02.2021", "Text", "Comment", 4);
        final Media post3 = new Video("Ne Vika", "29.05.2020","It is video", "Comment", true);
        final Media post4 = new Audio("Ne Vika", "29.05.2010","It is audio", "Comment", 120);

        for (Post post: new Post[] {post1, post2, post3}){
            post.showContent();
            post.getMaxRecordSize();
            System.out.println("Max record size is " + post.getMaxRecordSize()+ " Mb");
            System.out.println();
        }

        //
        ((TextPost)post1).setAdditionalInfo(" -> This info is to be added in the end to the message");
        System.out.println("The new message: " + ((TextPost) post1).addAdditionalInfoToMessage());

        //
        ((Image) post2).printRandomExtension();

        //
        System.out.println("The audio length in min is " + ((Audio)post4).getLenthFromSecToMin() + " min");
        ((Audio) post4).printRandomExtension();

        //
        for (Media media: new Media[] {post2, post3, post4}){
            media.printRandomExtension();
            System.out.println();
        }

        //
        ((Video) post3).changeSoundToOff();

        //
        ((Image) post2).setResizeCoefficient(3);
        ((Image) post2).resizeImage();
    }
}
