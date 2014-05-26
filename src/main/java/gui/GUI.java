package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JTextField;

import osztalyok.DOM;
import osztalyok.Jatekosok;
import osztalyok.Koordinatak;

/**
 * GUI-t implementáló osztály.
 * 
 * @author Dreko
 */
public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * A megjelenítendő felület alap layer-e.
	 */
	private JPanel defaultPanel;
	/**
	 * Második játékos tábláit tartalmazó panel.
	 */
	private JPanel masodikJatekosTablai;
	/**
	 * Első játékos tábláit tartalmazó panel.
	 */
	private JPanel elsoJatekosTablai;
	/**
	 * A checkBox-hoz tartozó felirat.
	 */
	private JLabel aktivitasLabel;

	/**
	 * CheckBox első eleme.
	 */
	private JRadioButton elsoAktiv;
	/**
	 * CheckBox második eleme.
	 */
	private JRadioButton masodikAktiv;
	/**
	 * CheckBox harmadik eleme.
	 */
	private JRadioButton nincsAktiv;
	/**
	 * CheckBox utolsó eleme.
	 */
	private JRadioButton mindkettoAktiv;

	/**
	 * Első játékos hajóinak pozicióját tartalmazó tömb.
	 */
	private JButton[][] elsoJatekosHajoi;
	/**
	 * Második játékos hajóinak pozicióját tartalmazó tömb.
	 */
	private JButton[][] masodikJatekosHajoi;
	/**
	 * Első játékos tippejeit tartalmazó tömb.
	 */
	private JButton[][] elsoJatekosTippjei;
	/**
	 * Második játékos tippejeit tartalmazó tömb.
	 */
	private JButton[][] masodikJatekosTippjei;

	/**
	 * Első játékos hajóinak elhelyezését véglegesítő gomb.
	 */
	private JButton hajoLerak1;
	/**
	 * Első játokos tippjét véglegesítő gomb.
	 */
	private JButton tipp1;
	/**
	 * Második játékos hajóinak elhelyezését véglegesítő gomb.
	 */
	private JButton hajoLerak2;
	/**
	 * Második játokos tippjét véglegesítő gomb.
	 */
	private JButton tipp2;
	/**
	 * Új játék indításáért felelős gomb.
	 */
	private JButton startGomb;
	/**
	 * Első játékos feladásának eleget tevő gomb.
	 */
	private JButton feladJatekos1;
	/**
	 * Második játékos feladásának eleget tevő gomb.
	 */
	private JButton feladJatekos2;

	/**
	 * Ranglista a gomb lenyomása után kerül megjelenítésre.
	 */
	private JButton ranglista;
	/**
	 * Ha a játék szüneteltetve lett, ezen gomb segítségével lehet visszatérni
	 * az aktív játékos tábláihoz.
	 */
	private JButton kovetkezoJatekos;

	/**
	 * Az aktív nézetek megjelenítését szolgálja.
	 */
	private ButtonGroup checkBox;

	/**
	 * Első játékos hajóit tartalmazó táblázat ebben a panelben kerül
	 * megjelenítésre.
	 */
	private JPanel elsoJatekosHajok;
	/**
	 * Első játékos tippjeit tartalmazó táblázat ebben a panelben kerül
	 * megjelenítésre.
	 */
	private JPanel elsoJatekosTippek;
	/**
	 * Második játékos hajóit tartalmazó táblázat ebben a panelben kerül
	 * megjelenítésre.
	 */
	private JPanel masodikJatekosHajok;
	/**
	 * Második játékos tippjeit tartalmazó táblázat ebben a panelben kerül
	 * megjelenítésre.
	 */
	private JPanel masodikJatekosTippek;

	/**
	 * Első játékos utolsó tippjének koordinátáit tartalmazza.
	 */
	private Koordinatak elsoTippje = new Koordinatak();
	/**
	 * Második játékos utolsó tippjének koordinátáit tartalmazza.
	 */
	private Koordinatak masodikTippje = new Koordinatak();

	/**
	 * Soron következő játékos megállapítását teszi lehetővé. true érték esetén
	 * az első játékos következik, míg false érték esetén a második játékos.
	 */
	private boolean elsoJon = true;
	/**
	 * true érték esetén egy játék már folymatban van, míg false érték esetén
	 * nincs aktív játék folyamatban.
	 */
	private boolean elindult = false;
	/**
	 * true érték esetén első játékos nyerte meg a játékot, míg false esetén a
	 * második játékos.
	 */
	private boolean elsoNyert = false;
	/**
	 * Segít eldönteni a program működése folyamán, hogy az éppen aktív
	 * játékosnak van-e már győztese.
	 */
	private boolean nyertes = false;

	/**
	 * A játék folyamán játékosonként elhelyezhető hajók száma.
	 */
	private int hajokSzama = 7;
	/**
	 * Első játékos által a táblán elhelyezett hajók száma.
	 */
	private int elsoJatekosHajoinakSzama = 0;
	/**
	 * Második játékos által a táblán elhelyezett hajók száma.
	 */
	private int masodikJatekosHajoinakSzama = 0;
	/**
	 * Első játékos által kilőtt hajók száma.
	 */
	private int elsoKilott = 0;
	/**
	 * Második játékos által kilőtt hajók száma.
	 */
	private int masodikKilott = 0;
	/**
	 * Első játékos tippjeinek a száma.
	 */
	private int elsoTippek = 0;
	/**
	 * Második játékos tippjeinek a száma.
	 */
	private int masodikTippek = 0;

	/**
	 * Első játékos nevét bekérő mező.
	 */
	private JTextField elsoJatekos;
	/**
	 * Második játékos nevét bekérő mező.
	 */
	private JTextField masodikJatekos;

	/**
	 * Első játéskohoz tartozó Név: felirat.
	 */
	private JLabel nevLabel1;
	/**
	 * Második játéskohoz tartozó Név: felirat.
	 */
	private JLabel nevLabel2;

	/**
	 * Felhasználói felület megjelenítéséért felelős metódus.
	 * 
	 * @param args argumentumok
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 389);
		defaultPanel = new JPanel();
		defaultPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(defaultPanel);
		defaultPanel.setLayout(null);

		elsoJatekosTablai = new JPanel();
		elsoJatekosTablai.setBounds(20, 42, 206, 302);
		defaultPanel.add(elsoJatekosTablai);
		elsoJatekosTablai.setLayout(null);

		hajoLerak1 = new JButton("Elhelyezés vége");
		hajoLerak1.setBounds(38, 123, 128, 23);
		hajoLerak1.setEnabled(false);
		hajoLerak1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				elsoJatekosTablai.setVisible(false);
				masodikJatekosTablai.setVisible(true);
				masodikAktiv.setSelected(true);
				hajoLerak1.setEnabled(false);
				elsoJon = false;
			}
		});
		elsoJatekosTablai.add(hajoLerak1);

		tipp1 = new JButton("Tűz");
		tipp1.setBounds(10, 157, 89, 23);
		tipp1.setEnabled(false);
		tipp1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				masodikAktiv.setSelected(true);
				elsoJatekosTablai.setVisible(false);
				masodikJatekosTablai.setVisible(true);
				if (masodikJatekosHajoi[elsoTippje.getSor()][elsoTippje
						.getOszlop()].getBackground().equals(Color.WHITE)) {
					elsoJatekosTippjei[elsoTippje.getSor()][elsoTippje
							.getOszlop()].setBackground(Color.GREEN);
					masodikJatekosHajoi[elsoTippje.getSor()][elsoTippje
							.getOszlop()].setBackground(Color.RED);
					elsoKilott++;
					if (elsoKilott == hajokSzama) {
						nyert(1);
					}
				} else {
					masodikJatekosHajoi[elsoTippje.getSor()][elsoTippje
							.getOszlop()].setBackground(Color.GRAY);
				}
				elsoJon = false;
				tipp1.setEnabled(false);
			}
		});
		elsoJatekosTablai.add(tipp1);

		elsoJatekosHajok = new JPanel();
		elsoJatekosHajok.setBounds(10, 11, 186, 108);
		elsoJatekosTablai.add(elsoJatekosHajok);
		elsoJatekosHajok.setLayout(new GridLayout(7, 7, 0, 0));

		elsoJatekosTippek = new JPanel();
		elsoJatekosTippek.setBounds(10, 183, 186, 108);
		elsoJatekosTablai.add(elsoJatekosTippek);
		elsoJatekosTippek.setLayout(new GridLayout(7, 7, 0, 0));

		feladJatekos1 = new JButton("Feladom");
		feladJatekos1.setBounds(107, 157, 89, 23);
		feladJatekos1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				elsoNyert = false;
				startGomb.setEnabled(true);
				nyert(2);
			}
		});
		elsoJatekosTablai.add(feladJatekos1);

		masodikJatekosTablai = new JPanel();
		masodikJatekosTablai.setBounds(373, 42, 206, 302);
		defaultPanel.add(masodikJatekosTablai);
		masodikJatekosTablai.setLayout(null);

		masodikJatekosHajok = new JPanel();
		masodikJatekosHajok.setBounds(10, 11, 186, 108);
		masodikJatekosTablai.add(masodikJatekosHajok);
		masodikJatekosHajok.setLayout(new GridLayout(7, 7, 0, 0));

		masodikJatekosTippek = new JPanel();
		masodikJatekosTippek.setBounds(10, 183, 186, 108);
		masodikJatekosTablai.add(masodikJatekosTippek);
		masodikJatekosTippek.setLayout(new GridLayout(7, 7, 0, 0));

		tipp2 = new JButton("Tűz");
		tipp2.setBounds(10, 158, 89, 23);
		tipp2.setEnabled(false);
		tipp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elsoAktiv.setSelected(true);
				elsoJatekosTablai.setVisible(true);
				masodikJatekosTablai.setVisible(false);
				if (elsoJatekosHajoi[masodikTippje.getSor()][masodikTippje
						.getOszlop()].getBackground().equals(Color.WHITE)) {
					masodikJatekosTippjei[masodikTippje.getSor()][masodikTippje
							.getOszlop()].setBackground(Color.GREEN);
					elsoJatekosHajoi[masodikTippje.getSor()][masodikTippje
							.getOszlop()].setBackground(Color.RED);
					masodikKilott++;
					if (masodikKilott == hajokSzama) {
						nyert(2);
					}
				} else {
					elsoJatekosHajoi[masodikTippje.getSor()][masodikTippje
							.getOszlop()].setBackground(Color.GRAY);
				}
				elsoJon = true;
				tipp2.setEnabled(false);
			}
		});
		masodikJatekosTablai.add(tipp2);

		hajoLerak2 = new JButton("Elhelyezés vége");
		hajoLerak2.setBounds(40, 124, 124, 23);
		hajoLerak2.setEnabled(false);
		hajoLerak2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				elsoJatekosTablai.setVisible(true);
				masodikJatekosTablai.setVisible(false);
				elsoAktiv.setSelected(true);
				hajoLerak2.setEnabled(false);

				elsoJon = true;
			}
		});
		masodikJatekosTablai.add(hajoLerak2);

		feladJatekos2 = new JButton("Feladom");
		feladJatekos2.setBounds(107, 158, 89, 23);
		feladJatekos2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				startGomb.setEnabled(true);
				elsoNyert = true;
				elindult = false;
				nyert(1);
			}
		});
		masodikJatekosTablai.add(feladJatekos2);

		checkBox = new ButtonGroup();

		aktivitasLabel = new JLabel("Aktív játékos:");
		aktivitasLabel.setBounds(236, 79, 89, 16);
		aktivitasLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		defaultPanel.add(aktivitasLabel);

		elsoAktiv = new JRadioButton("Első játékos");
		elsoAktiv.setBounds(232, 102, 135, 23);
		defaultPanel.add(elsoAktiv);

		masodikAktiv = new JRadioButton("Második játékos");
		masodikAktiv.setBounds(232, 128, 135, 23);
		defaultPanel.add(masodikAktiv);

		nincsAktiv = new JRadioButton("Egyik sem");
		nincsAktiv.setSelected(true);
		nincsAktiv.setBounds(232, 154, 135, 23);
		defaultPanel.add(nincsAktiv);

		mindkettoAktiv = new JRadioButton("Mutat mindent");
		mindkettoAktiv.setBounds(232, 180, 135, 23);
		defaultPanel.add(mindkettoAktiv);

		checkBox.add(elsoAktiv);
		checkBox.add(masodikAktiv);
		checkBox.add(nincsAktiv);
		checkBox.add(mindkettoAktiv);

		startGomb = new JButton("Új játék");
		startGomb.setBounds(236, 11, 127, 44);
		startGomb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				elindult = true;
				elsoAktiv.setEnabled(false);
				elsoAktiv.setSelected(true);
				elsoJatekosTablai.setVisible(true);
				masodikJatekosTablai.setVisible(false);
				masodikAktiv.setEnabled(false);
				mindkettoAktiv.setEnabled(false);
				startGomb.setEnabled(false);

				elsoJatekosHajoinakSzama = 0;
				elsoKilott = 0;
				elsoTippek = 0;
				masodikJatekosHajoinakSzama = 0;
				masodikKilott = 0;
				masodikTippek = 0;

				tisztit();

				elsoJon = true;
				nyertes = false;

				elsoJatekos.setEditable(false);
				masodikJatekos.setEditable(false);
			}
		});
		defaultPanel.add(startGomb);

		kovetkezoJatekos = new JButton("");
		kovetkezoJatekos.setBounds(254, 210, 89, 23);
		kovetkezoJatekos.setVisible(false);
		kovetkezoJatekos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (elsoJon) {
					elsoJatekosTablai.setVisible(true);
					elsoAktiv.setSelected(true);
				} else {
					masodikJatekosTablai.setVisible(true);
					masodikAktiv.setSelected(true);
				}
				kovetkezoJatekos.setVisible(false);
			}
		});
		defaultPanel.add(kovetkezoJatekos);

		elsoJatekos = new JTextField();
		elsoJatekos.setText("Első Játékos");
		elsoJatekos.setBounds(58, 11, 168, 20);
		defaultPanel.add(elsoJatekos);
		elsoJatekos.setColumns(10);

		nevLabel1 = new JLabel("Név:");
		nevLabel1.setBounds(30, 11, 28, 14);
		defaultPanel.add(nevLabel1);

		nevLabel2 = new JLabel("Név:");
		nevLabel2.setBounds(373, 11, 28, 14);
		defaultPanel.add(nevLabel2);

		masodikJatekos = new JTextField();
		masodikJatekos.setText("Második Játékos");
		masodikJatekos.setColumns(10);
		masodikJatekos.setBounds(401, 11, 178, 20);
		defaultPanel.add(masodikJatekos);

		ranglista = new JButton("Ranglista");
		ranglista.setBounds(254, 278, 89, 23);
		ranglista.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Rangsor rs = new Rangsor();
				rs.setVisible(true);
			}
		});
		defaultPanel.add(ranglista);

		elsoJatekosTablai.setVisible(false);
		masodikJatekosTablai.setVisible(false);

		elsoAktiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (elsoAktiv.isSelected()) {
					elsoJatekosTablai.setVisible(true);
					masodikJatekosTablai.setVisible(false);
				}
			}
		});

		masodikAktiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (masodikAktiv.isSelected()) {
					elsoJatekosTablai.setVisible(false);
					masodikJatekosTablai.setVisible(true);
				}
			}
		});

		nincsAktiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nincsAktiv.isSelected()) {
					elsoJatekosTablai.setVisible(false);
					masodikJatekosTablai.setVisible(false);
					if (!nyertes && elindult) {
						kovetkezoJatekos.setVisible(true);
					}
					if (elsoJon) {
						kovetkezoJatekos.setLabel("Első jön");
					} else {
						kovetkezoJatekos.setLabel("Második jön");
					}
				}
			}
		});

		mindkettoAktiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mindkettoAktiv.isSelected()) {
					elsoJatekosTablai.setVisible(true);
					masodikJatekosTablai.setVisible(true);
				}
			}
		});

		elsoJatekosHajoi = new JButton[7][7];
		elsoJatekosTippjei = new JButton[7][7];
		masodikJatekosHajoi = new JButton[7][7];
		masodikJatekosTippjei = new JButton[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				final int sor = i;
				final int oszlop = j;
				elsoJatekosHajoi[i][j] = new JButton();
				elsoJatekosHajoi[i][j].setBackground(Color.BLUE);
				elsoJatekosHajoi[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (elindult) {
							if (elsoJatekosHajoinakSzama < hajokSzama) {
								feher(sor, oszlop);
								if (elsoJatekosHajoi[sor][oszlop]
										.getBackground().equals(Color.WHITE)) {
									elsoJatekosHajoinakSzama++;
								}
							}
							if (elsoJatekosHajoinakSzama == hajokSzama) {
								hajoLerak1.setEnabled(true);
							}
						}
					}
				});
				elsoJatekosHajok.add(elsoJatekosHajoi[i][j]);

				elsoJatekosTippjei[i][j] = new JButton();
				elsoJatekosTippjei[i][j].setBackground(Color.BLUE);
				elsoJatekosTippjei[i][j]
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (elindult
										&& elsoJatekosHajoinakSzama == hajokSzama
										&& masodikJatekosHajoinakSzama == hajokSzama * 2) {
									tippel(sor, oszlop);
									elsoJon = false;
									elsoTippek++;
									tipp1.setEnabled(true);
								}
							}
						});
				elsoJatekosTippek.add(elsoJatekosTippjei[i][j]);

				masodikJatekosHajoi[i][j] = new JButton();
				masodikJatekosHajoi[i][j].setBackground(Color.BLUE);
				masodikJatekosHajoi[i][j]
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (elindult) {
									if (masodikJatekosHajoinakSzama < hajokSzama * 2) {
										feher(sor, oszlop);
										if (masodikJatekosHajoi[sor][oszlop]
												.getBackground().equals(
														Color.WHITE)) {
											masodikJatekosHajoinakSzama++;
										}
									}
									if (masodikJatekosHajoinakSzama == hajokSzama * 2) {
										hajoLerak2.setEnabled(true);
									}
								}
							}
						});
				masodikJatekosHajok.add(masodikJatekosHajoi[i][j]);

				masodikJatekosTippjei[i][j] = new JButton();
				masodikJatekosTippjei[i][j].setBackground(Color.BLUE);
				masodikJatekosTippjei[i][j]
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (elindult
										&& masodikJatekosHajoinakSzama == hajokSzama * 2
										&& elsoJatekosHajoinakSzama == hajokSzama) {
									tippel(sor, oszlop);
									elsoJon = true;
									masodikTippek++;
									tipp2.setEnabled(true);
								}
							}
						});
				masodikJatekosTippek.add(masodikJatekosTippjei[i][j]);
			}
		}
	}

	/**
	 * Játékosok tippjeinek rögzítése.
	 * 
	 * @param sor
	 *            tipp sor indexe
	 * @param oszlop
	 *            tipp oszlop indexe
	 */
	protected void tippel(int sor, int oszlop) {
		if (elsoJon) {
			if (elsoJatekosTippjei[sor][oszlop].getBackground().equals(
					Color.BLUE)) {
				elsoJatekosTippjei[sor][oszlop].setBackground(Color.YELLOW);
				elsoTippje.setOszlop(oszlop);
				elsoTippje.setSor(sor);
			}
		} else {
			if (masodikJatekosTippjei[sor][oszlop].getBackground().equals(
					Color.BLUE)) {
				masodikJatekosTippjei[sor][oszlop].setBackground(Color.YELLOW);
				masodikTippje.setOszlop(oszlop);
				masodikTippje.setSor(sor);
			}
		}
	}

	/**
	 * Játékosok hajóinak elhelyezése táblájukon.
	 * 
	 * @param sor
	 *            hajó sor indexe
	 * @param oszlop
	 *            hajó sor indexe
	 */
	protected void feher(int sor, int oszlop) {
		if (elsoJon) {
			if (elsoJatekosHajoi[sor][oszlop].getBackground().equals(
					Color.WHITE)) {
				elsoJatekosHajoi[sor][oszlop].setBackground(Color.BLUE);
			} else {
				if (vizsgal(sor, oszlop)) {
					elsoJatekosHajoi[sor][oszlop].setBackground(Color.WHITE);

				}
			}
		} else {
			if (masodikJatekosHajoi[sor][oszlop].getBackground().equals(
					Color.WHITE)) {
				masodikJatekosHajoi[sor][oszlop].setBackground(Color.BLUE);
			} else {
				if (vizsgal(sor, oszlop)) {
					masodikJatekosHajoi[sor][oszlop].setBackground(Color.WHITE);
					masodikJatekosHajoinakSzama++;
				}
			}
		}
	}

	/**
	 * 
	 * Hajó elhelyezésének engedélyezése.
	 * 
	 * @param sor
	 *            hajó sor indexe
	 * @param oszlop
	 *            hajó oszlop indexe
	 * @return engedélyezve van true esetén, míg false esetén megtagadva
	 */
	protected boolean vizsgal(int sor, int oszlop) {
		if (sor > 0 && sor < 6) {
			if (oszlop > 0 && oszlop < 6) {
				if (elsoJon) {
					if (elsoJatekosHajoi[sor - 1][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor + 1][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor + 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor + 1][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
				} else {
					if (masodikJatekosHajoi[sor - 1][oszlop - 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop + 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor + 1][oszlop - 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor + 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor + 1][oszlop + 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
				}
			}
		}
		if (sor == 0) {
			if (oszlop > 0 && oszlop < 6) {
				if (elsoJon) {
					if (elsoJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor + 1][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor + 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor + 1][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
				} else {
					if (masodikJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor + 1][oszlop - 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor + 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor + 1][oszlop + 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
				}
			}

			if (oszlop == 0) {
				if (elsoJon) {
					if (elsoJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor + 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor + 1][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
				} else {
					if (masodikJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor + 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor + 1][oszlop + 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
				}
			}
			if (oszlop == 6) {
				if (elsoJon) {
					if (elsoJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor + 1][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
				} else {
					if (masodikJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor + 1][oszlop - 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
				}
			}
		}
		if (sor == 6) {
			if (oszlop > 0 && oszlop < 6) {
				if (elsoJon) {
					if (elsoJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
				} else {
					if (masodikJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop - 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop + 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
				}
			}

			if (oszlop == 0) {
				if (elsoJon) {
					if (elsoJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
				} else {
					if (masodikJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop + 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
				}
			}

			if (oszlop == 6) {
				if (elsoJon) {
					if (elsoJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
				} else {
					if (masodikJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop - 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
				}
			}
		}

		if (oszlop == 6) {
			if (sor > 0 && sor < 6) {
				if (elsoJon) {
					if (elsoJatekosHajoi[sor + 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor + 1][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
				} else {
					if (masodikJatekosHajoi[sor + 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor + 1][oszlop - 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor][oszlop - 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop - 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
				}
			}
		}

		if (oszlop == 0) {
			if (sor > 0 && sor < 6) {
				if (elsoJon) {
					if (elsoJatekosHajoi[sor + 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor + 1][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (elsoJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
				} else {
					if (masodikJatekosHajoi[sor + 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor + 1][oszlop + 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor][oszlop + 1].getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop + 1]
							.getBackground() != Color.BLUE) {
						return false;
					}
					if (masodikJatekosHajoi[sor - 1][oszlop].getBackground() != Color.BLUE) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Nyertes esetén felugró ablak írja ki a nyertes nevét és a játékosok
	 * eredményei a ranglistához lesznek adva.
	 * 
	 * @param jatekos
	 *            játékosok azonosítása
	 */
	protected void nyert(int jatekos) {
		startGomb.setEnabled(true);
		mindkettoAktiv.setSelected(true);
		elsoJatekosTablai.setVisible(true);
		masodikJatekosTablai.setVisible(true);
		if (jatekos == 1) {
			JOptionPane.showMessageDialog(defaultPanel, elsoJatekos.getText()
					+ " nyert!");
		} else {
			JOptionPane.showMessageDialog(defaultPanel,
					masodikJatekos.getText() + " nyert!");
		}
		mindkettoAktiv.setSelected(true);
		mindkettoAktiv.setEnabled(true);

		nyertes = true;
		elindult = false;

		elsoJatekos.setEditable(true);
		masodikJatekos.setEditable(true);

		DOM.jatekosokMentese(new Jatekosok(elsoJatekos.getText(), elsoKilott,
				elsoTippek), new Jatekosok(masodikJatekos.getText(),
				masodikKilott, masodikTippek));

	}

	/**
	 * Új játék esetén kitakarítja a táblákat.
	 */
	protected void tisztit() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				elsoJatekosHajoi[i][j].setBackground(Color.BLUE);
				elsoJatekosTippjei[i][j].setBackground(Color.BLUE);
				masodikJatekosHajoi[i][j].setBackground(Color.BLUE);
				masodikJatekosTippjei[i][j].setBackground(Color.BLUE);
			}
		}
	}
}
