package weather;

import java.util.List;

/**
 * Vorgesehen zum Lesen einer Datei mit Wetterdaten. Stellt die Tage fest, an denen die Temperaturdifferenz 
 * am gerinsten war und gibt diese an.
 * 
 * @author Lennart Schneider
 *
 */
public interface Reader {
	/**
	 * @param path : Der Pfad der Datei
	 * @return Liefert eine Liste mit den gesuchten Tagen zurück.
	 */
	public List<Integer> readFile(String path);
}
