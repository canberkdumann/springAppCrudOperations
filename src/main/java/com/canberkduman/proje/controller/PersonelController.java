package com.canberkduman.proje.controller;

import com.canberkduman.proje.dto.PersonelDto;
import com.canberkduman.proje.service.PersonelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personel")
public class PersonelController {

    private final PersonelService personelService;

    public PersonelController(PersonelService personelService) {
        this.personelService = personelService;
    }

    @PostMapping("/create")
    public ResponseEntity<PersonelDto> createPersonel(@RequestBody PersonelDto personelDto) {
        PersonelDto personel = personelService.createPersonel(personelDto);
        return new ResponseEntity<>(personel, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PersonelDto>> getPersoneller() {
        List<PersonelDto> personeller = personelService.getPersoneller();
        return ResponseEntity.ok(personeller);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PersonelDto> getPersonel(@PathVariable("id") Long id) {
        PersonelDto personel = personelService.getPersonel(id);
        return ResponseEntity.ok(personel);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonelDto> updatePersonel(@PathVariable("id") Long id,
                                                      @RequestBody PersonelDto personelDto){
        PersonelDto updatePersonel = personelService.updatePersonel(id, personelDto);
        return ResponseEntity.ok(updatePersonel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePersonel(@PathVariable("id") Long id) {
        Boolean deletePersonel = personelService.deletePersonel(id);
        return ResponseEntity.ok(deletePersonel);
    }






}
