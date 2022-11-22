package com.salomeja2000.projectmanagementtool.project;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/projects")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public List<Project> readAllProjects() {
        return projectService.readAllProjects();
    }

    @GetMapping("{id}")
    public Project readProject(@PathVariable("id") int id) {
        return projectService.readProject(id);
    }

    @PostMapping
    public void createProject(@RequestBody Project project) {
        projectService.createProject(project);
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable("id") int id) {
        projectService.deleteProject(id);
    }

    @PutMapping({"{id}"})
    public void updateUser(@PathVariable("id") int id, @RequestBody Project project) {
        projectService.updateProject(id, project);
    }
}