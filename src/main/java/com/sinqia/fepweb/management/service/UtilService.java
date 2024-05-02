package com.sinqia.fepweb.management.service;

import com.google.gson.Gson;
import com.sinqia.fepweb.management.dto.EnderecoCepDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;

@Service
public class UtilService {

    private final Logger log = LoggerFactory.getLogger(UtilService.class);

    @Value("${url.cep}")
    private String urlCep;


    public EnderecoCepDTO getCep(String cep) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            String url = MessageFormat.format(urlCep, cep);
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro ao buscar Cep");
            }

            EnderecoCepDTO enderecoCepDTO = new Gson().fromJson(response.body(), EnderecoCepDTO.class);
            enderecoCepDTO.setCep(enderecoCepDTO.getCep().replace("-", ""));
            return enderecoCepDTO;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar Cep");
        }
    }

}
