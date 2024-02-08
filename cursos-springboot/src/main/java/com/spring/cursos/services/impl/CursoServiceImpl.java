package com.spring.cursos.services.impl;

import com.spring.cursos.entities.Curso;
import com.spring.cursos.repository.CursoRepository;
import com.spring.cursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public List<Curso> obtenerTodas(){
        return cursoRepository.findAll();
    }
    @Override
    public Curso obtenerPorId(Long id){
        return cursoRepository.findById(id).orElse(null);
    }
    @Override
    public Curso crearCurso(Curso curso){
        return cursoRepository.save(curso);
    }
    @Override
    public Curso actualizarCurso(Long id, Curso curso){
        Curso cursoBBDD = cursoRepository.findById(id).orElse(null);
        if(cursoBBDD != null){
            cursoBBDD.setDescripcion(curso.getDescripcion());
            cursoBBDD.setTitulo(curso.getTitulo());
            cursoBBDD.setNivel(curso.getNivel());
            return cursoRepository.save(cursoBBDD);
        }
        return null;
    }
    @Override
    public void eliminarCurso(Long id){
        cursoRepository.deleteById(id);
    }
    @Override
    public long contarCursos(){
        return cursoRepository.count();
    }
}
