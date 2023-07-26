
package S5D1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import S5D1.entities.Ordine;
import S5D1.entities.OrdineMenu;
import S5D1.entities.Tavolo;

@Component
public class OrderRunner implements CommandLineRunner {

	private final ApplicationContext context;

	public OrderRunner(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public void run(String... args) throws Exception {
		Ordine ordine1 = context.getBean("ordine1", Ordine.class);
		Ordine ordine2 = context.getBean("ordine2", Ordine.class);
		Tavolo tavolo1 = context.getBean("tavolo1", Tavolo.class);
		Tavolo tavolo2 = context.getBean("tavolo2", Tavolo.class);

		System.out.println("Ordine 1:");
		System.out.println("Numero Ordine: " + ordine1.getNumeroOrdine());
		System.out.println("Stato: " + ordine1.getStato());
		System.out.println("Tavolo Numero: " + tavolo1.getNumero());
		System.out.println("Elementi Menu Ordinati: ");
		for (OrdineMenu elemento : ordine1.getElementiMenu()) {
			System.out.println(
					"- " + elemento.getNome() + ", Prezzo: " + elemento.getPrezzo() + ", Nota: " + elemento.getNote());
		}
		System.out.println("Importo Totale: " + ordine1.getImportoTotale());

		System.out.println("Ordine 2:");
		System.out.println("Numero Ordine: " + ordine2.getNumeroOrdine());
		System.out.println("Stato: " + ordine2.getStato());
		System.out.println("Tavolo Numero: " + tavolo2.getNumero());
		System.out.println("Elementi Menu Ordinati: ");
		for (OrdineMenu elemento : ordine2.getElementiMenu()) {
			System.out.println(
					"- " + elemento.getNome() + ", Prezzo: " + elemento.getPrezzo() + ", Nota: " + elemento.getNote());
		}
		System.out.println("Importo Totale: " + ordine2.getImportoTotale());
	}

}
