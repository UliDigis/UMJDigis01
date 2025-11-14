package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.DAO;

import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Result;

public interface IMunicipioJPA {

    Result GetAll();
    
    Result GetByEstado(int IdEstado);
    
}
