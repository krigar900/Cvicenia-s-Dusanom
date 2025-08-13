package com.projekt.rodinnedomy.controller;
import com.projekt.rodinnedomy.model.Dom;
import com.projekt.rodinnedomy.service.ServiceDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController //hovori springu ze toto ej kontroler a vracia JSON
@RequestMapping("api/Dom") // základna URL cesat pre Cotroller

public class DomController {

    private final ServiceDom serviceDom; //vytvorenie konst premennej pre metodu na ziskavanie dat

    @Autowired //hovori stringu ze ma automaticky vlozit bean ServiceDom. Vi voalt metody z celej vsrtvy service
    public DomController(ServiceDom serviceDom) {
        this.serviceDom = serviceDom;
    }

    @GetMapping("/{id}") //bude reagovat na http get pozaidavku/api/dom/{id}
    public ResponseEntity<Dom> getDomById(@PathVariable int id) { //Path variable vyberie hodtu id z URL a prida ju do premennej id
        Dom dom = serviceDom.getDomById(id);
        if (dom != null) {
            return ResponseEntity.ok(dom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Dom>> getAllDomy() {
        Iterable<Dom> domy = serviceDom.findAll();
        if (domy.iterator().hasNext()) {
            return ResponseEntity.ok(domy);
        }
    }
    
    @PostMapping
    public ResponseEntity<String> createDom(@RequestBody Dom dom) {
        int result = serviceDom.createDom(dom);
        if (result > 0) {
            return ResponseEntity.ok("Záznam bol vytvorený");
        } else {
            return ResponseEntity.ok("Nepodarilo sa vytvoriť záznam");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDom(@PathVariable int id,@RequestBody Dom dom ) {

        if (dom.getId()!= id) {
            return ResponseEntity.badRequest().body("ID v URL a v tele požiadavky sa nezhodujú");
        }

        int updatedRows = serviceDom.updateDom(dom);

        if (updatedRows > 0) {
            return ResponseEntity.ok("Dom bol úspešne aktualizovaný");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dom s daným ID neexistuje");
        }
    }
   }


