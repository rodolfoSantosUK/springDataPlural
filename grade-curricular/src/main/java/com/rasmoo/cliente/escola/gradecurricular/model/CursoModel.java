package com.rasmoo.cliente.escola.gradecurricular.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CursoModel {

    private Long id;

    @NotBlank(message = "nome deve ser preenchido")
    @Size(min = 10, max = 30)
    private String nome;

    @NotBlank(message = "código deve ser preenchido")
    @Size(min = 2, max = 5)
    private String codCurso;

    private List<Long> materias;

}
