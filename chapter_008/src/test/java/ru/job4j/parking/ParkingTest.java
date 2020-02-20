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
import org.junit.Test;

/**
 * Класс ParkungTest -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.02.20
 */
public class ParkingTest {
    private static final Logger LOG = LogManager.getLogger(ParkingTest.class.getName());

    @Test
    public void whenWePutCatAndTruckUntillParkingIsFull() {

        Vehicle car1 = new PassengerCar("Ford");
        Vehicle car2 = new PassengerCar("Toyota");
        Vehicle car3 = new PassengerCar("BMW");
        Parking<Vehicle> park = new PublicParking<>(3, 2);
        park.in(car1);
        park.in(car2);
        park.in(car3);
        Assert.assertEquals(2, park.getEmprySpace());
        Vehicle car4 = new Lorry("KAMAZ");
        park.in(car4);
        Assert.assertEquals(1, park.getEmprySpace());
        car4 = new Lorry("ZIL");
        park.in(car4);
        Assert.assertEquals(0, park.getEmprySpace());
    }

    @Test
    public void whenWePutAndPollvehicle() {
        Vehicle car1 = new PassengerCar("Ford");
        Vehicle car2 = new Lorry("KAMAZ");
        Parking<Vehicle> park = new PublicParking<>(3, 2);
        park.in(car1);
        park.in(car2);
        Assert.assertEquals(3, park.getEmprySpace());
        park.out(car1.getNumber());
        park.out(car2.getNumber());
        Assert.assertEquals(5, park.getEmprySpace());
    }

    @Test
    public void whenUseStandartParking() {
        Vehicle car1 = new PassengerCar("Ford");
        Vehicle car2 = new PassengerCar("Toyota");
        Vehicle car3 = new PassengerCar("BMW");
        car1.setSize(2);
        Parking<Vehicle> parkLots = new Parkings<>(7);
        parkLots.in(car1);
        parkLots.in(car2);
        parkLots.in(car3);
        Assert.assertEquals(3, parkLots.getEmprySpace());
    }

    @Test
    public void whenUseLimuzin() {
        Vehicle car1 = new PassengerCar("LimuzinCadellac");
        Vehicle car2 = new PassengerCar("Toyota");
        Vehicle car3 = new PassengerCar("BMW");
        car1.setSize(5);
        Parking<Vehicle> parkLots = new Parkings<>(7);
        parkLots.in(car1);
        parkLots.in(car2);
        parkLots.in(car3);
        Assert.assertEquals(0, parkLots.getEmprySpace());
        car1 = parkLots.out("LimuzinCadellac");
        Assert.assertEquals(5, parkLots.getEmprySpace());
    }

    @Test
    public void whenCarToBig() {
        Vehicle car1 = new Lorry("KAMAZ");
        Parking<Vehicle> smallParking = new Parkings<>(1);
        boolean answer = smallParking.in(car1);
        Assert.assertEquals(1, smallParking.getEmprySpace());
        Assert.assertFalse(answer);
    }
}
