package com.careerdevs.jsonplaceholder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final String jsonPlaceholderEndpoint = "https://jsonplaceholder.typicode.com/";

    @GetMapping("/photos")
    public Object photoHandler(RestTemplate restTemplate) {
        String photoEndpoint = jsonPlaceholderEndpoint;
        photoEndpoint += "photos";
        return restTemplate.getForObject(photoEndpoint, Object.class);
    }

    @GetMapping("/posts")
    public Object postsHandler(RestTemplate restTemplate) {
        String postsEndpoint = jsonPlaceholderEndpoint;
        postsEndpoint += "posts";
        return restTemplate.getForObject(postsEndpoint, Object.class);
    }

    @GetMapping("/comments")
    public Object commentsHandler(RestTemplate restTemplate) {
        String commentsEndpoint = jsonPlaceholderEndpoint;
        commentsEndpoint += "comments";
        return restTemplate.getForObject(commentsEndpoint, Object.class);
    }

    @GetMapping("/albums")
    public Object albumsHandler(RestTemplate restTemplate) {
        String albumsEndpoint = jsonPlaceholderEndpoint;
        albumsEndpoint += "albums";
        return restTemplate.getForObject(albumsEndpoint, Object.class);
    }

    @GetMapping("/todos")
    public Object todosHandler(RestTemplate restTemplate) {
        String todosEndpoint = jsonPlaceholderEndpoint;
        todosEndpoint += "todos";
        return restTemplate.getForObject(todosEndpoint, Object.class);
    }

    @GetMapping("/users")
    public Object usersHandler(RestTemplate restTemplate) {
        String usersEndpoint = jsonPlaceholderEndpoint;
        usersEndpoint += "users";
        return restTemplate.getForObject(usersEndpoint, Object.class);
    }
}
