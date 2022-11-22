package com.salomeja2000.projectmanagementtool.project;

import com.salomeja2000.projectmanagementtool.exception.NotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProjectService {
    private final ProjectDao projectDao;

    public List<Project> readAllProjects() {
        return projectDao.readAllProjects();
    }

    public Project readProject(int id) {
        return projectDao.readProject(id).orElseThrow(() -> new NotFoundException("Project not found"));
    }

    public void createProject(Project project) {
        int result = projectDao.createProject(project);
        if (result != 1) {
            throw new IllegalStateException("Could not create a project, try again later");
        }
    }

    public void deleteProject(int id) {
        Optional<Project> projects = projectDao.readProject(id);
        projects.ifPresentOrElse(project -> {
            int result = projectDao.deleteProject(id);
            if (result != 1) {
                throw new IllegalStateException("Could not delete the project, try again later");
            }
        }, () -> {
            throw new NotFoundException("Project not found");
        });
    }

    public void updateProject(int id, Project newProject) {
        Optional<Project> projects = projectDao.readProject(id);
        projects.ifPresentOrElse(project -> {
            int result = projectDao.updateProject(id, newProject);
            if (result != 1) {
                throw new IllegalStateException("Could not update the project, try again later");
            }
        }, () -> {
            throw new NotFoundException("Project not found");
        });
    }
}
