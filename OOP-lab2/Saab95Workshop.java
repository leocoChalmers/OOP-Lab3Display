import java.awt.*;
import java.util.ArrayList;

public class Saab95Workshop extends Workshop
{
    private ArrayList<Saab95> vehicleSpots = new ArrayList<>();
    public Saab95Workshop(int spotsAvailable){
        super(spotsAvailable);

    }

    public void loadVehicle(Saab95 saab95){
        if(spotsAvailable > 0){
            vehicleSpots.add(saab95);
            spotsAvailable--;
        }
        else
            throw new IllegalArgumentException("Car is not saab95");
    }

}
