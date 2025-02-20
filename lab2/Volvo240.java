package lab2;
import java.awt.*;

public class Volvo240 extends Car
{
    final static double trimFactor = 1.25;

    public Volvo240(double[] startingPosition){
        super("Volvo240", 4,Color.black, 100, startingPosition);
        stopEngine();
    }
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
