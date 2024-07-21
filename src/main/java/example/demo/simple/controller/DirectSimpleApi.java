package example.demo.simple.controller;

import example.demo.simple.entity.Simple;
import example.demo.simple.repository.SimpleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("simple")
public final class DirectSimpleApi {
    private final SimpleRepository simpleRepository;

    @GetMapping("/{key}")
    public Simple get(@PathVariable String key) {
        return simpleRepository.findById(key)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Simple set(@RequestBody Simple entity) {
        return simpleRepository.save(entity);
    }
}
