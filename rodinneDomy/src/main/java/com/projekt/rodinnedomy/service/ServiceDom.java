package com.projekt.rodinnedomy.service;

import com.projekt.rodinnedomy.dao.DaoDom;
import com.projekt.rodinnedomy.model.Dom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDom {
    private final DaoDom daoDom;

    public ServiceDom(DaoDom daoDom) {
        this.daoDom = daoDom;
    }

    public List<Dom> findAll() {
        return daoDom.findAll();
    }

    public Dom getDomById(int id) {return daoDom.findById(id);}

    public int createDom(Dom dom) {return daoDom.createDom(dom);}

    public int updateDom(Dom dom) {
        if (dom.getId() == 0) {
            throw new IllegalArgumentException("ID domu musí byť zadané pre update");
        }
        return daoDom.updateDom(dom);
    }


}
