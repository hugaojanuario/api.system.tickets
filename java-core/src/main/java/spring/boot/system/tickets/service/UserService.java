package spring.boot.system.tickets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.system.tickets.entity.User;
import spring.boot.system.tickets.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User newUSer (User user){
        return userRepository.saveAndFlush(user);
    }

    public List <User> listUser (){
        return userRepository.findAll();
    }

    public Optional<User> listUserById (Long id){
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User newData) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(newData.getName());
        user.setEmail(newData.getEmail());
        user.setPaper(newData.getPaper());

        return userRepository.save(user);
    }


    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
