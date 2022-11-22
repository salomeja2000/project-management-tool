package com.salomeja2000.projectmanagementtool.project;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class ProjectRepository implements ProjectDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Project> readAllProjects() {
        String statement = """
            SELECT Id, Title, Manager_Id, Date_Created, Date_Edited, Starting_Date, Ending_date, Status, Description
            FROM Projects;
            """;
        return jdbcTemplate.query(statement, new ProjectRowMapper());
    }

    @Override
    public Optional<Project> readProject(int id) {
        String statement = """
            SELECT Id, Title, Manager_Id, Date_Created, Date_Edited, Starting_Date, Ending_date, Status, Description
            FROM Projects
            WHERE Id = ?;
            """;
        return jdbcTemplate.query(statement, new ProjectRowMapper(), id).stream().findFirst();
    }

    @Override
    public int createProject(Project project) {
        String statement = """
            INSERT INTO Projects (Title, Manager_Id, Date_Created, Date_Edited, Starting_Date, Ending_date, Status, Description)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;
        return jdbcTemplate.update(
            statement,
            project.getTitle(),
            project.getManagerId(),
            project.getDateCreated(),
            project.getDateEdited(),
            project.getStartingDate(),
            project.getEndingDate(),
            project.getStatus(),
            project.getDescription()
        );
    }

    @Override
    public int deleteProject(int id) {
        String statement = """
            DELETE FROM Projects 
            WHERE Id = ?;
            """;
        return jdbcTemplate.update(statement, id);
    }

    @Override
    public int updateProject(int id, Project newProject) {
        String statement = """
            UPDATE Projects 
            SET Title = ?, Manager_Id = ?, Date_Created = ?, Date_Edited = ?, Starting_Date = ?, Ending_date = ?, Status = ?, Description = ?
            WHERE Id = ?;
            """;
        return jdbcTemplate.update(
            statement,
            newProject.getTitle(),
            newProject.getManagerId(),
            newProject.getDateCreated(),
            newProject.getDateEdited(),
            newProject.getStartingDate(),
            newProject.getEndingDate(),
            newProject.getStatus(),
            newProject.getDescription(),
            id
        );
    }
}