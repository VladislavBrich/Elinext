package com.example.elinext.repositories;

import com.example.elinext.dto.UniversityDto;
import com.example.elinext.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepo extends JpaRepository<University, Long> {
    Boolean existsByUniversityName(String name);

    @Query("SELECT s FROM University s" +
            " WHERE :isFiltered=False " +
            " OR LOWER (s.universityName)=LOWER(CONCAT('%',:filter,'%')) " +
            "order by s.universityName DESC ")
    List<University> findAllByFilter(boolean isFiltered, String filter);

}
