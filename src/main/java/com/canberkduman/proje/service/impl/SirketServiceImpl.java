package com.canberkduman.proje.service.impl;

import com.canberkduman.proje.dto.SirketDto;
import com.canberkduman.proje.model.Sirket;
import com.canberkduman.proje.repository.SirketRespository;
import com.canberkduman.proje.service.SirketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SirketServiceImpl implements SirketService {

    private final SirketRespository sirketRespository;

    private final ModelMapper modelMapper;

    public SirketServiceImpl(SirketRespository sirketRespository, ModelMapper modelMapper) {
        this.sirketRespository = sirketRespository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SirketDto createPersonel(SirketDto sirketDto) {
        if (sirketDto.getAdi().isEmpty() || sirketDto.getAdi().isBlank())
            throw new RuntimeException("Personel Adı boş olamaz");
        Sirket sirket = modelMapper.map(sirketDto, Sirket.class);
        return modelMapper.map(sirketRespository.save(sirket), SirketDto.class);
    }

    @Override
    public List<SirketDto> getSirketler() {
        List<Sirket> sirketler = sirketRespository.findAll();
        if (!sirketler.isEmpty()) {
            List<SirketDto> sirketList = sirketler.stream().map(sirket -> modelMapper.map(sirket, SirketDto.class))
                    .collect(Collectors.toList());
            return sirketList;
        }
        throw new RuntimeException("Kayırlı şirket bulunamadı");
    }

    @Override
    public SirketDto getSirket(Long id) {
        Sirket sirket = sirketRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Şirket bulunamadı. Girilen değer: + id"));
        return modelMapper.map(sirket, SirketDto.class);
    }

    @Override
    public SirketDto updateSirket(Long id, SirketDto sirketDto) {
        Optional<Sirket> getSirket = sirketRespository.findById(id);
        if (sirketDto.getAdi().isEmpty() || sirketDto.getAdi().isBlank())
            throw new RuntimeException("Şirket adı boş olamaz");
        else {
            getSirket.get().setAdi(sirketDto.getAdi());
            return modelMapper.map(sirketRespository.save(getSirket.get()), SirketDto.class);
        }
    }

    @Override
    public Boolean deleteSirket(Long id) {
        Optional<Sirket> getSirket = sirketRespository.findById(id);
        if (getSirket.isPresent()) {
            sirketRespository.deleteById(id);
            return true;
        }
        throw new RuntimeException("Girilen değer: " + id);
    }
}
