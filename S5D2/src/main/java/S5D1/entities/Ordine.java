
package S5D1.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ordine {
	private int numeroOrdine;
	private StatoOrdine stato;
	private int numeroCoperti;
	private LocalDateTime oraAcquisizione;
	private List<OrdineMenu> elementiMenu;
	@Value("${application.costo.coperto}")
	private int costoCoperto;
	private Tavolo tavolo;

	public double getImportoTotale() {
		int numeroCoperti = getNumeroCoperti();
		int costoCoperto = getCostoCoperto();
		double importoTotale = numeroCoperti * costoCoperto;

		for (OrdineMenu elemento : elementiMenu) {
			importoTotale += elemento.getPrezzo();
		}

		return importoTotale;
	}
}
