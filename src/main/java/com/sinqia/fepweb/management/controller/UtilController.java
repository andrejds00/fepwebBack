package com.sinqia.fepweb.management.controller;

import com.sinqia.fepweb.management.dto.EnderecoCepDTO;
import com.sinqia.fepweb.management.service.UtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/util")
public class UtilController {

    private final Logger log = LoggerFactory.getLogger(UtilController.class);

    @Autowired
    private UtilService utilService;

    @GetMapping("/buscar-cep/{cep}")
    public EnderecoCepDTO buscarCep(@PathVariable("cep") String cep) {
        return this.utilService.getCep(cep);
    }

}
