package com.alok.msscbeerservice.web.controller;

import com.alok.msscbeerservice.service.BeerService;
import com.alok.msscbeerservice.web.model.BeerDto;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/beer")
@Slf4j
@RequiredArgsConstructor
public class BeerController {
    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId) throws NotFoundException {
        log.info("Get beer by id is calling...");
        return new ResponseEntity<>(beerService.getById(beerId), OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto){
 log.info("Post beer is calling");
        return new ResponseEntity(beerService.saveNewBeer(beerDto), CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId")UUID beerId,
                                         @RequestBody @Validated BeerDto beerDto) throws NotFoundException {

        log.info("Update beer is calling  ");
        return new ResponseEntity(beerService.updateBeer(beerId, beerDto), NO_CONTENT);
    }

}
