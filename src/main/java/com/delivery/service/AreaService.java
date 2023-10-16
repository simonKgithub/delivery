package com.delivery.service;

import com.delivery.dto.AreaDto;
import com.delivery.dto.PlaceDto;
import com.delivery.entity.Area;
import com.delivery.entity.Place;
import com.delivery.repository.AreaRepository;
import com.delivery.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;
    private final PlaceService placeService;

    public List<AreaDto> findAll() {
        return areaRepository.findAll()
                .stream()
                .map(a -> AreaDto.of(a))
                .collect(Collectors.toList());
    }

    public AreaDto save(AreaDto areaDto) {
        Area area = new Area();
        area.setAreaNm(areaDto.getAreaNm());
        area.setAreaManager(areaDto.getAreaManager());
        Area savedArea = areaRepository.save(area);

        return AreaDto.of(savedArea);
    }

    public void deleteArea(List<AreaDto> areaDtoList) {
        //관련 place 삭제 => area 삭제
        areaDtoList.forEach( areaDto -> {
            Area area = this.areaToDto(areaDto);

            List<PlaceDto> placeDtoList = placeService.findPlacesWithNews(area.getAreaId());
            placeDtoList.forEach(placeDto -> {
                placeService.deletePlace(placeDto);
            });

            areaRepository.delete(area);
        });
    }

    public static Area areaToDto(AreaDto areaDto) {
        Area area = new Area();
        area.setAreaId(areaDto.getAreaId());
        area.setAreaNm(areaDto.getAreaNm());
        area.setAreaManager(areaDto.getAreaManager());
        return area;
    }
}
