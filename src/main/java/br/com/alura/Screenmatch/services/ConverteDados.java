package br.com.alura.Screenmatch.services;

public interface ConverteDados {
   <T> T obterDados(String json, Class<T> classe);
}
