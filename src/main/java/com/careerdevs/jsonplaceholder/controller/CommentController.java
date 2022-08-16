package com.careerdevs.jsonplaceholder.controller;

import com.careerdevs.jsonplaceholder.models.CommentModel;
import com.careerdevs.jsonplaceholder.models.ToDoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class CommentController {
    private final String jsonPHCommentsEndpoint = "https://jsonplaceholder.typicode.com/comments";
    @GetMapping("/all")
    public ResponseEntity<?> getAllComments(RestTemplate restTemplate) {
        try {
            CommentModel[] response = restTemplate.getForObject(jsonPHCommentsEndpoint, CommentModel[].class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getCommentById(RestTemplate restTemplate, @PathVariable String id) {
        try {
            Integer.parseInt(id);

            System.out.println("Getting Comment With ID: " + id);

            String url = jsonPHCommentsEndpoint + "/" + id;

            CommentModel response = restTemplate.getForObject(url, CommentModel.class);

            return ResponseEntity.ok(response);

        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body("ID: " + id + ", is not a valid id. Must be a whole number");

        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(404).body("Comment Not Found With ID: " + id);

        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
