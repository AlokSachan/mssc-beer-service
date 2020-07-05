package com.alok.msscbeerservice.web.controller;

import com.alok.msscbeerservice.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
@Slf4j
public class BeerController {
    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId")UUID beerId){
        log.info("Get is calling");
        return new ResponseEntity<>(BeerDto.builder().build(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto){
 log.info("Post is calling");
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId")UUID beerId,
                                         @RequestBody BeerDto beerDto){

        log.info("Update is calling  ");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
