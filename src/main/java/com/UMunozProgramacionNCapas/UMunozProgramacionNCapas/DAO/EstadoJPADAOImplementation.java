package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.DAO;

import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Result;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.JPA.EstadoJPA;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Estado;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.Service.EstadoMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EstadoJPADAOImplementation {

    @Autowired
    private EntityManager entityManager;
    private EstadoMapper estadoMapper;
    
    public Result GetAll(){
        Result result = new Result();
        
        try{
            
            TypedQuery<EstadoJPA> queryEstado = entityManager.createQuery("FROM EstadoJPA ORDEN BY IdEstado", EstadoJPA.class);
            
            List<EstadoJPA> estadoJPA = queryEstado.getResultList();
            result.Objects = new ArrayList<>();
            
            for(EstadoJPA resultEstadoJPA : estadoJPA){
                Estado estado = estadoMapper.toModel(resultEstadoJPA);
            }
            
            
        }catch(Exception ex){
            
        }
        
        return result;
    }
    
    
}
