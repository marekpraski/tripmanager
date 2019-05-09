package pl.edu.agh.mwo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class TripTest {

	@Test
	public void testConstructor() {
		Trip trip = new Trip("nazwa", "opis");
		assertEquals("nazwa", trip.getName());
		assertEquals("opis", trip.getDescription());
	}

	@Test
    public void addPhotoToTripTest() {
        Trip trip = new Trip("nazwa", "opis");
	    trip.addPhotoToTrip(new Photo("super photo"), "nazwa");
	    trip.addPhotoToTrip(new Photo("extra"), "nazwa");
	    assertEquals(2,trip.getTripPhotos("nazwa").size());
    }
    @Test
    public void setNameTest() {
        Trip trip = new Trip("nazwa", "opis");
        trip.setName("new name");
        assertEquals("new name", trip.getName());
    }
    @Test
    public void setDescriptionTest() {
        Trip trip = new Trip("nazwa", "opis");
        trip.setDescription("new description");
        assertEquals("new description",trip.getDescription());

    }

    @Test
    public void getNameTest() {
        Trip trip = new Trip("nazwa wycieczki", "opis");
        assertEquals("nazwa wycieczki", trip.getName());
    }


    @Test
    public void getDescription() {
        Trip trip = new Trip("nazwa wycieczki", "opis jakiś");
        assertEquals("opis jakiś", trip.getDescription());
    }


    @Test
    public void getTripPhotos() {
        Trip trip = new Trip("nazwa", "opis");
        Trip trip1 = new Trip("nazwa1", "opis1");
        trip.addPhotoToTrip(new Photo("super photo"), "nazwa");
        trip.addPhotoToTrip(new Photo("extra"), "nazwa");
        trip1.addPhotoToTrip(new Photo("super photo1"), "nazwa1");
        trip1.addPhotoToTrip(new Photo("extra1"), "nazwa1");
        trip1.addPhotoToTrip(new Photo("extra11"), "nazwa1");
        assertEquals(2,trip.getTripPhotos("nazwa").size());
        assertEquals(3,trip1.getTripPhotos("nazwa1").size());
    }
}
