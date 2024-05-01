package test;

import Ca2GroupProject.MyHashMap;
import Ca2GroupProject.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class HashMapTest {

    @Test
    public void testGetExistingPatient() {
        // Arrange
        MyHashMap hashMap = new MyHashMap();
        LocalDate dob = LocalDate.of(1990, 5, 15);
        LocalDate joinedDate = LocalDate.of(2020, 1, 1);
        Patient patient = new Patient("Billy", "Bob", dob, joinedDate);
        String key = "BillyBob";
        hashMap.put(key, patient);

        // Act
        Patient retrievedPatient = hashMap.get(key);

        // Assert
        Assertions.assertEquals(patient, retrievedPatient);
    }

    @Test
    public void testGetNonExistingPatient() {
        // Arrange
        MyHashMap hashMap = new MyHashMap();
        String key = "JohnDoe";

        // Act
        Patient retrievedPatient = hashMap.get(key);

        // Assert
        Assertions.assertNull(retrievedPatient);
    }

    @Test
    public void testGetNullKey() {
        // Arrange
        MyHashMap hashMap = new MyHashMap();
        LocalDate dob = LocalDate.of(1990, 5, 15);
        LocalDate joinedDate = LocalDate.of(2020, 1, 1);
        Patient patient = new Patient("John", "Doe", dob, joinedDate);
        String key = null;
        hashMap.put("JohnDoe", patient);

        // Act
        Patient retrievedPatient = hashMap.get(key);

        // Assert
        Assertions.assertNull(retrievedPatient);
    }

    @Test
    public void testPutNewPatient() {
        // Arrange
        MyHashMap hashMap = new MyHashMap();
        LocalDate dob = LocalDate.of(1990, 5, 15);
        LocalDate joinedDate = LocalDate.of(2020, 1, 1);
        Patient patient = new Patient("John", "Doe", dob, joinedDate);
        String key = "JohnDoe";

        // Act
        Patient oldPatient = hashMap.put(key, patient);

        // Assert
        Assertions.assertNull(oldPatient);
        Assertions.assertEquals(patient, hashMap.get(key));
    }

    @Test
    public void testPutWithCollision() {
        // Arrange
        MyHashMap hashMap = new MyHashMap();
        LocalDate dob1 = LocalDate.of(1990, 5, 15);
        LocalDate joinedDate1 = LocalDate.of(2020, 1, 1);
        LocalDate dob2 = LocalDate.of(1985, 8, 20);
        LocalDate joinedDate2 = LocalDate.of(2019, 12, 31);
        Patient patient1 = new Patient("John", "Doe", dob1, joinedDate1);
        Patient patient2 = new Patient("Jane", "Smith", dob2, joinedDate2);
        String key1 = "JohnDoe";
        String key2 = "JaneSmith";

        // Act
        hashMap.put(key1, patient1);
        hashMap.put(key2, patient2);

        // Assert
        Assertions.assertEquals(patient1, hashMap.get(key1));
        Assertions.assertEquals(patient2, hashMap.get(key2));
    }

    @Test
    public void testRemoveExistingPatient() {
        // Arrange
        MyHashMap hashMap = new MyHashMap();
        LocalDate dob = LocalDate.of(1990, 5, 15);
        LocalDate joinedDate = LocalDate.of(2020, 1, 1);
        Patient patient = new Patient("John", "Doe", dob, joinedDate);
        String key = "JohnDoe";
        hashMap.put(key, patient);

        // Act
        Patient removedPatient = hashMap.remove(key);

        // Assert
        Assertions.assertEquals(patient, removedPatient);
        Assertions.assertNull(hashMap.get(key));
    }

    @Test
    public void testRemoveNonExistingPatient() {
        // Arrange
        MyHashMap hashMap = new MyHashMap();
        String key = "JohnDoe";

        // Act
        Patient removedPatient = hashMap.remove(key);

        // Assert
        Assertions.assertNull(removedPatient);
    }

}