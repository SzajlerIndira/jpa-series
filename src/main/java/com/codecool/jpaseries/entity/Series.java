package com.codecool.jpaseries.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Transient
    @OneToMany(mappedBy = "series")
    private List<Season> seasons;

    @ElementCollection
    private List<String> genre;

}
