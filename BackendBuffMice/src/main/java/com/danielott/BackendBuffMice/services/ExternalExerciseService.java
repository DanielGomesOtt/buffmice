package com.danielott.BackendBuffMice.services;

import com.danielott.BackendBuffMice.domain.exercise.dto.ExternalExerciseApiDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class ExternalExerciseService {

    @Value("${exercise.api.uri}")
    private String exerciseURI;

    @Value("${exercise.api.key}")
    private String exerciseKey;

    public ExternalExerciseApiDTO[] fetchExercises() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(exerciseURI))
                    .setHeader("x-rapidapi-key", exerciseKey)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), ExternalExerciseApiDTO[].class);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
