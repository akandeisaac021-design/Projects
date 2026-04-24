public class BikeSystem{

    public static int turnOnBike(int bikeStatus){

        if (bikeStatus ==0){
            bikeStatus =1;
        }

        return bikeStatus;
    }

    
    public static int turnOffBike(int bikeStatus){

        if (bikeStatus ==1){
            bikeStatus =0;
        }

        return bikeStatus;
    }

    public static int accelerate(int bikeStatus, int currentSpeed){

        if (bikeStatus ==1){
            return currentSpeed + 1;
        }
        return -1;
    }
    


    public static int deccelerate(int bikeStatus, int currentSpeed){

        if (bikeStatus ==1){
            if (currentSpeed ==0){return -1}
            return currentSpeed - 1;
        }
        return -1;
    }
    

    public static int identifyCurrentGearSpeed(int bikeStatus, int currentSpeed){

        if (bikeStatus ==1){
            if (currentSpeed >0 && currentSpeed <21){return 1;}
            else if (currentSpeed >20 && currentSpeed <31){return 2;}
            else if (currentSpeed >30 && currentSpeed <41){return 3;}
            else{return 4;}
        }
        return -1;
    }





}
