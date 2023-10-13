package com.delivery.service;

import com.delivery.dto.AreaDto;
import com.delivery.entity.Area;
import com.delivery.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;

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
}
