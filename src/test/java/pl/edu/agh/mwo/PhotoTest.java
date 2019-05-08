package pl.edu.agh.mwo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PhotoTest {
    @Test
    public void getCommentTest() {
        Photo photo = new Photo("super comment");
        assertEquals("super comment", photo.getComment());
    }
    @Test
    public void setCommetTest() {
        Photo photo = new Photo("comment");
        photo.setComment("changed comment");
        assertEquals("changed comment", photo.getComment());
    }

}
