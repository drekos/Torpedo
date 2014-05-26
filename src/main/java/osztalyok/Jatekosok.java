package osztalyok;

/**
 * Játékosokat reprezentáló osztály.
 * 
 * @author Dreko
 */
public class Jatekosok {
	/**
	 * Játékos neve.
	 */
	private String nev;
	/**
	 * Játékos által kilőtt hajók száma egy csata alatt.
	 */
	private int kilottHajok;
	/**
	 * A játék befejeztével a játékos tippeinek száma.
	 */
	private int tippekSzama;
	/**
	 * Játékos teljesítménye a játék alatt.
	 */
	private double teljesitmeny;

	/**
	 * Visszadja a játékos nevét.
	 * 
	 * @return a játékos neve
	 */
	public String getNev() {
		return nev;
	}

	/**
	 * Beállítja a játékos nevét.
	 * 
	 * @param nev
	 *            a játékos új neve
	 */
	public void setNev(String nev) {
		this.nev = nev;
	}

	/**
	 * Visszaadja a játékos által kilőtt hajók számát.
	 * 
	 * @return kilőtt hajók száma
	 */
	public int getKilottHajok() {
		return kilottHajok;
	}

	/**
	 * Beállítja a játékos által kilőtt hajók számát.
	 * 
	 * @param kilottHajok
	 *            száma
	 */
	public void setKilottHajok(int kilottHajok) {
		this.kilottHajok = kilottHajok;
	}

	/**
	 * Visszaadja a játékos tippjeinek számát.
	 * 
	 * @return játékos tippjeinek száma
	 */
	public int getTippekSzama() {
		return tippekSzama;
	}

	/**
	 * Beállítja a játékos tippjeinek számát.
	 * 
	 * @param tippekSzama a játékos tippeinek száma
	 */
	public void setTippekSzama(int tippekSzama) {
		this.tippekSzama = tippekSzama;
	}

	/**
	 * Visszaadja a játékos adatainak String reprezentációját.
	 * 
	 * @return String reprezentáció
	 */
	@Override
	public String toString() {
		return "Jatekosok [nev=" + nev + ", kilottHajok=" + kilottHajok
				+ ", tippekSzama=" + tippekSzama + "teljesitmeny="
				+ teljesitmeny + "]";
	}

	/**
	 * Játékost megalkotó konstruktor.
	 * 
	 * @param nev
	 *            játékos neve
	 * @param kilottHajok
	 *            kilőtt hajók száma
	 * @param tippekSzama
	 *            tippek száma
	 */
	public Jatekosok(String nev, int kilottHajok, int tippekSzama) {
		super();
		this.nev = nev;
		this.kilottHajok = kilottHajok;
		this.tippekSzama = tippekSzama;
		this.teljesitmeny = (double) kilottHajok / (double) tippekSzama;
	}

	/**
	 * Visszaadja a játékos teljesítményét.
	 * 
	 * @return a játékos teljesítménye
	 */
	public double getTeljesitmeny() {
		return teljesitmeny;
	}
}
