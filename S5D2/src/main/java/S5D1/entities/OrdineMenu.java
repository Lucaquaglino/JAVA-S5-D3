package S5D1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrdineMenu {

	private String nome;
	private double prezzo;
	private String note;

	public OrdineMenu(String nome, double prezzo, String note) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.note = note;
	}

}
