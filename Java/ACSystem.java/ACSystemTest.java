import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ACSystemTest {

    private ACSystem myAc;

    @BeforeEach
    public void setUp(){
        myAc = new ACSystem();
    }

    @Test
    public void test_ACStartsAsOff(){

        assertFalse(myAc.isOn());
    }

    @Test
    public void test_TurnOnAC(){
        myAc.putOnTheAC();
        assertTrue(myAc.isOn());
    }

    @Test
    public void testThatDecreaseTemperature_UpdatesState(){

        myAc.putOnTheAC();
        myAc.IncreaseTheaCTemperature(); 
        myAc.decreaseTheaCTemperature();
        assertEquals(16, myAc.getTemperature());
    }

    @Test
    public void testThatTemperatureDoesNotChange_WhenACOff(){

        myAc.decreaseTheaCTemperature();
        assertEquals(0, myAc.getTemperature());
    }


    @Test
    public void testThatIncreaseToMax(){

        myAc.putOnTheAC();
        myAc.IncreaseACToMaximumTemperature();
        assertEquals(31, myAc.getTemperature());
    }

    @Test
    public void testThatTemperatureCannotGoBelow16(){
        myAc.putOnTheAC();
        myAc.decreaseTheaCTemperature();
        assertEquals(16, myAc.getTemperature());
    }

    @Test
    public void testThatTemperatureCannotGoAbove31(){
        myAc.putOnTheAC();
        myAc.IncreaseACToMaximumTemperature();
        myAc.IncreaseTheaCTemperature();
        assertEquals(31, myAc.getTemperature()); 
    }
    
    @Test
    public void test_TurningACOff_ResetTemperatureToZero(){
        myAc.putOnTheAC();
        myAc.putOffTheAC();
        assertEquals(0, myAc.getTemperature());
    }

    @Test
    public void test_TurningACOn_SetsToDefault24(){
        myAc.putOnTheAC();
        assertEquals(24, myAc.getTemperature());
    }

}

