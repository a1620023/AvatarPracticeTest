package io.emelceledonio.avatarpracticetest.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Service
public class PokemonService {

    @Value("${api.base.url}")
    private String uri;

    public HttpResponse<String> getApiData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    public CompletableFuture<Map<String, String>> getJsonBodyAPIData(){
        UncheckedObjectMapper objectMapper = new UncheckedObjectMapper();
        HttpRequest request = HttpRequest.newBuilder(URI.create(uri))
                .header("Accept", "application/json").build();
        var newresult = HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(objectMapper::readValue);
        System.out.println(newresult);
        return newresult;
    }
}

class UncheckedObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper{
    Map<String, String> readValue(String content){
        try {
            return this.readValue(content, new TypeReference<>() {});
        }catch (IOException ioe){
            throw new CompletionException(ioe);
        }
    }
}
