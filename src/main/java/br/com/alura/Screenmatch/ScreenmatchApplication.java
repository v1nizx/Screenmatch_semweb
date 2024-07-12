package br.com.alura.Screenmatch;

import br.com.alura.Screenmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args)	 {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();

//		List<DadoTemporada> temporadas = new ArrayList<>();
//
//		for (int i = 1; i<=dados.totalTemporadas(); i++){
//		json = consumoApi.obterDados("https://www.omdbapi.com/?t=the+boys&season=" + i + "&apikey=e035e3ed");
//		DadoTemporada dadosTemporada = conversor.obterDados(json, DadoTemporada.class);
//		temporadas.add(dadosTemporada);
//		}
//		temporadas.forEach(System.out::println);
	}
}