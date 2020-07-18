package com.alok.msscbeerservice.service;

import com.alok.msscbeerservice.web.model.BeerDto;
import javassist.NotFoundException;

import java.util.UUID;

public interface BeerService {

    BeerDto getById(UUID beerId) throws NotFoundException;

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto) throws NotFoundException;
}
