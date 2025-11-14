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
public class EstadoJPADAOImplementation implements IEstadoJPA{

    @Autowired
    private EntityManager entityManager;
    private EstadoMapper estadoMapper;
    
    Result result = new Result();
    public Result GetAll(){
        
        
        try{
            
            TypedQuery<EstadoJPA> queryEstado = entityManager.createQuery("FROM EstadoJPA ORDEN BY IdEstado", EstadoJPA.class);
            
            List<EstadoJPA> estadoJPA = queryEstado.getResultList();
            result.Objects = new ArrayList<>();
            
            for(EstadoJPA resultEstadoJPA : estadoJPA){
                Estado estado = estadoMapper.toModel(resultEstadoJPA);
                result.Objects.add(estado);
            }
            result.Correct = true;
            
            
        }catch(Exception ex){
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.Objects = null;
        }
        
        return result;
    }
    
    public Result GetByPais(int IdPais){
        
        try{
            
        TypedQuery<EstadoJPA> queryEstado = entityManager.createQuery("FROM EstadoJPA e WHERE e.Pais.IdPais = :IdPais", EstadoJPA.class);
        queryEstado.setParameter("IdPais", IdPais);
        
        List<EstadoJPA> estadoJPA = queryEstado.getResultList();
        
        result.Object = new ArrayList<>();
        for( EstadoJPA resultEstadoJPA : estadoJPA){
        Estado estado = estadoMapper.toModel(resultEstadoJPA);
        result.Objects.add(estado);
        }       
        result.Correct = true;
        }catch(Exception ex){
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
        }
        return result;
    }
    
    
}
