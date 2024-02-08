package com.spring.cursos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título del curso es obligatorio")
    @Size(min = 2, max = 128, message = "El título del curso debe tener entre 2 y 128 caracteres")
    @Column(length = 128, nullable = false)
    private String titulo;

    @Size(max = 100, message = "La descripción del curso no puede exceder los 100 caracteres")
    @Column(length = 26)
    private String descripcion;

    @NotNull(message = "El nivel del curso es obligatorio")
    @Min(value = 1, message = "El nivel del curso debe ser al menos 1")
    @Max(value = 10, message = "El nivel del curso no puede ser mayor que 10")
    @Column(nullable = false)
    private int nivel;


    @Column(name = "estado_publicacion")
    private boolean isPublicado;
}
