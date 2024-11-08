package br.com.fiap.umbl.service.security;

import br.com.fiap.umbl.domain.User;
import br.com.fiap.umbl.domain.UserRole;
import br.com.fiap.umbl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user){
      //  if (user.getRole() == UserRole.USER){
            String EncodePassword = new BCryptPasswordEncoder().encode(user.getPassword());
            user.setSenha(EncodePassword);
            return  userRepository.save(user);
//        }else {
//            return null;
//        }
    }
}
