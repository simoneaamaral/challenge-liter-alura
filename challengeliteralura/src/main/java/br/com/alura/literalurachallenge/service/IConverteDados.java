package br.com.alura.literalurachallenge.service;


public interface IConverteDados {
    <T> T obterDados(String json, Class <T> classe);
}
