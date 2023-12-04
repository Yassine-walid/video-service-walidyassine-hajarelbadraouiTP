package com.example.videoservicewalidyassinehajarelbadraoui.Dao.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id ;
    private String name;
    private String email ;

    @OneToMany(mappedBy = "creator",cascade = CascadeType.ALL)
    private List<Video> videos;
}