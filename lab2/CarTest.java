/*package lab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class CarTest {
  Saab95 saab = new Saab95();
  Volvo240 volvo = new Volvo240();
  Scania scania = new Scania();
  CarTransport ct = new CarTransport();
  Workshop w = new Workshop(1);
  Saab95Workshop sw = new Saab95Workshop(2);

  @Test
  public void testWorkshop(){
    w.loadVehicle(volvo);
    Assertions.assertEquals(0, w.getAvailableSpots());
    w.loadVehicle(saab);
    Assertions.assertEquals(0, w.getAvailableSpots());
    w.unloadVehicle();
    Assertions.assertEquals(1, w.getAvailableSpots());
  }

 @Test
 public void testSaab95Workshop(){
      sw.loadVehicle(saab);
      Assertions.assertEquals(1, sw.getAvailableSpots());
 }

  @Test
  public void testCarTransport(){
      ct.raiseBedAngle();
      ct.loadVehicle(saab);
      ct.lowerBedAngle();
      ct.startEngine();
      ct.gas(0.3);
      ct.move();
      ct.unloadVehicle();
      Assertions.assertEquals(1.99,ct.getPosition()[1]);
      Assertions.assertEquals(1.99, saab.getPosition()[1]);

  }

  @Test
    public void testDoors(){
      Assertions.assertEquals(2, saab.getNrDoors());

      Assertions.assertEquals(4, volvo.getNrDoors());
  }
  @Test
  public void testColor(){
    Assertions.assertEquals(Color.red, saab.getColor());

    Assertions.assertEquals(Color.black, volvo.getColor());

  }
  @Test
  public void testEnginePower(){
    Assertions.assertEquals(125, saab.getEnginePower());

    Assertions.assertEquals(100, volvo.getEnginePower());
  }

  @Test
  public void testSpeedWithTurbo(){
      saab.setTurboOn();
      saab.startEngine();
      saab.gas(1);
      Assertions.assertEquals(1.725, saab.getCurrentSpeed());
      saab.setTurboOff();
      saab.brake(1);
      saab.brake(1);
      saab.gas(1);
      Assertions.assertEquals(1.25, saab.getCurrentSpeed());
  }

  @Test
  public void testMoveSaab() {
      saab.startEngine();
      for (int i = 0; i < 100; i++) {
          saab.gas(1);
      }
      saab.move();
      Assertions.assertEquals(125, saab.getPosition()[1]);
      saab.stopEngine();
      saab.startEngine();
      saab.gas(1);
      saab.gas(1);
      saab.gas(1);
      saab.gas(1);
      saab.gas(1);
      Assertions.assertThrows(IllegalArgumentException.class, () -> saab.gas(2));

      saab.move();
      Assertions.assertEquals(125 + 6.35, saab.getPosition()[1]);
  }
@Test
public void testMoveVolvo(){
    volvo.startEngine();
    for (int i=0; i<100; i++){
        volvo.gas(1);
    }
    volvo.move();
    Assertions.assertEquals(100, volvo.getPosition()[1]);
    volvo.stopEngine();
    volvo.startEngine();
    volvo.gas(1);
    volvo.gas(1);
    volvo.gas(1);
    volvo.gas(1);
    volvo.gas(1);
    Assertions.assertThrows(IllegalArgumentException.class, () -> volvo.gas(2));
    volvo.move();
    Assertions.assertEquals(100 + 6.35,volvo.getPosition()[1]);
}


  @Test
  public void testBrakeSaab() {
      saab.startEngine();
      saab.brake(0.75);
      Assertions.assertEquals(0, saab.getCurrentSpeed());
  }

  @Test
  public void testBrakeVolvo(){
      volvo.startEngine();
      volvo.brake(0.75);
      Assertions.assertEquals(0, volvo.getCurrentSpeed());
  }


  @Test
  public void testTurnSaab() {
      saab.startEngine();
      saab.gas(1);
      saab.turnLeft();
      saab.move();
      Assertions.assertEquals(-1.35, saab.getPosition()[0]);
  }

    @Test
    public void testTurnVolvo(){
    volvo.startEngine();
    volvo.gas(1);
    volvo.turnLeft();
    volvo.move();
    Assertions.assertEquals(-1.35, volvo.getPosition()[0]);
  }

 @Test
   public void testScaniaBedAngle(){
    scania.raiseBedAngle();
    scania.lowerBedAngle();
    Assertions.assertEquals(0, scania.getBedAngle());
    scania.startEngine();
    scania.gas(1);
    Assertions.assertEquals(7.8,scania.getCurrentSpeed());
    scania.brake(1);
    scania.brake(1);
    scania.raiseBedAngle();
    Assertions.assertEquals(7,scania.getBedAngle());
  }
}

*/