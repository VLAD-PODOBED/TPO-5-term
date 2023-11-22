import Planes.*;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AirportTest {

    private static List<Plane> planes = Arrays.asList(
            // ... (unchanged)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean hasTransportMilitaryPlanes = transportMilitaryPlanes.stream()
                .anyMatch(plane -> plane.getType() == MilitaryType.TRANSPORT);
        Assert.assertTrue(hasTransportMilitaryPlanes);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity, planeWithMaxPassengerCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        boolean isSorted = isListSortedByMaxLoadCapacity(planesSortedByMaxLoadCapacity);
        Assert.assertTrue(isSorted);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean hasBomberMilitaryPlanes = bomberMilitaryPlanes.stream()
                .anyMatch(plane -> plane.getType() == MilitaryType.BOMBER);
        Assert.assertTrue(hasBomberMilitaryPlanes);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified() {
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = experimentalPlanes.stream()
                .anyMatch(plane -> plane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED);
        Assert.assertFalse(hasUnclassifiedPlanes);
    }

    private boolean isListSortedByMaxLoadCapacity(List<? extends Plane> planes) {
        for (int i = 0; i < planes.size() - 1; i++) {
            Plane currentPlane = planes.get(i);
            Plane nextPlane = planes.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                return false;
            }
        }
        return true;
    }
}
