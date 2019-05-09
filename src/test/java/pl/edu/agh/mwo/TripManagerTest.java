package pl.edu.agh.mwo;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip;
    Trip trip1;
	Trip trip2;
	
	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
		trip1 = new Trip("super fajna nazwa", "ciekawy opis");
		trip2 = new Trip("nowa", "fajny i ciekawy opis");
	}
	
	@Test
	public void testAdd() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
        tripManager.add(trip1);
		assertEquals(2, tripManager.getTrips().size());
	}

	@Test(expected = TripAlreadyExistsException.class)
	public void testAddTripTwice() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.add(trip);
	}

	@Test
	public void testRemoveTrip() throws Exception {
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
		tripManager.remove(trip.getName());
		assertEquals(0, tripManager.getTrips().size());
		//fail("chcemy zespuc");
		}

    @Test
    public void testfindTripNull() throws TripAlreadyExistsException {
        tripManager.add(trip);
        tripManager.add(trip1);
        tripManager.add(trip2);
        Map<String, Trip> foundTrips;
        foundTrips = tripManager.findTrip("");
        assertEquals(3,foundTrips.size() );
    }

    @Test
    public void testfindTripByName() throws TripAlreadyExistsException {
        tripManager.add(trip);
        tripManager.add(trip1);
        tripManager.add(trip2);
        Map<String, Trip> foundTrips;
        foundTrips = tripManager.findTrip("nazwa");
        assertEquals(2,foundTrips.size() );
    }
    @Test
    public void testfindTripByDesc() throws TripAlreadyExistsException {
        tripManager.add(trip);
        tripManager.add(trip1);
        tripManager.add(trip2);
        Map<String, Trip> foundTrips;
        foundTrips = tripManager.findTrip("opis");
        assertEquals(3, foundTrips.size());
    }
        @Test
        public void testfindTripByNameAndDesc() throws TripAlreadyExistsException {
            tripManager.add(trip);
            tripManager.add(trip1);
            tripManager.add(trip2);
            Map<String, Trip> foundTrips;
            foundTrips = tripManager.findTrip("fajn");
            assertEquals(2,foundTrips.size() );
        }
    }
