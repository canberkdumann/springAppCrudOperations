package com.canberkduman.proje.controller;

import com.canberkduman.proje.dto.SirketDto;
import com.canberkduman.proje.service.SirketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sirket")
public class SirketController {

    private final SirketService sirketService;

    public SirketController(SirketService sirketService) {
        this.sirketService = sirketService;
    }

    @PostMapping("/create")
    public ResponseEntity<SirketDto> createPersonel(@RequestBody SirketDto sirketDto) {
        SirketDto sirket = sirketService.createPersonel(sirketDto);
        return new ResponseEntity<>(sirket, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SirketDto>> getSirketler () {
        List<SirketDto> sirketler = sirketService.getSirketler();
        return ResponseEntity.ok(sirketler);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<SirketDto> getSirket(@PathVariable("id") Long id) {
        SirketDto sirket = sirketService.getSirket(id);
        return ResponseEntity.ok(sirket);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SirketDto> updateSirket(@PathVariable("id") Long id, @RequestBody SirketDto sirketDto) {
        SirketDto updateSirket = sirketService.updateSirket(id, sirketDto);
        return ResponseEntity.ok(updateSirket);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteSirket(@PathVariable("id") Long id) {
        Boolean deleteSirket = sirketService.deleteSirket(id);
        return ResponseEntity.ok(deleteSirket);
    }
}
