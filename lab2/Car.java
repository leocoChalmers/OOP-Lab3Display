package lab2;

import java.awt.*;

public abstract class Car extends Vehicle{
    public Car(String modelName, int nrDoors, Color color, double enginePower, double[] startingPosition){
        super(modelName,nrDoors,color,enginePower,startingPosition);
    }
}
