package com.bjv.bjvbackend.articles;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubsectionRepository extends JpaRepository<Subsection, String> {
	
	 @Query(value = "SELECT * FROM subsections WHERE sectionName = ?1", nativeQuery = true)
	  List<String> findAllBySectionName(String section);

}
