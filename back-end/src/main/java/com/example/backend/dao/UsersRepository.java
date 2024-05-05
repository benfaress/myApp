package com.example.backend.dao;

import com.example.backend.models.Users;
import com.example.backend.services.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UsersRepository implements UsersService {

    private List<Users> salariess = Stream.of(
                    new Users("ilyes", "raissi", "444444)", "Tunis"),
                    new Users("rahma", "raissi", "new55555)", "Tunis"),
                    new Users("amine", "raissi", "new BigDecimal(88888)", "Tunis"),
                    new Users("ines", "raissi", "new BigDecimal(999999)", "Tunis"))
            .collect(Collectors.toList());

    @Override
    public Users addUser(Users user) {
        salariess.add(user);
        return user;
    }

    @Override
    public List<Users> getListUsers() {
        return salariess;
    }

    @Override
    public Users findUserById(Long searchedId) {
        return salariess.stream()
                .filter(x -> searchedId.equals((x.getId())))
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        Users user = findUserById(id);
        salariess.remove(user);
    }

    @Override
    public void updateUser(Users user) {
        Users userr = findUserById(user.getId());
        if (userr != null) {
            userr.setLastname(user.getLastname());
            userr.setUsername(user.getUsername());
            userr.setAdresse(user.getAdresse());
            userr.setMail(user.getMail());
        }
    }
}
