package com.canberkduman.proje.service;

import com.canberkduman.proje.dto.SirketDto;

import java.util.List;

public interface SirketService {
    SirketDto createPersonel(SirketDto sirketDto);

    List<SirketDto> getSirketler();

    SirketDto getSirket(Long id);

    SirketDto updateSirket(Long id, SirketDto sirketDto);

    Boolean deleteSirket(Long id);
}
