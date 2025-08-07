package com.projekt.rodinnedomy.controller;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")

public class TodoController {



    //získaj všetky úlohy
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    //filtorvanie podľa completed a priority
    @GetMapping("/filter")
    public List<Todo> FilterTodos(
            @RequestParam(required = false) Boolean completed,
            @RequestParam(required = false) Priority priority
    ) {

    }

    //Vytvor úlohu podľa ID
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }


    //Aktualizuj úlohu podľa ID
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {

    }

    //Vymaž úlohu
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {


}
