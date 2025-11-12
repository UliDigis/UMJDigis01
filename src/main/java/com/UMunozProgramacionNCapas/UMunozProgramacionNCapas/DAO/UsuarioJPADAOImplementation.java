package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.DAO;

import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Result;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Usuario;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Rol;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.JPA.UsuarioJPA;
import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.Service.UsuarioMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioJPADAOImplementation implements IUsuarioJPA {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public Result GetAllJPA() {
        Result result = new Result();

        try {
            TypedQuery<UsuarioJPA> queryUsuario = entityManager.createQuery(
                "FROM UsuarioJPA ORDER BY IdUsuario", UsuarioJPA.class
            );
            List<UsuarioJPA> usuariosJPA = queryUsuario.getResultList();

            result.Objects = new ArrayList<>();

            for (UsuarioJPA usuarioJPA : usuariosJPA) {
                Usuario usuario = usuarioMapper.toModel(usuarioJPA);

                if (usuario.rol == null) {
                    usuario.rol = new Rol();
                }

                if (usuario.Direcciones == null || usuario.Direcciones.isEmpty()) {
                    usuario.Direcciones = new ArrayList<>();
                }

                result.Objects.add(usuario);
            }

            result.Correct = true;

        } catch (Exception ex) {
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }
}
