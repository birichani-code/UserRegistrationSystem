package birichani.code.UserRegistrationSystem.repository;

import birichani.code.UserRegistrationSystem.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoJpaRepository extends JpaRepository<UserInfo, Long> {
    public UserInfo findByUsername(String username);
}
