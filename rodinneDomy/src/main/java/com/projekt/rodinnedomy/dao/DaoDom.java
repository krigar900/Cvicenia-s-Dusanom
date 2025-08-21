package com.projekt.rodinnedomy.dao;

import com.projekt.rodinnedomy.model.Dom;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
            return jdbcTemplate.queryForObject(sql, (RowMapper<Dom>)(resultSet, i) -> { // Metóda JdbcTemplate, ktorá očakáva presne jeden výsledok
                Dom dom = new Dom();
                dom.setId(resultSet.getInt("id"));
                dom.setUlica(resultSet.getString("ulica"));
                dom.setCisloDomu(resultSet.getInt("cislo_domu"));
                dom.setMesto(resultSet.getString("mesto"));
                dom.setFarba(resultSet.getString("farba"));
                dom.setZahrada(resultSet.getBoolean("zahrada"));
                return dom;
            },id); //dosadeny parameter id
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Nenašiel sa záznma s ID " + id);}


    }

    public Dom create(Dom dom) {
        String sql = "INSERT INTO dom (ulica, cislo_domu, mesto, farba, zahrada) VALUES (?, ?, ?, ?, ?) RETURNING "; //po vložení vráti celý riadok vrátane id domu
        try {
            return jdbcTemplate.queryForObject(sql, (RowMapper<Dom>) (resultSet, i) -> {
                Dom domN = new Dom();
                domN.setUlica(resultSet.getString("ulica"));
                domN.setCisloDomu(resultSet.getInt("cislo_domu"));
                domN.setMesto(resultSet.getString("mesto"));
                domN.setFarba(resultSet.getString("farba"));
                domN.setZahrada(resultSet.getBoolean("zahrada"));
                return domN;
            },dom.getUlica(), dom.getCisloDomu(), dom.getMesto(), dom.getFarba(), dom.isZahrada());
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Nepodarilo sa vytvoriť dom", e);}
    }







}