package com.projekt.rodinnedomy.dao;

import com.projekt.rodinnedomy.dao.mapper.DomMapper;
import com.projekt.rodinnedomy.model.Dom;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//Komunikuje s databazou

@Repository
public class DaoDom {

    private final JdbcTemplate jdbcTemplate;

    public DaoDom(JdbcTemplate jdbctemplate) {
        this.jdbcTemplate = jdbctemplate;
    }

    public Dom findById(int id) { //prijma id a vráti objekt Dom ak existuje
        String sql = "SELECT * FROM dom where id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new DomMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Nenašiel sa záznma s ID " + id);}


    }

    public List<Dom> findAll() {
        String sql = "SELECT * FROM dom";
        try {
            return jdbcTemplate.query(sql, new DomMapper());
        }catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Nenašli sa žiadne záznamy");
        }
    }

    public int create(Dom dom) {
        String sql = "INSERT INTO dom (ulica, cislo_domu, mesto, farba, zahrada) VALUES (?, ?, ?, ?, ?) RETURNING id "; //po vložení vráti celý riadok vrátane id domu
        try {
            return jdbcTemplate.update(
                    sql,
                    Integer.class,
                    dom.getUlica(),
                    dom.getCisloDomu(),
                    dom.getMesto(),
                    dom.getFarba(),
                    dom.isZahrada()
            );
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Nepodarilo sa vytvoriť dom", e);}
    }


    public int update(Dom dom) {
        String sql = "UPDATE dom SET ulica = ?, cislo_domu = ?, mesto = ?, farba = ?, zahrada = ? WHERE id = ?";
        try {
            return jdbcTemplate.update(
                    sql,
                    dom.getUlica(),
                    dom.getCisloDomu(),
                    dom.getMesto(),
                    dom.getFarba(),
                    dom.isZahrada(),
                    dom.getId()
            );
        } catch (Exception e) {
            throw new RuntimeException("Chyba pri aktualizácii domu s ID " + dom.getId(), e);
        }
    }


    public int delete(int id) {
        String sql = "DELETE FROM dom WHERE id = ?";
        try {
            return jdbcTemplate.update(sql, id);
        }catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Nepodarilo sa vymazat dom s ID " + id, e);
        }
    }

    //Vyhľadávanie podľa ľubovońého parametra
    public List<Dom> findBy(String parameter, String value) {
        String sql = "SELECT * FROM dom WHERE " + parameter + " = ?";
        try {
            return jdbcTemplate.query(sql, new DomMapper(), value);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Nenašli sa dáta.", e);
        }
    }


}