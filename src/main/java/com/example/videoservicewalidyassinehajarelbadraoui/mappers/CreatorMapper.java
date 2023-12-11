package com.example.videoservicewalidyassinehajarelbadraoui.mappers;

import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Entities.Creator;
import com.example.videoservicewalidyassinehajarelbadraoui.dtos.CreatorRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CreatorMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Creator fromCreatorRequestToCreator(CreatorRequest creatorRequest) {
        return this.modelMapper.map(creatorRequest, Creator.class);
    }

    public CreatorRequest fromCreatorToCreatorRequest(Creator creator) {
        return this.modelMapper.map(creator, CreatorRequest.class);
    }
}
