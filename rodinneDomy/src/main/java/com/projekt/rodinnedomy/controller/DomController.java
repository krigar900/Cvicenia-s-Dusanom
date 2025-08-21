package com.projekt.rodinnedomy.controller;
import com.projekt.rodinnedomy.model.Dom;
import com.projekt.rodinnedomy.service.ServiceDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //hovori springu ze toto ej kontroler a vracia JSON
@RequestMapping("api/Dom") // základna URL cesat pre Cotroller

public class DomController {

    private final ServiceDom serviceDom; //vytvorenie konst premennej pre metodu na ziskavanie dat

    @Autowired //hovori stringu ze ma automaticky vlozit bean ServiceDom. Vi voalt metody z celej vsrtvy service
    public DomController(ServiceDom serviceDom) {
        this.serviceDom = serviceDom;
    }

    @GetMapping("/{id}")
    public Dom getDom(@PathVariable int id) {
        return serviceDom.getDomById(id);
    }

    @GetMapping("/all")
    public List<Dom> findAll() {
        return serviceDom.findAll();
    }

    @PostMapping
    public int create(@RequestBody Dom dom) {
        return serviceDom.createDom(dom);
    }

    @PutMapping("/{id}")
    public int update(@RequestBody Dom dom) {
       return serviceDom.updateDom(dom);
    }

}
