package lab2;

import java.awt.*;

abstract class Truck extends Vehicle{
    protected int bedAngle = 0;

    public Truck(String modelName, int nrDoors, Color color, double enginePower, double[] startingPosition){
        super(modelName,nrDoors,color,enginePower, startingPosition);
    }
    protected void changeBedAngle(int amount){
        if (currentSpeed == 0.0){
            if (0 <= bedAngle + amount && bedAngle + amount <= 70)
                bedAngle += amount;
            else
                throw new IllegalArgumentException("Angle can't be below 0 or over 70 degrees");
        }
        else
            throw new IllegalArgumentException("Can't move while changing bed angle");
    }
    public void raiseBedAngle(){
            changeBedAngle(Math.abs(7));
    }
    public void lowerBedAngle(){
            changeBedAngle(-7);
    }
    public int getBedAngle(){
        return bedAngle;
    }
    @Override
    public void gas(double amount){
        if (bedAngle == 0){
            if(amount <= 1 && amount>0)
                incrementSpeed(amount);
            else
                throw new IllegalArgumentException("Too much gas");
        }
        else
            throw new IllegalArgumentException("bedAngle is not 0");
    }
}
