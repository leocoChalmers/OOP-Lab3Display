package lab2;
import java.util.ArrayList;

public class Workshop<T extends Car> implements Loadable<T> {
    private ArrayList<T> vehicleSpots = new ArrayList<>();
    protected int spotsAvailable;

    public Workshop(int spotsAvailable){
        this.spotsAvailable = spotsAvailable;
    }
    public int getAvailableSpots(){
        return spotsAvailable - vehicleSpots.size();
    }

    @Override
    public void loadVehicle(T vehicle){
        if(vehicleSpots.size() < spotsAvailable)
                vehicleSpots.add(vehicle);
        else
            System.out.println("No spots available");
    }
    public void unloadVehicle(){
        if (!vehicleSpots.isEmpty()) {
            System.out.println(vehicleSpots.getFirst().modelName);
            vehicleSpots.removeFirst();

        }
        else{
            System.out.println("No car in the workshop");
        }
    }
    public boolean isInWorkshop(Vehicle _vehicle){
        for(Vehicle vehicle: vehicleSpots){
            if (vehicle.getClass().equals(_vehicle.getClass()))
                return true;
        }
        return false;
    }
}
