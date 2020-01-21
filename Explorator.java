package appli;

import lejos.hardware.Button;
import lejos.utility.Delay;
import lejos.utility.Stopwatch;

public class Explorator {
	private Sensor sensors;
	private Drive driver;
	
	public Explorator(Sensor s, Drive d) {
		sensors = s;
		driver = d;
	}
	
	public void explorer() {
    	driver.avancer();
        while ((driver.getMoteurGauche().isMoving() || driver.getMoteurDroit().isMoving())) {
        	if(sensors.distanceRight >= 0.60 && sensors.distanceRight >= 0.60) {
        		driver.stop();
            	break;
        	}
        	if (sensors.distanceRight > 0.2 && sensors.distanc) {//Une porte a �t� trouv�e � droite
        		driver.quartDeTourDroite();
        		driver.avancer();
            } else if (sensors.touchValue == 1) {//Un obstacle frontal � �t� rencontr�
            	driver.reculer();
            	driver.decidePress();
            } else if (sensors.distanceLeft > 0.04) {//Une porte � �t� trouv�e a gauche
            	driver.quartDeTourGauche();
            	driver. avancer();
            } else {
        
            }
        }
        Button.waitForAnyPress();
        driver.close();
        sensors.close();
    }
}
