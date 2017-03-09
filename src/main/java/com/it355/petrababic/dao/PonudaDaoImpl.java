/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.petrababic.dao;

import com.it355.petrababic.mapper.PonudaMapper;
import com.it355.petrababic.model.Ponuda;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ko
 */
public class PonudaDaoImpl implements PonudaDao {

    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unused")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) dataSource);
    }

    @Override
    public boolean addPonuda(Ponuda ponuda) {
        String sql = "INSERT INTO PONUDA "
                + "(NASLOV,KOLICINA_PONUDE) VALUES (?,?)";
        jdbcTemplate.update(sql, new Object[]{ponuda.getNaslov(),ponuda.getKolicina()});
        return true;
    }

    @Override
    @Transactional
    public List<Ponuda> getAllPonude() {
        String sql = "SELECT * FROM PONUDA";
        List<Ponuda> ponude = jdbcTemplate.query(sql, new PonudaMapper());
        return ponude;
    }

}
