package lab2;

import java.awt.*;

public class Scania extends Truck
{
    public Scania(double[] startingPosition){
        super("Scania",2, Color.pink, 770, startingPosition);
        stopEngine();
    }
}
