package com.canberkduman.proje.service;

import com.canberkduman.proje.dto.PersonelDto;

import java.util.List;

public interface PersonelService {
    PersonelDto createPersonel(PersonelDto personelDto);

    List<PersonelDto> getPersoneller();
    PersonelDto getPersonel(Long id);

    PersonelDto updatePersonel(Long id, PersonelDto personelDto);

    Boolean deletePersonel(Long id);


}
