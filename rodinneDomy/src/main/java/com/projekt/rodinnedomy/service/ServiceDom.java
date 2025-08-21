package com.projekt.rodinnedomy.service;

import com.projekt.rodinnedomy.dao.DaoDom;
import com.projekt.rodinnedomy.model.Dom;
import org.springframework.stereotype.Service;

import java.util.List;

//Obsahuje  biznis logiku a vlidácie.

@Service
public class ServiceDom {
    private final DaoDom daoDom;

    public ServiceDom(DaoDom daoDom) {
        this.daoDom = daoDom;
    }

    public Dom getDomById(int id) {
        Dom dom = daoDom.findById(id);
        if (dom == null) {
            throw new RuntimeException("Dom s ID "+id+" neexistuje");
        }
        return dom;
    }

    public int createDom(Dom dom) {
        return daoDom.create(dom);
    }

    public int updateDom(Dom dom) {
        Dom oDom = daoDom.findById(dom.getId());
        if (oDom == null) {
            throw new RuntimeException("Dom s ID " + dom.getId() + " neexistuje");
        }
        return daoDom.update(dom);
    }

    public List<Dom> findAll() {
        return daoDom.findAll();
    }


}
