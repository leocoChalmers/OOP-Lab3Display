package lab2;

import java.awt.*;
import java.util.ArrayList;

public class Saab95Workshop extends Workshop {
    private ArrayList<Saab95> vehicleSpots = new ArrayList<>();

    public Saab95Workshop(int spotsAvailable) {
        super(spotsAvailable);
    }
}