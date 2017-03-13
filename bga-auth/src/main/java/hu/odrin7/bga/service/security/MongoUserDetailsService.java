package hu.odrin7.bga.service.security;

import hu.odrin7.bga.domain.user.User;
import hu.odrin7.bga.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    private final Logger log = LoggerFactory.getLogger(MongoUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = repository.findOne(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }
}
