package com.example.videoservicewalidyassinehajarelbadraoui.Dao.Repositories;

import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VideoRepository extends JpaRepository<Video,Long> {
}
