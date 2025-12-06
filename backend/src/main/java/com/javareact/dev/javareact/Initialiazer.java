package com.javareact.dev.javareact;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.javareact.dev.javareact.model.Group;
import com.javareact.dev.javareact.model.Todo;
import com.javareact.dev.javareact.repository.GroupRepository;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Backend", "Frontend").forEach(name ->
                repository.save(new Group(name))
        );

        Group todo = repository.findByName("Backend");
        Todo e = Todo.builder().title("Backend in Java")
                .description("Using Spring Boot Framework")
                .date(Instant.parse("2022-09-13T17:00:00.000Z"))
                .completed(false)
                .build();
        todo.setTodo(Collections.singleton(e));
        repository.save(todo);

        repository.findAll().forEach(System.out::println);
    }
}
