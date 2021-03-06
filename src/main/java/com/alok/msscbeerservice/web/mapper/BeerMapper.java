package com.alok.msscbeerservice.web.mapper;

import com.alok.msscbeerservice.domain.Beer;
import com.alok.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    Beer  beerDtoToBeer(BeerDto beerDto);

    BeerDto beerToBeerDto(Beer beer);
}
