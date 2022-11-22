package com.salomeja2000.projectmanagementtool.project;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {
    List<Project> readAllProjects();
    Optional<Project> readProject(int id);
    int createProject(Project project);
    int deleteProject(int id);
    int updateProject(int id, Project newProject);
}
