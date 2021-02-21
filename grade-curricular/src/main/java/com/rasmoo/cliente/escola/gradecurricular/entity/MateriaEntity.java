package com.rasmoo.cliente.escola.gradecurricular.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_materia")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class MateriaEntity extends RepresentationModel<MateriaEntity> implements Serializable {

    private static final Long serialVersionUID = 1L;

    @JsonInclude(Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @JsonInclude(Include.NON_EMPTY)
    @Column(name = "nome")
    private String nome;

    @Column(name = "hrs")
    private int horas;

    @JsonInclude(Include.NON_EMPTY)
    @Column(name = "cod")
    private String codigo;

    @Column(name = "freq")
    private int frequencia;
}
