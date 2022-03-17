package com.rode.foro.services;

import com.rode.foro.model.Modules;
import com.rode.foro.repositories.ModulesRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class TemaServiceImpl implements TemaService {

    private ModulesRepository modulesRepository;

    public TemaServiceImpl(ModulesRepository modulesRepository) {
        this.modulesRepository = modulesRepository;
    }

    @Override
    public List<Modules> retornaModulos() {
        return modulesRepository.findAll();
    }
}
