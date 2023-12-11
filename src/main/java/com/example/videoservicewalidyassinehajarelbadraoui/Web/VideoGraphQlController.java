package com.example.videoservicewalidyassinehajarelbadraoui.Web;


import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Entities.Creator;
import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Entities.Video;
import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Repositories.CreatorRepository;
import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Repositories.VideoRepository;
import com.example.videoservicewalidyassinehajarelbadraoui.dtos.CreatorRequest;
import com.example.videoservicewalidyassinehajarelbadraoui.services.CreatorManager;
import com.example.videoservicewalidyassinehajarelbadraoui.services.VideoManager;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Controller
public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;

    private CreatorManager creatorManager;
    private VideoManager videoManager;


    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }

    @QueryMapping
    public List<Video> videoList() {
        return videoRepository.findAll();
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Creator %s not found", id)));
    }

    @MutationMapping
    public Creator saveCreator(@Argument Creator creator) {
        return creatorRepository.save(creator);
    }

    @MutationMapping
    public Video saveVideo(@Argument Video video) {
        return videoRepository.save(video);
    }

    @SubscriptionMapping
    public Flux<Video> notifyVideoChange() {
        return Flux.fromStream(
                Stream.generate(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Random random = new Random();
                    CreatorRequest creatorRequest = CreatorRequest.builder().name("x" +
                                    new Random().nextInt())
                            .email("x@gmail.com").build();
                    Creator creator = creatorManager.saveCreator(creatorRequest);
                    Video video = videoManager.findById(1L);
                    video.setCreator(creator);
                    videoManager.updateVideo(video);
                    return video;
                }));

    }

}

