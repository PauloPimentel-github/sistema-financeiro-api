package com.phpimentel.sistemafinanceiroapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phpimentel.sistemafinanceiroapi.dtos.LevelDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "levels")
public class LevelModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "level", nullable = false, unique = true, length = 25)
    private String level;

    public LevelDto convertToLevelDto() {
        var levelDto = new LevelDto();
        BeanUtils.copyProperties(this, levelDto);
        return levelDto;
    }
}
