public class ACSystem{

    private int aCTemperature =0;
    private boolean isACOn =false;

    public void putOnTheAC(){

        if (!isACOn){
            isACOn =true;
            aCTemperature =24;

        }
    }


    public void putOffTheAC(){
        
        if (isACOn){

            isACOn =false;
            aCTemperature =0;

        }
    }

    public void decreaseTheaCTemperature(){

        if (isACOn){
            if (aCTemperature >16){

                aCTemperature -=1;
            }
        }
    }


    public void IncreaseTheaCTemperature(){
    
        if (isACOn){
            if (aCTemperature <31){

                aCTemperature +=1;
            }
        }
    }

    public void DecreaseACToMinimumTemperature(){

        if(isACOn){

            if (aCTemperature >16){

                aCTemperature -=(aCTemperature - 16);
            

            }
        }
    }

    public void IncreaseACToMaximumTemperature(){

        if (isACOn){

            if (aCTemperature <31){

                aCTemperature +=(31 - aCTemperature);               
            }
        }

    }

    public int getTemperature() {
        return aCTemperature;
    }

    public boolean isOn() {
        return isACOn;
    }

}
