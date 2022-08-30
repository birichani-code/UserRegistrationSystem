
 /*
  * Author     : birichani.code
  * Date         : 29/08/22  19:08
  * Project Name : UserRegistrationSystem
  * */


 package birichani.code.UserRegistrationSystem.service;

 import birichani.code.UserRegistrationSystem.models.UserInfo;
 import birichani.code.UserRegistrationSystem.repository.UserInfoJpaRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.core.GrantedAuthority;
 import org.springframework.security.core.authority.AuthorityUtils;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
 import org.springframework.stereotype.Service;

 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.List;

 @Service
 public class UserInfoDetailsService implements UserDetailsService {
  @Autowired
  private UserInfoJpaRepository userInfoJpaRepository;
  @Override
  public UserDetails loadUserByUsername(String username)
          throws UsernameNotFoundException {
   UserInfo user = userInfoJpaRepository.findByUsername(username);
   if (user == null) {
    throw new UsernameNotFoundException(
            "Opps! user not found with user-name: " + username);
   }
   return new org.springframework.security.core.userdetails.User(
           user.getUsername(), user.getPassword(),

           getAuthorities(user));

  }
  private Collection<GrantedAuthority> getAuthorities(UserInfo user) {
   List<GrantedAuthority> authorities = new ArrayList<>();
   authorities = AuthorityUtils.createAuthorityList(user.getRole());
   return authorities;
  }
 }
