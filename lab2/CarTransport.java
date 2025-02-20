package lab2;

import java.awt.*;

public class CarTransport<T extends Car> extends Truck implements Loadable<T>
{
    Vehicle[] vehicleSpots = new Vehicle[5];
    public CarTransport(double[] startingPosition) {
        super("CarTransport", 2, Color.blue, 630, startingPosition);
    }

    @Override
    public void raiseBedAngle(){
        if (bedAngle == 0 && currentSpeed == 0.0){
            bedAngle = 70;
        }
    }
    @Override
    public void lowerBedAngle(){
        if (bedAngle == 70 && currentSpeed == 0.0){
            bedAngle = 0;
        }
    }

    @Override
    public void loadVehicle(T vehicle) {
        if (bedAngle == 70 && vehicle.modelName != "CarTransport") {
            if (Math.abs(vehicle.position[0]-position[0])<=10 && Math.abs(vehicle.position[1]-position[1])<=10){
                for (int i = 0; i < vehicleSpots.length; i++){
                    if (vehicleSpots[i] == null){
                        vehicleSpots[i] = vehicle;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void unloadVehicle(){
        if (bedAngle == 70){
            for (int i = vehicleSpots.length-1; i >= 0; i--){
                if (vehicleSpots[i] != null){
                    vehicleSpots[i].position[0] = position[0]-10-i;
                    vehicleSpots[i].position[1] = position[1]-10-i;
                    vehicleSpots[i] = null;
                    return;
                }
            }
        }
    }


    @Override
    public void move(){
        switch (direction){
            case 0:
                position[1] += currentSpeed;
                break;
            case 1:
                position[0] += currentSpeed;
                break;
            case 2:
                position[1] -= currentSpeed;
                break;
            case 3:
                position[0] -= currentSpeed;
                break;
        }
        for (Vehicle vehicleSpot : vehicleSpots) {
            vehicleSpot.position = position;
            return;
        }
    }
}
