package com.codecool.jpaseries.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private SeasonTitle seasonTitle;

    private int releaseYear;

    @Transient
    @OneToMany(mappedBy = "season")
    private List<Episode> episodes;

    @ManyToOne
    @JoinColumn(name = "SERIES_ID")
    private Series series;


}
