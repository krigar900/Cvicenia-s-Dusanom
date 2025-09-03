package com.projekt.rodinnedomy.dao.mapper;


import com.projekt.rodinnedomy.model.Dom;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DomMapper implements RowMapper<Dom> {

    @Override
    public Dom mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dom dom = new Dom();// vytvorím nový objekt dom ktorý naplníme údajmi nižšie.
        dom.setId(rs.getInt("id"));
        dom.setUlica(rs.getString("ulica"));
        dom.setCisloDomu(rs.getInt("cislo_domu"));
        dom.setMesto(rs.getString("mesto"));
        dom.setFarba(rs.getString("farba"));
        dom.setZahrada(rs.getBoolean("zahrada"));

        return dom;
    }

    //Opačný mapper
    public Map<String, Object> toMap( Dom dom) {
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("id", dom.getId());
        parameters.put("ulica",dom.getUlica());
        parameters.put("cisloDomu",dom.getCisloDomu());
        parameters.put("mesto",dom.getMesto());
        parameters.put("farba",dom.getFarba());
        parameters.put("zahrada",dom.isZahrada());
        return parameters;
    }
}
