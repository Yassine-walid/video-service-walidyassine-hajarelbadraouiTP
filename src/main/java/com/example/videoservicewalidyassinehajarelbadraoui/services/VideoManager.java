package com.example.videoservicewalidyassinehajarelbadraoui.services;

import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Entities.Creator;
import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Entities.Video;
import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Repositories.CreatorRepository;
import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Repositories.VideoRepository;
import com.example.videoservicewalidyassinehajarelbadraoui.dtos.CreatorRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Random;

@Component
public class VideoManager {
    private CreatorManager creatorManager;
    private VideoManager videoManager;

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private CreatorRepository creatorRepository;


    public List<Video> videoList() {
        return videoRepository.findAll();
    }

    public Video saveVideo(Video video) {
        creatorRepository.save(video.getCreator());
        return videoRepository.save(video);
    }

    public Video findById(Long id) {
        return videoRepository.findById(id).get();
    }

    public Video updateVideo(Video video) {
        return videoRepository.save(video);

    }

}
