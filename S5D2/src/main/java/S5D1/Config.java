package S5D1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import S5D1.entities.AnanasDecorator;
import S5D1.entities.Bevande;
import S5D1.entities.MargheritaPizza;
import S5D1.entities.Ordine;
import S5D1.entities.OrdineMenu;
import S5D1.entities.Pizza;
import S5D1.entities.ProsciuttoDecorator;
import S5D1.entities.StatoOrdine;
import S5D1.entities.Tavolo;

@Configuration
public class Config {

	@Bean("margherita")
	Pizza margheritaPizza() {
		return new MargheritaPizza();
	}

	@Bean("prosciutto")
	Pizza prosciuttoDecorator() {
		return new ProsciuttoDecorator(margheritaPizza());
	}

	@Bean("ananas")
	Pizza ananasDecorator() {
		return new AnanasDecorator(margheritaPizza());
	}

	@Bean("hawaiian")
	Pizza hawaiianPizza() {
		return new AnanasDecorator(new ProsciuttoDecorator(new MargheritaPizza()));
	}

	@Bean("wine")
	Bevande wine() {
		return new Bevande("Wine", 3, 3);
	}

	@Bean("margheritaOrdine")

	OrdineMenu pizzaMargheritaOrdine() {
		return new OrdineMenu("Margherita Pizza", 10.0, "Senza pomodoro");
	}

	@Bean("hawaiianOrdine")
	OrdineMenu pizzaHawaiianOrdine() {
		return new OrdineMenu("Hawaiian Pizza", 15.0, "Doppio Ananas");
	}

	@Bean("wineOrdine")
	OrdineMenu wineOrdine() {
		return new OrdineMenu("wine", 5.0, "Con ghiaccio");
	}

	@Bean("tavolo1")
	Tavolo tavolo1() {

		return new Tavolo(1, 10, true);
	}

	@Bean("tavolo2")
	Tavolo tavolo2() {

		return new Tavolo(2, 5, true);
	}

	@Scope("prototype")
	@Bean("ordine1")
	Ordine ordine1() {
		return Ordine.builder().numeroOrdine(5).stato(StatoOrdine.IN_CORSO).numeroCoperti(4)
				.elementiMenu(new ArrayList<>(List.of(pizzaMargheritaOrdine(), wineOrdine()))).tavolo(tavolo1())
				.build();
	}

	@Scope("prototype")
	@Bean("ordine2")
	Ordine ordine2() {
		return Ordine.builder().numeroOrdine(2).stato(StatoOrdine.IN_CORSO).numeroCoperti(5)
				.elementiMenu(new ArrayList<>(List.of(pizzaHawaiianOrdine()))).tavolo(tavolo2()).build();
	}

}
