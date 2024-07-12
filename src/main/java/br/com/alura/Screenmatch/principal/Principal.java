package br.com.alura.Screenmatch.principal;
import br.com.alura.Screenmatch.model.DadoEpisodio;
import br.com.alura.Screenmatch.model.DadoSerie;
import br.com.alura.Screenmatch.model.DadoTemporada;
import br.com.alura.Screenmatch.services.ConsumoApi;
import br.com.alura.Screenmatch.services.ConverterDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Principal {
    private Scanner leitura = new Scanner(System.in);

    private ConsumoApi consumo = new ConsumoApi();

    private ConverterDados conversor = new ConverterDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=e035e3ed";

    public void exibeMenu(){
        System.out.println("Digite o nome da serie para busca");
        var nomeSerie = leitura.nextLine();
        var consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadoSerie dados = conversor.obterDados(json, DadoSerie.class);
        System.out.println(dados);

        List<DadoTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i<=dados.totalTemporadas(); i++){
		json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
		DadoTemporada dadosTemporada = conversor.obterDados(json, DadoTemporada.class);
		temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

//        for (int i = 0; i < dados.totalTemporadas(); i++){
//            List<DadoEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size(); j++){
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
    }
}
