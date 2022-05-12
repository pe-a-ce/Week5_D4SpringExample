package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

    /* syntax for @Controller and @ResponseBody together.
    This indicates that the class is a controller,
    and that all the methods in the marked class will return a JSON response.
    (any method we have we can tell it to run any HTTP verbs)

      Annotations add some superpowers to plain Java code.
        @RestController:
        -Spring will create a bean from this class
        -we can define endpoint methods in this class
    */

@RestController
public class HobbitController {

    private List<Hobbit> hobbits = List.of(
            new Hobbit("Frodo", "Baggins"),
            new Hobbit("Bilbo", "Baggins"),
            new Hobbit("Gandalf", "Grey")
            );
    ////            for HTTP GET requests, which only takes an optional value argument, no method argument.
    ////            The Read in CRUD.
    ////        LocalHost:8080
    ////        LocalHost is the root path

        // Accept HTTP GET, localhost:8080/hobbits

    @GetMapping("/hobbits")
        List<Hobbit> getAll() {
        return hobbits;
    }

        // Accept HTTP POST, localhost:8080/hobbits
        @PostMapping("/hobbits")
        Hobbit post(@RequestBody Hobbit hobbit){
        /*
                Add a new Hobbit to the list.
         */
            hobbits.add(hobbit);
            // Return the last hobbit from the list
            return hobbits.get(hobbits.size()-1);
        }

        // Accept HTTP DELETE, localhost:8080/hobbits
        @DeleteMapping("/hobbits/{id}")
        void delete(@PathVariable int id){
            hobbits.remove(id);
        }
    /* on chrome; search localhost:8080/hobbits [the get mapping name] to see the below output with our endpoint

       {
            "name": "Frodo",
            "lastName": "Baggins"
        }

     */

    // Create, Read, Update, Delete = POST, GET, PUT, DELETE in http methods
}
