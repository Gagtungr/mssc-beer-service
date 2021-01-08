package guru.springframework.msscbeerservice.web.controller;

import guru.springframework.msscbeerservice.web.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(BeerController.BEER_BASE_URL)
@RestController
public class BeerController {

    public static final String BEER_BASE_URL = "/api/v1/beer";

    @GetMapping("/{id}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable UUID id) {

        return new ResponseEntity(new BeerDTO().builder().beerName("GLARUS").build(),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerDTO beerDTO) {

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBeer(@PathVariable UUID id, @RequestBody BeerDTO beerDTO) {

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
