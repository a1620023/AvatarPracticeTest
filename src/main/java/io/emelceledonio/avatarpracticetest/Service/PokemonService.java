package io.emelceledonio.avatarpracticetest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PokemonService {

    @Value("${api.base.url}")
    private String uri;

    public String getApiData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }
}
