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
	public void testAddPhoto() {
		Trip trip = new Trip("nazwa", "opis");
		Photo photo = new Photo();
		Photo photo2 = new Photo();
		assertEquals(0, trip.getPhotos().size());
		trip.addPhoto(photo);
		assertEquals(1, trip.getPhotos().size());
		trip.addPhoto(photo2);
		assertEquals(2, trip.getPhotos().size());
	}

	@Test
	public void testSetDescription() {
		Trip trip = new Trip("nazwa", "opis");
		trip.setDescription("inny opis");
		assertEquals("inny opis", trip.getDescription());
	}
	
	@Test
	public void testSetName() {
		Trip trip = new Trip("nazwa", "opis");
		trip.setName("inna nazwa");
		assertEquals("inna nazwa", trip.getName());
	}
	
}
