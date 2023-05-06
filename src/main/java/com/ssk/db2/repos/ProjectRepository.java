package com.ssk.db2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssk.db2.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
