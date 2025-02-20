package lab2;

import java.awt.*;


public abstract class Vehicle implements Movable {
    protected int nrDoors = 0; // Number of doors on the car
    protected double enginePower = 0.0; // Engine power of the car
    protected double currentSpeed = 0.0; // The current speed of the car
    protected Color color = null; // Color of the car
    protected double[] position = {0,0}; //X, Y positioning
    protected int direction = 0; //0 = North, 1 = East, 2 = South, 3 = West
    protected String modelName;
    protected boolean engineOn = false;

    public Vehicle(String modelName, int nrDoors, Color color, double enginePower, double[] startingPosition){
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.position = startingPosition;
        stopEngine();
    }

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
    }
    private int changeDirection(int dir, int i){return (4 + dir + i) % 4;}
    public void turnLeft(){
        direction = changeDirection(direction, -1);
    }
    public void turnRight(){
        direction = changeDirection(direction, 1);
    }

    public double[] getPosition(){
        return position;
    }

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    public double speedFactor(){
        return enginePower * 0.01;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){color = clr;}

    public void startEngine(){
        currentSpeed = 0.1;
        engineOn = true;
    }

    public void stopEngine(){
        currentSpeed = 0;
        engineOn = false;
    }

    public String getModelName(){return modelName;}

    public void gas(double amount){
        if(amount <= 1 && amount>0 && engineOn){
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Too much gas");
        }
    }

    public void brake(double amount){
        if (amount <= 1 && amount >0){
            decrementSpeed(amount);
        }else{
            throw new IllegalArgumentException("Too much brake");
        }
    }
}
