/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.petrababic.dao;

import java.util.List;
import com.it355.petrababic.model.Ponuda;

/**
 *
 * @author ko
 */
public interface PonudaDao {
    public boolean addPonuda(Ponuda ponuda);
    public List<Ponuda> getAllPonude();
}
