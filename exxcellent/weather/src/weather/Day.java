package weather;

/**
 * Eine Klasse, deren Objekte Tage eines Monats mittels repräsentieren. Jeder Tag hat
 * eine Tagesnummer, eine Maximaltemperatur und eine Minimaltemperatur.
 * @author Lennart Schneider
 *
 */
public class Day {
private int dayNumber;
private int maxTemp;
private int minTemp;

/**
 * Neuer Kunstruktor: Zuerst die Zahl des Tages im Monat, danach die maximale Temperatur an diesem Tag und
 * zueletzt die minimale Temperatur an diesem Tag.
 * 
 * @param dayNum :  Zahl des Tages im Monat
 * @param maxT : maximale Temperatur des Tages
 * @param minT : minimale Temperatur des Tages
 */
public Day(int dayNumber, int maxTemp, int minTemp) {
	assert dayNumber>=0 : "Monate haben keine negativen Tage";
	assert dayNumber<=31 : "Monate haben nicht mehr als 31 Tage";
	this.dayNumber = dayNumber;
	this.maxTemp = maxTemp;
	this.minTemp = minTemp;
}

public int getDayNumber() {
	return dayNumber;
}

public int getMaxTemp() {
	return maxTemp;
}

public int getMinTemp() {
	return minTemp;
}

}
