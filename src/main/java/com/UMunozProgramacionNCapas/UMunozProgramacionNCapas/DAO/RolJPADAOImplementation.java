package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.DAO;

import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Result;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Rol;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.JPA.RolJPA;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.Service.RolMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolJPADAOImplementation implements IRolJPA{
    
    @Autowired
    private EntityManager entityManager;
    
    @Autowired
    private RolMapper rolMapper;
    
    @Override
    public Result GetAll(){
        Result result = new Result();
        
        try{
            
            TypedQuery<RolJPA> queryRol = entityManager.createQuery("FROM RolJPA ORDER BY IdRol", RolJPA.class);
            
            List<RolJPA> rolJPA = queryRol.getResultList();
            result.Objects =new  ArrayList<>();
            for(RolJPA resultRolJPA : rolJPA){
                Rol rol = rolMapper.toModel(resultRolJPA);
                result.Objects.add(rol);
            }
            
            result.Correct = true;
 
        }catch(Exception ex){
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        
        return result;
    }
    
}
