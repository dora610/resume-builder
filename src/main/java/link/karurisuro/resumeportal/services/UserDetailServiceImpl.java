package link.karurisuro.resumeportal.services;

import link.karurisuro.resumeportal.models.User;
import link.karurisuro.resumeportal.models.UserDetailsImpl;
import link.karurisuro.resumeportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("No such user found"));
        UserDetails userDetails = new UserDetailsImpl(user);
        return userDetails;
    }
}
