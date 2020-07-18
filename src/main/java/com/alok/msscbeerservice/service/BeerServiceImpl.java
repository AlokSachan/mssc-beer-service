package com.alok.msscbeerservice.service;

import com.alok.msscbeerservice.domain.Beer;
import com.alok.msscbeerservice.repositories.BeerRepository;
import com.alok.msscbeerservice.web.mapper.BeerMapper;
import com.alok.msscbeerservice.web.model.BeerDto;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.io.NotActiveException;
import java.util.UUID;

@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;


    @Override
    public BeerDto getById(UUID beerId) throws NotFoundException {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(()-> new NotFoundException(beerId.toString()))
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(
                beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) throws NotFoundException {
        Beer beer = beerRepository.findById(beerId).orElseThrow(()-> new NotFoundException(beerId.toString()));
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
