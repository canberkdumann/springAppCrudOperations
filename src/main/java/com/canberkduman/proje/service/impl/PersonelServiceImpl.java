package com.canberkduman.proje.service.impl;

import com.canberkduman.proje.dto.PersonelDto;
import com.canberkduman.proje.model.Personel;
import com.canberkduman.proje.repository.PersonelRepository;
import com.canberkduman.proje.service.PersonelService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PersonelServiceImpl implements PersonelService {

    private final PersonelRepository personelRepository;
    private final ModelMapper modelMapper;

    //ObjectMapper- ModelMapper

    public PersonelServiceImpl(PersonelRepository personelRepository, ModelMapper modelMapper) {
        this.personelRepository = personelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonelDto createPersonel(PersonelDto personelDto) {
        if (personelDto.getAdi().isEmpty() || personelDto.getAdi().isBlank())
            throw new RuntimeException("Personel Adı boş olamaz");
        Personel personel = modelMapper.map(personelDto, Personel.class);
        return modelMapper.map(personelRepository.save(personel), PersonelDto.class);
    }

    @Override
    public List<PersonelDto> getPersoneller() {
        List<Personel> personeller = personelRepository.findAll();
        if (!personeller.isEmpty()) {
            List<PersonelDto> personelList = personeller.stream()
                    .map(personel -> modelMapper.map(personel, PersonelDto.class))
                    .collect(Collectors.toList());
            return personelList;
        }
        throw new RuntimeException("Kayırlı şirket bulunamadı");
    }

    @Override
    public PersonelDto getPersonel(Long id) {
        Personel personel = personelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personel bulunamadı. Girilen değer: " + id)); //Optional sınıf ve lambda kullanımı
        return modelMapper.map(personel, PersonelDto.class);
    }

    @Override
    public PersonelDto updatePersonel(Long id, PersonelDto personelDto) {
        Optional<Personel> getPersonel = personelRepository.findById(id);
        if (personelDto.getAdi().isEmpty() || personelDto.getAdi().isBlank())
            throw new RuntimeException("Personeel adı boş olamaz");
        else {
            getPersonel.get().setAdi(personelDto.getAdi());
            return modelMapper.map(personelRepository.save(getPersonel.get()), PersonelDto.class);
        }
    }

    @Override
    public Boolean deletePersonel(Long id) {
        Optional<Personel> getPersonel = personelRepository.findById(id);
        if (getPersonel.isPresent()) {
            personelRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("Girilen değer: " + id);
    }

}
