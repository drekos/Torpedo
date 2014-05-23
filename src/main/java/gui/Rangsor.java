package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import osztalyok.DOM;
import osztalyok.Jatekosok;

/**
 * Rangsort implementáló osztály.
 * 
 * @author Dreko
 */
public class Rangsor extends JFrame {

	/**
	 * A táblázatot tartalmazó panel.
	 */
	private JPanel contentPane;

	/**
	 * A játékosok adatait tartalmazó táblázat.
	 */
	private JTable table;

	/**
	 * A rangsor megjelíntéséért felelős metódus.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rangsor frame = new Rangsor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Felhasználói felület.
	 */
	public Rangsor() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		String[] oszlopNevek = { "Név", "Kilőtt hajók száma", "Tippek száma",
				"Teljesítmény" };

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		NodeList jatekosok = DOM.getJatekosok();

		Object[][] adatok = new Object[jatekosok.getLength()][4];

		for (int index = 0; index < jatekosok.getLength(); index++) {
			Node jatek = jatekosok.item(index);

			if (jatek.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) jatek;

				String nev = e.getElementsByTagName("nev").item(0)
						.getTextContent();
				int kilott = Integer.parseInt(e
						.getElementsByTagName("kilottHajok").item(0)
						.getTextContent());
				int tippek = Integer.parseInt(e
						.getElementsByTagName("tippekSzama").item(0)
						.getTextContent());

				Jatekosok jat = new Jatekosok(nev, kilott, tippek);

				adatok[index][0] = (Object) jat.getNev();
				adatok[index][1] = jat.getKilottHajok();
				adatok[index][2] = jat.getTippekSzama();
				adatok[index][3] = jat.getTeljesitmeny();
			}
		}

		table = new JTable(adatok, oszlopNevek);
		scrollPane.setViewportView(table);
	}
}
