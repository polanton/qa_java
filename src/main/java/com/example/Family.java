package com.example;

import java.util.List;
//Интерфейс для инъекции зависимостей
public interface Family {
    String getFamily();
    int getKittens();
    List<String> getFood() throws Exception;
}
