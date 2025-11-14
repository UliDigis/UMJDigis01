package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.DAO;

import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Result;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Pais;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.JPA.PaisJPA;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.Service.PaisMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaisJPADAOImplementation implements IPaisJPA {

    @Autowired
    private EntityManager entityManager;
    private PaisMapper PaisMapper;

    public Result GetAll() {
        Result result = new Result();

        try {
            TypedQuery<PaisJPA> queryPais = entityManager.createQuery("FROM PaisJPA ORDEN BY IdPais", PaisJPA.class);

            List<PaisJPA> paisJPA = queryPais.getResultList();
            result.Objects = new ArrayList<>();
            for (PaisJPA resultPaisJPA : paisJPA) {
                Pais pais = PaisMapper.toModel(resultPaisJPA);
                result.Objects.add(pais);
            }
            result.Correct = true;
        } catch (Exception ex) {
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.Objects = null;
        }

        return result;
    }

}
