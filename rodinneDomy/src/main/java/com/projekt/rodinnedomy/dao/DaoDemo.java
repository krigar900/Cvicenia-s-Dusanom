package com.projekt.rodinnedomy.dao;

import com.projekt.rodinnedomy.dao.mapper.DomMapper;
import com.projekt.rodinnedomy.model.Dom;
import com.projekt.rodinnedomy.model.exception.MojaException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.Optional;

public class DaoDemo {
    private final NamedParameterJdbcTemplate template;

    public DaoDemo(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public Dom findBy(int id) {
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", id);
        try {
            return template.queryForObject("SELECT * FROM dom WHERE id = ?", parameters, new DomMapper());
        } catch (IncorrectResultSizeDataAccessException e) {
            throw new MojaException("Nic som nenasiel");
        }
    }

    public Integer createDom(Dom dom) {
        String sql = "INSERT INTO dom (ulica, cislo_domu, mesto, farba, zahrada) VALUES (?, ?, ?, ?, ?) RETURNING id"; //Vytvorenie sql dotazu
        return Optional.ofNullable(template.queryForObject(sql,
                new DomMapper().toMap( dom),
                Integer.class)).orElse(-1);
    }
}
