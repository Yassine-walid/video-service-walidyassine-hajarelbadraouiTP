package com.example.videoservicewalidyassinehajarelbadraoui.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CreatorRequest {
    private String name;
    private String email;
}
