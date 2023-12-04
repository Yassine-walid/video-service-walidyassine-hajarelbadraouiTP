package com.example.videoservicewalidyassinehajarelbadraoui.Dao.Repositories;

import com.example.videoservicewalidyassinehajarelbadraoui.Dao.Entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CreatorRepository extends JpaRepository<Creator,Long> {
}
