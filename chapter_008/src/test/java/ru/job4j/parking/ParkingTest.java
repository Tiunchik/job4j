/**
 * Пакет ru.job4j.parking для
 *
 * @author Maksim Tiunchik
 */
package ru.job4j.parking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;

/**
 * Класс ParkungTest -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since -
 */
public class ParkingTest {
    private static final Logger LOG = LogManager.getLogger(ParkingTest.class.getName());

    @Ignore
    public void WhenWePutCat() {

        Vehicle car1 = new PassengerCar("Ford");
        Vehicle car2 = new PassengerCar("Toyota");
        Vehicle car3 = new PassengerCar("BMW");
        Parking<Vehicle> park = new PublicParking(3, 2);
        park.in(car1);
        park.in(car2);
        park.in(car3);
        Assert.assertEquals(2, park.getEmprySpace());
        Vehicle car4 = new Lorry("KAMAZ");
        park.in(car4);
        Assert.assertEquals(1, park.getEmprySpace());

    }
}
