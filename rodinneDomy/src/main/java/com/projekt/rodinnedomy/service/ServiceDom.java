package com.projekt.rodinnedomy.service;

import com.projekt.rodinnedomy.dao.DaoDemo;
import com.projekt.rodinnedomy.dao.DaoDom;
import com.projekt.rodinnedomy.model.Dom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDom {
    private final DaoDom daoDom;
    private final DaoDemo daoDemo;

    public ServiceDom(DaoDom daoDom, DaoDemo daoDemo) {
        this.daoDom = daoDom;
        this.daoDemo = daoDemo;
    }

    public List<Dom> findAll() {
        return daoDom.findAll();
    }

    public Dom getDomById(int id) {return daoDom.findById(id);}

    public Dom createDom(Dom dom) {
        Integer id = daoDemo.createDom(dom);
        dom.setId( id);
        return dom;
    }

    public int updateDom(Dom dom) {
        if (dom.getId() == 0) {
            throw new IllegalArgumentException("ID domu musí byť zadané pre update");
        }
        return daoDom.updateDom(dom);
    }


}
