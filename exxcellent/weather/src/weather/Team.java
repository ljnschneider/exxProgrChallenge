package weather;

/**
 * Eine Klasse, deren Objekte Fuﬂballteams repr‰sentieren. Jedes Team hat
 * einen Namen, eine Anzahl an erzielten Toren und eine Anzahl an zugelassenen Toren.
 * @author Lennart Schneider
 *
 */
public class Team {
private String name;
private int goalsScored;
private int goalsAllowed;

/**
 * Neuer Kunstruktor: Zuerst der Teamname, danach die erzielten Tore und zueletzt die zugelassenen Tore.
 * 
 * @param dayNum :  Zahl des Tages im Monat
 * @param maxT : maximale Temperatur des Tages
 * @param minT : minimale Temperatur des Tages
 */
public Team(String name, int goalsScored, int goalsAllowed) {
	this.name = name;
	this.goalsScored = goalsScored;
	this.goalsAllowed = goalsAllowed;
}

public String getName() {
	return name;
}

public int getMaxTemp() {
	return goalsScored;
}

public int getMinTemp() {
	return goalsAllowed;
}

}
