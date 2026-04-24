public class ACSystem{

    public static int putOnTheAC(int aCStatus){

        if (aCStatus =0){

            aCStatus++;

        }
            return aCStatus;
    }


    public static int putOffTheAC(int aCStatus){
        
        if (acStatus =1){

            aCStatus--;

        }
        return aCStatus;
    }

    public static void decreaseTheACTemperature(int ACTemperature){

        if (ACTemperature >16){

            ACTemperature--;

        }
        return ACTemperature;
    }


    public static void IncreaseTheACTemperature(int ACTemperature){
    
        if (ACTemperature <30){

        ACTemperature++;

        }

        return ACTemperature;

    }

    public static void DecreaseACToMinimumTemperature{

        if (ACTemperature >16){

            int changeNeededToReduceTheTemperatureToTheMinimum =16 - ACTemperature;
        
            ACTemperature +=changeNeededToReduceTheTemperatureToTheMinimum;

        }

        return ACTemperature;

    }

    public static void IncreaseACToaximumTemperature(int ACTemperature){}

        if (ACTemperature <30){

            int changeNeededToMaxTheTemperature =30 - ACTemperature;

            ACTemperature +=changeNeededToMaxTheTemperature;
            
        }

    return ACTemperature;
    }

}
