package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.DAO;

import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Result;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Colonia;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.JPA.ColoniaJPA;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.Service.ColoniaMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ColoniaJPADAOImplementation {
    
    @Autowired
    private EntityManager entityManager;
    private ColoniaMapper coloniaMapper;
    
    Result result = new Result();
    public Result GetAll(){
        
        try{
            TypedQuery<ColoniaJPA> queryColonia = entityManager.createQuery("FROM ColiniaJPA ORDEN BY IdColonia", ColoniaJPA.class);
            
            List<ColoniaJPA> coloniaJPA = queryColonia.getResultList();
            result.Objects = new ArrayList<>();
            
            for (ColoniaJPA resultColoniaJPA : coloniaJPA){
                
                Colonia colonia = coloniaMapper.toModel(resultColoniaJPA);
                result.Objects.add(colonia);
            }
            result.Correct = true;
        }catch(Exception ex){
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.Objects = null;
        }
        
        return result;
    }
    
    public Result GetByMunicipio(int IdMunicipio){
        
        try{
        TypedQuery<ColoniaJPA> queryColonia = entityManager.createQuery("FROM ColoniaJPA c WHERE c.Municipio.IdMunicipio = :IdMunicipio", ColoniaJPA.class);
        queryColonia.setParameter("IdMunicipio",IdMunicipio);
        
        List<ColoniaJPA> coloniaJPA= queryColonia.getResultList();
        result.Objects = new ArrayList<>();
        
        for(ColoniaJPA resultColoniaJPA : coloniaJPA){
        Colonia colonia = coloniaMapper.toModel(resultColoniaJPA);
        result.Objects.add(colonia);
        }
        
        result.Correct = true;
        
        }catch(Exception ex){
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.Object = null;
        }
        
        
        return result;
    }
    
}
