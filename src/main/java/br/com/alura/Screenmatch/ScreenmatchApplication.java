package br.com.alura.Screenmatch;

import br.com.alura.Screenmatch.model.DadoSerie;
import br.com.alura.Screenmatch.services.ConsumoApi;
import br.com.alura.Screenmatch.services.ConverteDados;
import br.com.alura.Screenmatch.services.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=the+boys&apikey=e035e3ed");
//		System.out.println(json);
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		ConverterDados conversor = new ConverterDados();
		DadoSerie dados = conversor.obterDados(json, DadoSerie.class);
		System.out.println(dados);
	}
}
