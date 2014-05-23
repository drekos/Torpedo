package teszt;

import static org.junit.Assert.*;
import osztalyok.Jatekosok;
import osztalyok.Koordinatak;

/**
 * JUnit teszteket tartalmazó osztály.
 * 
 * @author Dreko
 */
public class Teszt {

	/**
	 * Játékosok teljesítményének tesztelése.
	 */
	@org.junit.Test
	public void testTeljesitmeny() {
		Jatekosok jatekos = new Jatekosok("Feri", 7, 8);
		double elvart = (double) 7 / 8;

		assertEquals(String.valueOf(elvart),
				String.valueOf(jatekos.getTeljesitmeny()));
	}

	/**
	 * Játékosok toString() metódusának tesztelése.
	 */
	@org.junit.Test
	public void testJatekos() {
		Jatekosok jatekos = new Jatekosok("Feri", 7, 8);
		String toString = "Jatekosok [nev=Feri, kilottHajok=7, tippekSzama=8teljesitmeny=0.875]";

		assertEquals(toString, jatekos.toString());
	}

	/**
	 * Koordináták toString() metódusának tesztelése.
	 */
	@org.junit.Test
	public void testKoordinatak() {
		Koordinatak koordinatak = new Koordinatak(2, 5);
		String toString = "Koordinatak [sor=2, oszlop=5]";

		assertEquals(toString, koordinatak.toString());
	}
}
