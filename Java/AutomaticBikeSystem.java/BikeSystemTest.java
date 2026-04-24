import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeSystemTest{


    @Test
    public void CheckIfBikeIsOn(){
        int bikeStatus =0;
        assertEquals(BikeSystem.turnOnBike(bikeStatus), 1);
    }


    @Test
    public void CheckIfBikeIsOff(){
        int bikeStatus =1;
        assertEquals(BikeSystem.turnOffBike(bikeStatus), 0);
    }

    @Test
    public void tesThatSpeedIncreasedByOne_WhenBikeisOn(){
        int bikeStatus =1;
        int currentSpeed =0;
        assertEquals(BikeSystem.accelerate(bikeStatus, currentSpeed), 1);
    } 

    @Test
    public void testThatAccelerateMethodReturnsAnError_WhenBikeisOff(){
        int bikeStatus =0;
        int currentSpeed =32;
        assertEquals(BikeSystem.accelerate(bikeStatus, currentSpeed), -1);
    } 

    @Test
    public void tesThatSpeedDecreaseByOne_WhenBikeisOn(){
        int bikeStatus =1;
        int currentSpeed =32;
        assertEquals(BikeSystem.deccelerate(bikeStatus, currentSpeed), 31);
    } 

    @Test
    public void testThatDecreaseMethodReturnsAnError_WhenBikeisOff(){
        int bikeStatus =0;
        int currentSpeed =32;
        assertEquals(BikeSystem.deccelerate(bikeStatus, currentSpeed), -1);
    }

    @Test
    public void testThatGearSpeedIsCategorizedProperly(){
        int bikeStatus =1;
        int currentSpeed =78;
        assertEquals(BikeSystem.identifyCurrentGearSpeed(bikeStatus, currentSpeed), 4);
        currentSpeed =32;
        assertEquals(BikeSystem.identifyCurrentGearSpeed(bikeStatus, currentSpeed), 3);
        currentSpeed =27;
        assertEquals(BikeSystem.identifyCurrentGearSpeed(bikeStatus, currentSpeed), 2);
        currentSpeed =3;
        assertEquals(BikeSystem.identifyCurrentGearSpeed(bikeStatus, currentSpeed), 1);
        bikeStatus =0;
        assertEquals(BikeSystem.identifyCurrentGearSpeed(bikeStatus, currentSpeed), -1);  
       
    }
}
