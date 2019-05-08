package pl.edu.agh.mwo;

import java.util.*;

public class Trip {
	private String name;
	private String description;
	private Map<String, List<Photo>> photoSet = new HashMap();
	
	public Trip(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addPhotoToTrip(Photo photo, String tripName) {
        List<Photo> tripPhotos;
	    if (photoSet.containsKey(tripName)) {
            tripPhotos = photoSet.get(tripName);
            tripPhotos.add(photo);
        }
        else {
            tripPhotos = new ArrayList();
            tripPhotos.add(photo);
            photoSet.put(tripName,tripPhotos);
        }

    }
    public List<Photo> getTripPhotos(String tripName) {
	    return photoSet.get(tripName);
    }
}
