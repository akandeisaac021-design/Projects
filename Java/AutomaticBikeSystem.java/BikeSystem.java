public class BikeSystem{

    private int currentSpeed;
    private int currentGear;
    private boolean isBikeOn;

    public void turnOnBike(){

        if (!isBikeOn){
            isBikeOn =true;
            currentGear =1;
        }
    }

    
    public void turnOffBike(){

        if (isBikeOn){
            isBikeOn =false;
            currentGear =0;
        }
    }

    public void accelerate(){

        if (isBikeOn){
            currentSpeed +=getCurrentGear();
        }
    }
    

    public void deccelerate(){

        if (isBikeOn && currentSpeed >0){
                currentSpeed -=getCurrentGear();
        }
    }
    

    public void identifyCurrentGearSpeed(){

        if (isBikeOn) {
            if (currentSpeed >=0 && currentSpeed <= 20) currentGear =1;
            if (currentSpeed >= 21 && currentSpeed <= 30) currentGear =2;
            if (currentSpeed >= 31 && currentSpeed <= 40) currentGear =3;
            if (currentSpeed >= 41) currentGear =4;
        }
    }

    public int getCurrentSpeed(){return currentSpeed;}

    public int getCurrentGear(){
        identifyCurrentGearSpeed();
        return currentGear;
    }

    public boolean getBikeStatus(){return isBikeOn;}    

}
