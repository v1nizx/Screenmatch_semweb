package br.com.alura.Screenmatch;

import br.com.alura.Screenmatch.model.DadoEpisodio;
import br.com.alura.Screenmatch.model.DadoSerie;
import br.com.alura.Screenmatch.model.DadoTemporada;
import br.com.alura.Screenmatch.services.ConsumoApi;
import br.com.alura.Screenmatch.services.ConverteDados;
import br.com.alura.Screenmatch.services.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
		json = consumoApi.obterDados("https://www.omdbapi.com/?t=the+boys&season=4&episode=2&apikey=e035e3ed");
		DadoEpisodio dadosEpisodio = conversor.obterDados(json, DadoEpisodio.class);
		System.out.println(dadosEpisodio);

		List<DadoTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i<=dados.totalTemporadas(); i++){
		json = consumoApi.obterDados("https://www.omdbapi.com/?t=the+boys&season=" + i + "&apikey=e035e3ed");
		DadoTemporada dadosTemporada = conversor.obterDados(json, DadoTemporada.class);
		temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
	}
}
