package dk.sdu.mmmi.cbse.scoringsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Scoring {

    private final Logic handler;

    public Scoring(Logic handler) {
        this.handler = handler;
    }

    public static void main(String[] args) {
        SpringApplication.run(Scoring.class, args);
    }

    @GetMapping("/score")
    public ResponseEntity<String> update(@RequestParam(name = "score") Integer score) {
        int result = handler.set(score);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @GetMapping(value = "/score/current", produces = "text/plain")
    public String fetch() {
        return String.valueOf(handler.get());
    }
}