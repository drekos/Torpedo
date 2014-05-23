package osztalyok;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * DOM-t megvalósító osztály.
 * 
 * @author Dreko
 */
public class DOM {

	/**
	 * Visszaadja a lejátszott meccsek játékosainak eredményét egy NodeList-ben.
	 * 
	 * @return játékosok eredményei
	 */
	public static NodeList getJatekosok() {
		NodeList jatekosok = null;

		try {
			DocumentBuilderFactory dBfactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dBfactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File("Jatekosok.xml"));

			jatekosok = doc.getElementsByTagName("jatekos");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jatekosok;
	}

	/**
	 * A Jatekosok.xml állomány tartalmát kibővíti a paraméterként megkapott játékosokkal.
	 * 
	 * @param elso első játékos
	 * @param masodik második játékos
	 */
	public static void jatekosokMentese(Jatekosok elso, Jatekosok masodik) {
		try {
			DocumentBuilderFactory dBfactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dBfactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			NodeList jatekosok = getJatekosok();

			Element rootElement = doc.createElement("jatekosok");
			doc.appendChild(rootElement);

			int index = 0;
			for (index = 0; index < jatekosok.getLength(); index++) {
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

					Element jatekos = doc.createElement("jatekos");
					rootElement.appendChild(jatekos);

					Attr id = doc.createAttribute("id");
					id.setValue(String.valueOf(index + 1));
					jatekos.setAttributeNode(id);

					Element name = doc.createElement("nev");
					name.appendChild(doc.createTextNode(jat.getNev()));
					jatekos.appendChild(name);

					Element kilottHajok = doc.createElement("kilottHajok");
					kilottHajok.appendChild(doc.createTextNode(String
							.valueOf(jat.getKilottHajok())));
					jatekos.appendChild(kilottHajok);

					Element tippekSzama = doc.createElement("tippekSzama");
					tippekSzama.appendChild(doc.createTextNode(String
							.valueOf(jat.getTippekSzama())));
					jatekos.appendChild(tippekSzama);

					Element teljesitmeny = doc.createElement("teljesitmeny");
					teljesitmeny.appendChild(doc.createTextNode(String
							.valueOf(jat.getTeljesitmeny())));
					jatekos.appendChild(teljesitmeny);
				}
			}

			Element jatekos1 = doc.createElement("jatekos");
			rootElement.appendChild(jatekos1);

			Attr id1 = doc.createAttribute("id");
			id1.setValue(String.valueOf(index + 1));
			jatekos1.setAttributeNode(id1);

			Element name1 = doc.createElement("nev");
			name1.appendChild(doc.createTextNode(elso.getNev()));
			jatekos1.appendChild(name1);

			Element kilottHajok1 = doc.createElement("kilottHajok");
			kilottHajok1.appendChild(doc.createTextNode(String.valueOf(elso
					.getKilottHajok())));
			jatekos1.appendChild(kilottHajok1);

			Element tippekSzama1 = doc.createElement("tippekSzama");
			tippekSzama1.appendChild(doc.createTextNode(String.valueOf(elso
					.getTippekSzama())));
			jatekos1.appendChild(tippekSzama1);

			Element teljesitmeny1 = doc.createElement("teljesitmeny");
			teljesitmeny1.appendChild(doc.createTextNode(String.valueOf(elso
					.getTeljesitmeny())));
			jatekos1.appendChild(teljesitmeny1);

			Element jatekos2 = doc.createElement("jatekos");
			rootElement.appendChild(jatekos2);

			Attr id2 = doc.createAttribute("id");
			id2.setValue(String.valueOf(index + 2));
			jatekos2.setAttributeNode(id2);

			Element name2 = doc.createElement("nev");
			name2.appendChild(doc.createTextNode(masodik.getNev()));
			jatekos2.appendChild(name2);

			Element kilottHajok2 = doc.createElement("kilottHajok");
			kilottHajok2.appendChild(doc.createTextNode(String.valueOf(masodik
					.getKilottHajok())));
			jatekos2.appendChild(kilottHajok2);

			Element tippekSzama2 = doc.createElement("tippekSzama");
			tippekSzama2.appendChild(doc.createTextNode(String.valueOf(masodik
					.getTippekSzama())));
			jatekos2.appendChild(tippekSzama2);

			Element teljesitmeny2 = doc.createElement("teljesitmeny");
			teljesitmeny2.appendChild(doc.createTextNode(String.valueOf(masodik
					.getTeljesitmeny())));
			jatekos2.appendChild(teljesitmeny2);

			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("Jatekosok.xml"));

			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
