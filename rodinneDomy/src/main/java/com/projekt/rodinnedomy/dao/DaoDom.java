package com.projekt.rodinnedomy.dao;

import com.projekt.rodinnedomy.model.Dom;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class DaoDom {
    private final DataSource dataSource;

    public DaoDom(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public Dom findById(int id) { //prijma id a vráti objekt Dom ak existuje
        Dom dom = null; //inicializácia premennej dom
        String sql = "SELECT * FROM dom WHERE id = ?"; //Pripravený SQL dotaz na tabilku dom s parametrom id
        try (Connection conn = dataSource.getConnection();
            PreparedStatement  stmt = conn.prepareStatement(sql)) {//otvárame pripraveny SQL dotaz

                stmt.setInt(1, id);// dosádzame do parametra ? hodnotu id
                ResultSet rs = stmt.executeQuery(); // spúšťame SQL dotaz

            if (rs.next()) { //kontrola či rseult obsahuje aspoň jeden riadok
                dom = new Dom();// vytvorím nový objekt dom ktorý naplníme údajmi nižšie.
                dom.setId(rs.getInt("id"));
                dom.setUlica(rs.getString("ulica"));
                dom.setCisloDomu(rs.getInt("cislo_domu"));
                dom.setMesto(rs.getString("mesto"));
                dom.setFarba(rs.getString("farba"));
                dom.setZahrada(rs.getBoolean("zahrada"));
            }
        } catch (SQLException e) { //zachytenie chyby pri prácis databázou
            e.printStackTrace();
        }
        return dom;
    }
}


