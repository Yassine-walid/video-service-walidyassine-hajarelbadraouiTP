package com.example.videoservicewalidyassinehajarelbadraoui.services;

import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Entities.Creator;
import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Repositories.CreatorRepository;
import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Repositories.VideoRepository;
import com.example.videoservicewalidyassinehajarelbadraoui.dtos.CreatorRequest;
import com.example.videoservicewalidyassinehajarelbadraoui.mappers.CreatorMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CreatorManager {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private CreatorRepository creatorRepository ;
    @Autowired
    private CreatorMapper creatorMapper;



    public Creator creatorById(Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }

    public Creator saveCreator( CreatorRequest CreatorRequest){
        Creator creator  = creatorMapper.fromCreatorRequestToCreator(CreatorRequest);
        return creatorRepository.save(creator);
    }

    public CreatorRequest getCreator(Long id){
        Creator creator =  creatorRepository.findById(id).get();
        return this.creatorMapper.fromCreatorToCreatorRequest(creator);
    }
}
