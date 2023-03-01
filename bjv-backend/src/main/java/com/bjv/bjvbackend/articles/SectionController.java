package com.bjv.bjvbackend.articles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class SectionController {
	
	@Autowired
	private SectionRepository sectionRepository;
	
	@Autowired
	private SubsectionRepository subsectionRepository;
	
	
	@GetMapping("sections")
	public List<Section> getAllSections(){
		
		return sectionRepository.findAll();
	}
	
	@GetMapping("subsections")
	public List<Subsection> getSubsections(@RequestParam String section){
		
		return subsectionRepository.findAllBySectionName(section);
	}
	
	@PostMapping("sections")
	public Section addSection(@RequestBody Section section){
		//
		Section addedSection = sectionRepository.save(section);

		return addedSection;
	}
	
	@PostMapping("subsections")
	public Subsection addSubsection(@RequestBody Subsection subsection ){
		//
		Subsection addedSubsection = subsectionRepository.save(subsection);

		return addedSubsection;
	}

}
