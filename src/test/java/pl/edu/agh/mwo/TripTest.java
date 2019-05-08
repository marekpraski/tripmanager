package pl.edu.agh.mwo;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

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

}
