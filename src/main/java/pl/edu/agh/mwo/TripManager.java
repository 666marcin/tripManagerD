package pl.edu.agh.mwo;
import java.util.*;

public class TripManager {
	private HashMap<String,Trip> tripList;
	
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

	public Map<String, Trip> find(String keyword) {
		
		if (keyword == "") return tripList;
		
		Map<String, Trip>  findedTrips = new HashMap<String, Trip>();
		
		for  (String name : tripList.keySet()) {
			if (name.contains(keyword)) {
				findedTrips.put(name, tripList.get(name));
			}
			else if (tripList.get(name).getDescription().contains(keyword)) {
				findedTrips.put(name, tripList.get(name));
			} else {
				for (Photo p : tripList.get(name).getPhotos()) {
					if (p.getComment().contains(keyword)) {
						findedTrips.put(name, tripList.get(name));
					}
				}
			}
		}
		return findedTrips;
	}
}
