package com.projekt.rodinnedomy.dao;

import com.projekt.rodinnedomy.model.Dom;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class DaoDom {
    private final DataSource dataSource;

    public DaoDom(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<Dom> findAll() {
        List<Dom> domy = new ArrayList<>();
        String sql = "SELECT * FROM dom";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Dom dom = new Dom();
                dom.setId(rs.getInt("id"));
                dom.setUlica(rs.getString("ulica"));
                dom.setCisloDomu(rs.getInt("cislo_domu"));
                dom.setMesto(rs.getString("mesto"));
                dom.setFarba(rs.getString("farba"));
                dom.setZahrada(rs.getBoolean("zahrada"));

                domy.add(dom);
            }
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return domy;
        }



    public Dom findById(int id) { //prijma id a vráti objekt Dom ak existuje
        Dom dom = null; //inicializácia premennej dom
        String sql = "SELECT * FROM dom WHERE id = ?"; //Pripravený SQL dotaz na tabilku dom s parametrom id
        try (Connection conn = dataSource.getConnection();
            PreparedStatement  stmt = conn.prepareStatement(sql)) {//otvárame pripraveny SQL dotaz

                stmt.setInt(1, id);// dosádzame do parametra ? hodnotu id
                ResultSet rs = stmt.executeQuery(); // spúšťame SQL dotaz

            if (rs.next()) { //kontrola či result obsahuje aspoň jeden riadok
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

    public int createDom(Dom dom) {
        String sql = "INSERT INTO dom (ulica, cislo_domu, mesto, farba, zahrada) VALUES (?, ?, ?, ?, ?)"; //Vytvorenie sql dotazu

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))  {

                stmt.setString(1, dom.getUlica());
                stmt.setInt(2, dom.getCisloDomu());
                stmt.setString(3, dom.getMesto());
                stmt.setString(4, dom.getFarba());
                stmt.setBoolean(5, dom.isZahrada());
                return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateDom(Dom dom) {
        String sql = "UPDATE dom SET ulica = ?, cislo_domu = ?, mesto = ?, farba = ?, zahrada = ? WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dom.getUlica());
            stmt.setInt(2, dom.getCisloDomu());
            stmt.setString(3, dom.getMesto());
            stmt.setString(4, dom.getFarba());
            stmt.setBoolean(5, dom.isZahrada());
            stmt.setInt(6, dom.getId());

            return stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}


