import lab2.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Workshop> workshops = new ArrayList<>();
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Scania());

        cc.workshops.add(new Saab95Workshop(5));
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getPosition()[0]);
                int y = (int) Math.round(vehicle.getPosition()[1]);

                if (0 <= x && x < frame.drawPanel.getWidth() && 0 <= y && y < frame.drawPanel.getHeight()){
                    frame.drawPanel.moveit(x,y,vehicle);
                }
                else{
                    stop();
                    start();
                    turnRight();
                    turnRight();
                    while(x<0 || y<0){
                        vehicle.move();
                        x = (int) Math.round(vehicle.getPosition()[0]);
                        y = (int) Math.round(vehicle.getPosition()[1]);
                    }
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }

            if (Math.abs(frame.drawPanel.saab95Point.getX() - frame.drawPanel.saab95WorkshopPoint.getX()) <= 5 ||
                    Math.abs(frame.drawPanel.saab95Point.getY() - frame.drawPanel.saab95WorkshopPoint.getY()) <= 5){



                }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles)
            vehicle.gas(gas);
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles)
            vehicle.brake(brake);
    }
    void turboOn(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOn();
        }
    }
    void turboOff(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOff();
        }
    }
    void liftBed(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania)
                ((Scania) vehicle).raiseBedAngle();
        }

    }
    void lowerBed(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania)
                ((Scania) vehicle).lowerBedAngle();
        }
    }
    void turnRight(){
        for (Vehicle vehicle : vehicles){
            vehicle.turnRight();
        }
    }
    void turnLeft(){
        for (Vehicle vehicle : vehicles){
            vehicle.turnLeft();
        }
    }
    void start(){
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }
    void stop(){
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }
}
