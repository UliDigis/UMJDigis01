package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.DAO;

import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Result;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioJPADAOImplementation implements IUsuarioJPA {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Result GetAllJPA() {

        Result result = new Result();
        
        try{
            
            TypedQuery<Usuario> queryUsuario = entityManager.createQuery("From Usuario", Usuario.class);
            List<Usuario> usuario = queryUsuario.getResultList();
            
            result.Correct = true;
            
        }catch(Exception ex){
            result.Correct = false;
            result.ErrorMessage = ex.getMessage();
            result.ex = ex;
            result.Object = null;
        }
        
        return result;
    }

}
