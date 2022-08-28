package birichani.code.UserRegistrationSystem.repository;

import birichani.code.UserRegistrationSystem.models.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<UserDTO,Long> {
    UserDTO findByName(String name);
}
