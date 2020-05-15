package ru.itis.group11801.moviehubrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.group11801.moviehubrest.dto.ChecklistDto;
import ru.itis.group11801.moviehubrest.services.ChecklistsService;

import java.util.List;

@RestController
public class ChecklistController {

    @Autowired
    private ChecklistsService checklistsService;

    @GetMapping("/checklists/init")
    public ResponseEntity<?> init() {
        checklistsService.init();
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/checklists")
    public ResponseEntity<List<ChecklistDto>> getChecklists() {
        return ResponseEntity.ok(checklistsService.getAll());
    }
}
