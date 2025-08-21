package com.projekt.rodinnedomy.service;

import com.projekt.rodinnedomy.dao.DaoDom;
import com.projekt.rodinnedomy.model.Dom;
import org.springframework.stereotype.Service;

//Obsahuje  biznis logiku a vlidácie.

@Service
public class ServiceDom {
    private final DaoDom daoDom;

    public ServiceDom(DaoDom daoDom) {
        this.daoDom = daoDom;
    }

    public Dom getDomById(int id) {
        return daoDom.findById(id);
    }

    public Dom createDom(Dom dom) {
        return daoDom.create(dom);
    }

}
