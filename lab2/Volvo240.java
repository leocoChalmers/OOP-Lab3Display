package lab2;
import java.awt.*;

public class Volvo240 extends Car
{
    final static double trimFactor = 1.25;

    public Volvo240(){
        super("Volvo240", 4,Color.black, 100);
        stopEngine();
    }
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
