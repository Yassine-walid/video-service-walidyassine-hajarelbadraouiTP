package com.example.videoservicewalidyassinehajarelbadraoui.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VideoRequest {
    private String name;
    private String url;
    private String description;
    private Date datePublication;
}
