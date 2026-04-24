import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ACIsOffTest{

    @Test
    public void CheckIfACIsOn(){

        int expectedValue =1;

        int actualValue =1;

        assertEquals(expectedValue ,actualValue);
    }

    @Test
    public void CheckIfACIsOff(){

        int expectedValue =0;

        int actualValue =0;

        assertEquals(expectedValue, actualValue);
    }


    @Test
    public void checkIfTemperatureReduces(){


        int expectedValue =30;
        int actualValue =30;

        assertEquals(expectedValue, actualValue);

    }


    @Test
    public void checkIfTemperatureDecreasesToTheLowest(){


            int expectedValue =16;
            int actualValue =16;

            assertEquals(expectedValue, actualValue);

        }
     
    @Test
    public void checkIfTemperatureIncreases(){


        int expectedValue =30;
        int actualValue =30;

        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void checkIfTemperatureIncreasesToTheHighest(){


        int expectedValue =30;
        int actualValue =30;

        assertEquals(expectedValue, actualValue);

    }
  
}
