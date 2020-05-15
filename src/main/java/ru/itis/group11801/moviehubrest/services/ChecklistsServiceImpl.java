package ru.itis.group11801.moviehubrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.group11801.moviehubrest.dto.ChecklistDto;
import ru.itis.group11801.moviehubrest.model.Checklist;
import ru.itis.group11801.moviehubrest.model.User;
import ru.itis.group11801.moviehubrest.repositories.ChecklistsRepository;
import ru.itis.group11801.moviehubrest.repositories.UsersRepository;

import java.util.List;

@Component
public class ChecklistsServiceImpl implements ChecklistsService {

    @Autowired
    private ChecklistsRepository checklistsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void init() {
        User admin = usersRepository.getOne(44L);
        System.out.println(admin.getName());
        checklistsRepository.save(Checklist.builder().owner(admin).name("Coronavirus").size(1).build());
        checklistsRepository.save(Checklist.builder().owner(admin).name("Spring").size(2).build());
        checklistsRepository.save(Checklist.builder().owner(admin).name("ILoveU").size(3).build());
        checklistsRepository.save(Checklist.builder().owner(admin).name("ITIS").size(1).build());
        checklistsRepository.save(Checklist.builder().owner(admin).name("Kotlin Checklist").size(5).build());
    }

    @Override
    public List<ChecklistDto> getAll() {
        return ChecklistDto.from(checklistsRepository.findAll());
    }
}
