package com.codingdojo.projectmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {
	public List<Project> findDistinctByLeaderOrMembersContains(User leader, User member);
	public List<Project> findDistinctByMembersNotContains(User member);
//	public List<Project> findDistinctByLeaderNotOrMembersNotContains(User leader, User member);
	
	@Query(value = "SELECT * FROM projects JOIN members_projects ON projects.id = members_projects.project_id JOIN users ON members_projects.member_id = users.id WHERE users.id = ?1 OR projects.leader_id = ?2", nativeQuery = true)
	public List<Project> findMyProjects(Long memberId, Long leaderId);
	
	@Query(value = "SELECT * FROM projects JOIN members_projects ON projects.id = members_projects.project_id JOIN users ON members_projects.member_id = users.id WHERE users.id != ?1 OR projects.leader_id != ?2", nativeQuery = true)
	public List<Project> findOtherProjects(Long memberId, Long leaderId);
}
