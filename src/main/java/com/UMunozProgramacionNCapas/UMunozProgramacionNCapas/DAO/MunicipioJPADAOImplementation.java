package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.DAO;

import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Result;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Municipio;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.JPA.MunicipioJPA;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.Service.MunicipioMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MunicipioJPADAOImplementation implements IMunicipioJPA{

    @Autowired
    private EntityManager entityManager;
    private MunicipioMapper municipioMapper;
    
    Result result = new Result();
    public Result GetAll(){
        
        try{
        
            TypedQuery<MunicipioJPA> queryMunicipio = entityManager.createQuery("FROM MunicipioJPA ORDEN BY IdMunicipio", MunicipioJPA.class);
            
            List<MunicipioJPA> municipioJPA = queryMunicipio.getResultList();
            result.Objects = new ArrayList<>();
            
            for(MunicipioJPA resultMuniJPA : municipioJPA){
                Municipio municipio = municipioMapper.toModel(resultMuniJPA);
                result.Objects.add(municipio);
            }
            result.Correct = true;
        
        }catch(Exception ex){
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.Objects = null;
        }
        
        return result;
    }
    
    
    public Result GetByEstado(int IdEstado){
        
        
        try{
            
            TypedQuery<MunicipioJPA> queryMunicipio = entityManager.createQuery("FROM MunicipioJPA m WHERE m.Estado.IdEstado = :IdEstado", MunicipioJPA.class);
            queryMunicipio.setParameter("IdEsatdo",IdEstado);
            
            List<MunicipioJPA> municipioJPA = queryMunicipio.getResultList();
            
            result.Objects = new ArrayList<>
            
            result.Object = (municipio);
            result.Correct = true;
            
        }catch(Exception ex){
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.Object = null;
        }
        
        return result;
    }
    
}
