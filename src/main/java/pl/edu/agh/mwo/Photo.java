package pl.edu.agh.mwo;

public class Photo {
    private String comment;
    Photo(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
