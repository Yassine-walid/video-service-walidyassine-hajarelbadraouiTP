package com.example.videoservicewalidyassinehajarelbadraoui.Web;


import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Entities.Creator;
import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Entities.Video;
import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Repositories.CreatorRepository;
import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Repositories.VideoRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;
    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository){
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }
    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }
    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }

    @MutationMapping
    public Creator saveCreator(@Argument Creator creator){
        return creatorRepository.save(creator) ;
    }
    @MutationMapping
    public Video saveVideo(@Argument Video video){
        return videoRepository.save(video) ;
    }

}

