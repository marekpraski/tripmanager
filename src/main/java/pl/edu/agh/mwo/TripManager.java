package pl.edu.agh.mwo;
import java.util.*;

public class TripManager {
	private HashMap<String,Trip> tripList;
	private HashMap<String, Trip> foundTrips;
	
	public TripManager() {
		tripList = new HashMap<String,Trip>();
	}
	
	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			throw new TripAlreadyExistsException();
		}
		else {
			tripList.put(trip.getName(),trip);
		}
	}
	
	public HashMap<String,Trip> getTrips() {
		return tripList;
	}

	public void remove(String name) {
		tripList.remove(name);
	}

	public Map<String,Trip> findTrip(String keyWord) {
		foundTrips = new HashMap();
		if (keyWord=="")
		    foundTrips=tripList;
		else {
            findTripsByName(keyWord);
            findTripsByDescription(keyWord);
            findTripsByPictureDescription();
        }
	    return foundTrips;
    }

    private void findTripsByPictureDescription() {

    }

    private void findTripsByDescription(String keyWord) {
	    Map<String, String> tripDescriptions = new HashMap();
	    for (String name : tripList.keySet()) {
	        String tripDescription = new String();
	        tripDescription = tripList.get(name).getDescription();
	        tripDescriptions.put(name, tripDescription);
        }
	    for (String name : tripDescriptions.keySet()) {
	        if (tripDescriptions.get(name).contains(keyWord))
	            foundTrips.put(name, tripList.get(name));
        }
    }

    private void findTripsByName(String keyWord) {
	    for (String name : tripList.keySet()) {
	        if (name.contains(keyWord))
	            foundTrips.put(name,tripList.get(name));
        }
    }
}
