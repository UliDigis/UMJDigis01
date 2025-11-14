package com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.DAO;

import com.UMunozProgramacionNCapas.UMunozProgramacionNCapas.ML.Result;

public interface IColoniaJPA {

    Result GetAll();
    
    Result GetByMunicipio(int Municipio);
    
}
