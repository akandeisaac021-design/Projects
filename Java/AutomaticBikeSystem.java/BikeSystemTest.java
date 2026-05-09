 import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BikeSystemTest {

    @BeforeEach
    public void setUp(){
        BikeSystem myBike = new BikeSystem();
    }

    @Test
    public void testTurnOnBike() {

        myBike.turnOnBike();
        assertTrue(myBike.getBikeStatus());
        assertEquals(1, myBike.getCurrentGear());
    }

    @Test
    public void testAccelerateIncreasesSpeedByGearValue() {

        myBike.turnOnBike();
        
        myBike.accelerate();
        assertEquals(1, myBike.getCurrentSpeed());
        
    }

    @Test
    public void testDecelerateDecreasesSpeedByGearValue() {
        myBike.turnOnBike();
        
        for(int count= 0; count< 22; count++) { myBike.accelerate(); } 
        
        int speedBefore = myBike.getCurrentSpeed();
        int gearBefore = myBike.getCurrentGear();
        
        myBike.deccelerate();
        assertEquals(speedBefore - gearBefore, myBike.getCurrentSpeed());
    }
}

