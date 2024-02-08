package com.spring.cursos.services;

import com.spring.cursos.entities.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> obtenerTodas();

    Curso obtenerPorId(Long id);

    Curso crearCurso(Curso curso);

    Curso actualizarCurso(Long id, Curso curso);

    void eliminarCurso(Long id);

    long contarCursos();
}
