/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.petrababic.mapper;

import com.it355.petrababic.model.Ponuda;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ko
 */
public class PonudaMapper implements RowMapper<Ponuda>{

    @Override
    public Ponuda mapRow(ResultSet rs, int i) throws SQLException {
        Ponuda ponuda = new Ponuda();
        ponuda.setNaslov(rs.getString("naslov"));
        ponuda.setKolicina(rs.getDouble("kolicina_ponude"));
        return ponuda;
    }
    
}
