package com.rasmoo.cliente.escola.gradecurricular.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_curso")
@Data
@NoArgsConstructor
public class CursoEntity implements Serializable{

    private static final long serialVersionUID = -5115709874529054925L;

    @JsonInclude(Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @JsonInclude(Include.NON_EMPTY)
    @Column(name = "nome")
    private String nome;

    @JsonInclude(Include.NON_EMPTY)
    @Column(name = "cod")
    private String codigo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="materia_id")
    private List<MateriaEntity> materias;

}
