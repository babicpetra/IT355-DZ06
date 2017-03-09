/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.petrababic.serviceImpl;
import com.it355.petrababic.dao.PonudaDao;
import com.it355.petrababic.model.Ponuda;
import com.it355.petrababic.service.PonudaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author ko
 */
public class PonudaServiceImpl implements PonudaService {

    @Autowired
    PonudaDao ponudaDao;
    
    @Override
    public boolean addPonuda(Ponuda ponuda) {
        return ponudaDao.addPonuda(ponuda);}

    @Override
    public List<Ponuda> getAllPonude() {
        return ponudaDao.getAllPonude();
    }
    
}
