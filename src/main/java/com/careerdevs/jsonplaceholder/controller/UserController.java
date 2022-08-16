package com.careerdevs.jsonplaceholder.controller;

import com.careerdevs.jsonplaceholder.models.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final String jsonPlaceholderEndpoint = "https://jsonplaceholder.typicode.com/users";

    @GetMapping("/all")
    public ResponseEntity<?> getUsers(RestTemplate restTemplate) {
        try {
            UserModel[] response = restTemplate.getForObject(jsonPlaceholderEndpoint, UserModel[].class);

            for (int i = 0; i < response.length; i++) {
                UserModel user = response[i];
                System.out.println(user.getAddress().getGeo().getLat());
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getUserById(RestTemplate restTemplate, @PathVariable String id) {
        try {

            // throw NumberFormatException if id is not an int
            Integer.parseInt(id);

            System.out.println("Getting User With ID: " + id);

            String url = jsonPlaceholderEndpoint + "/" + id;

            UserModel response = restTemplate.getForObject(url, UserModel.class);

            return ResponseEntity.ok(response);

        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body("ID: " + id + ", is not a valid id. Must be a whole number");

        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(404).body("User Not Found WIth ID: " + id);

        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

//    @GetMapping("/posts")
//    public ResponseEntity<?> getPosts(RestTemplate restTemplate) {
//        try {
//            UserModel[] response = restTemplate.getForObject(jsonPlaceholderEndpoint, UserModel[].class);
//
//            for (int i = 0; i < response.length; i++) {
//                UserModel user = response[i];
//                System.out.println(user.getTitle());
//                System.out.println(user.getBody());
//            }
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            System.out.println(e.getClass());
//            System.out.println(e.getMessage());
//
//            return ResponseEntity.internalServerError().body(e.getMessage());
//        }
//    }
//
//    @GetMapping("/photos")
//    public Object photoHandler(RestTemplate restTemplate) {
//        String photoEndpoint = jsonPlaceholderEndpoint;
//        photoEndpoint += "photos";
//        return restTemplate.getForObject(photoEndpoint, Object.class);
//    }
//
//    @GetMapping("/posts")
//    public Object postsHandler(RestTemplate restTemplate) {
//        String postsEndpoint = jsonPlaceholderEndpoint;
//        postsEndpoint += "posts";
//        return restTemplate.getForObject(postsEndpoint, Object.class);
//    }
//
//    @GetMapping("/comments")
//    public Object commentsHandler(RestTemplate restTemplate) {
//        String commentsEndpoint = jsonPlaceholderEndpoint;
//        commentsEndpoint += "comments";
//        return restTemplate.getForObject(commentsEndpoint, Object.class);
//    }
//
//    @GetMapping("/albums")
//    public Object albumsHandler(RestTemplate restTemplate) {
//        String albumsEndpoint = jsonPlaceholderEndpoint;
//        albumsEndpoint += "albums";
//        return restTemplate.getForObject(albumsEndpoint, Object.class);
//    }
//
//    @GetMapping("/todos")
//    public Object todosHandler(RestTemplate restTemplate) {
//        String todosEndpoint = jsonPlaceholderEndpoint;
//        todosEndpoint += "todos";
//        return restTemplate.getForObject(todosEndpoint, Object.class);
//    }

//    @GetMapping("/users")
//    public Object usersHandler(RestTemplate restTemplate) {
//        String usersEndpoint = jsonPlaceholderEndpoint;
//        usersEndpoint += "users";
//        return restTemplate.getForObject(usersEndpoint, Object.class);
//    }

//    @GetMapping("/all")
//    public ResponseEntity<?> getUsers (RestTemplate restTemplate) {
//        Object response = restTemplate.getForObject(jsonPlaceholderEndpoint, Object.class);
//
//        return ResponseEntity.ok(response);
//    }