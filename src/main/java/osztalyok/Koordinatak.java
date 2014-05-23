package osztalyok;

/**
 * Koordinátákat reprezentáló osztály.
 * 
 * @author Dreko
 */
public class Koordinatak {
	/**
	 * Koordináta sor értéke.
	 */
	private int sor;
	/**
	 * Koordináta oszlop értéke.
	 */
	private int oszlop;
	
	/**
	 * Visszadja a koordináta sor értékét.
	 * 
	 * @return sor érték
	 */
	public int getSor() {
		return sor;
	}
	
	/**
	 * Beállítja a koordináta sor értékét.
	 * 
	 * @param sor új sor érték
	 */
	public void setSor(int sor) {
		this.sor = sor;
	}
	
	/**
	 * Visszadja a koordináta oszlop értékét.
	 * 
	 * @return oszlop érték
	 */
	public int getOszlop() {
		return oszlop;
	}
	
	/**
	 * Beállítja a koordináta oszlop értékét.
	 * 
	 * @param oszlop új oszlop érték
	 */
	public void setOszlop(int oszlop) {
		this.oszlop = oszlop;
	}
	
	/**
	 * Koordinátákat létrehozó konstruktor.
	 * 
	 * @param sor érték
	 * @param oszlop érték
	 */
	public Koordinatak(int sor, int oszlop) {
		super();
		this.sor = sor;
		this.oszlop = oszlop;
	}
	
	/**
	 * Paraméterek nélküli konstruktor.
	 */
	public Koordinatak() {
	}
	
	/** 
	 * Visszaadja a játékos adatainak String reprezentációját.
	 * 
	 * @return String reprezentáció
	 */
	@Override
	public String toString() {
		return "Koordinatak [sor=" + sor + ", oszlop=" + oszlop + "]";
	}
}
