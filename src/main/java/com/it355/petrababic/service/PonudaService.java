/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.petrababic.service;

import com.it355.petrababic.model.Ponuda;
import java.util.List;

/**
 *
 * @author ko
 */
public interface PonudaService {
     public boolean addPonuda(Ponuda ponuda);
    public List<Ponuda> getAllPonude();
}
