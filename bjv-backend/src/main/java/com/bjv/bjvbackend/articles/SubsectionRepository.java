package com.bjv.bjvbackend.articles;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubsectionRepository extends JpaRepository<Subsection, String> {
	
	 @Query(value = "SELECT * FROM subsections WHERE section_name = ?1", nativeQuery = true)
	  List<Subsection> findAllBySectionName(String section);

}
