package uz.project.brewery.brewery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/brewery")
@RequiredArgsConstructor
@Slf4j
class BreweryController {
    private final BreweryService breweryService;

    @GetMapping
    ResponseEntity<Set<Brewery>> getAllBrewery() {
        log.debug("fetAllBrewery call");
        return ResponseEntity.ok(breweryService.getAll());
    }

}
