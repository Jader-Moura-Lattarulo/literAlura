package br.com.jmdev.literalura.service;

public interface IConvertsData {
    <T> T getData(String json, Class<T> clazz);
}
