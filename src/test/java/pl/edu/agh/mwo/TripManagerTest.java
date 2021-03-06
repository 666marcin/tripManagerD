package pl.edu.agh.mwo;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip, trip2;
	Photo photo1, photo2;
	
	@Before
	public void setUp() {
		tripManager = new TripManager();
		trip = new Trip("nazwa", "opis");
	}
	
	@Test
	public void testAdd() throws TripAlreadyExistsException {
		assertEquals(0, tripManager.getTrips().size());
		tripManager.add(trip);
		assertEquals(1, tripManager.getTrips().size());
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
	public void testFindTrip() throws Exception {
		tripManager.add(trip);
		HashMap<String,Trip> tripList = tripManager.getTrips();
		assertEquals(tripList, tripManager.find(trip.getName()));
	}
	
	@Test
	public void testFindTripUsingEmptyString() throws Exception {
		tripManager.add(trip);
		tripManager.add(new Trip("beskidy", "beskid niski"));
		tripManager.find("");
		assertEquals(2, tripManager.getTrips().size());
	}

	@Test
	public void testFindTripUsingEmptyStringOnEmptyTripList() throws Exception {
		tripManager.find("");
		assertEquals(0, tripManager.getTrips().size());
	}
	
	@Before
	public void setUp2() {
		trip2 = new Trip("California Side", "USA");
		photo1 = new Photo();
		photo1.setComment("selfie1");
		photo2 = new Photo();
		photo2.setComment("selfie2");
		trip2.addPhoto(photo1);
		trip2.addPhoto(photo2);
	}

	@Test
	public void testFindTripUsingKeywornInName() throws TripAlreadyExistsException {
		tripManager.add(trip2);
		assertEquals(1, tripManager.find("California").size());
	}

	@Test
	public void testFindTripUsingKeywornInTripDesctiption() throws TripAlreadyExistsException {
		tripManager.add(trip2);
		assertEquals(1, tripManager.find("USA").size());
	}

	@Test
	public void testFindTripUsingKeywornInPhotoComment() throws TripAlreadyExistsException {
		tripManager.add(trip2);
		assertEquals(1, tripManager.find("self").size());
	}
	
}
