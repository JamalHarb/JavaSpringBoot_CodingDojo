package com.codingdojo.projectmanager.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.repositories.ProjectRepo;

@Service
public class ProjectService {
	private final ProjectRepo projectRepo;
	public ProjectService(ProjectRepo projectRepo) {
		this.projectRepo = projectRepo;
	}
	
	public List<Project> myProjects(User leader, User member) {
		return projectRepo.findDistinctByLeaderOrMembersContains(leader, member);
	}
//	
	public List<Project> otherProjects(User leader, User member) {
		return projectRepo.findDistinctByMembersNotContains(member);
	}
	
//	public List<Project> myProjects(Long memberId, Long leaderId) {
//		return projectRepo.findMyProjects(memberId, leaderId);
//	}
//	
//	public List<Project> otherProjects(Long memberId, Long leaderId) {
//		return projectRepo.findOtherProjects(memberId, leaderId);
//	}
	
	public Project create(Project p, BindingResult result) {
		if(p.getDueDate().before(new Date())) {
			result.rejectValue("dueDate", "past", "Due date cannot be in the past.");
		}
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(p.getDueDate());
		if(strDate.length() == 0) {
			result.rejectValue("dueDate", "required", "Date must be provided.");
		}
		if(result.hasErrors()) {
			return null;
		}
		return projectRepo.save(p);
	}
	
	public Project update(Project p) {
		return projectRepo.save(p);
	}
	
	public Project findProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}
		else {
			return null;
		}
	}
}
