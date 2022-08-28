
 /*
  * Author     : birichani.code
  * Date         : 23/08/22  11:39
  * Project Name : UserRegistrationSystem
  * */


 package birichani.code.UserRegistrationSystem.controller;

 import birichani.code.UserRegistrationSystem.exception.CustomErrorType;
 import birichani.code.UserRegistrationSystem.models.UserDTO;
 import birichani.code.UserRegistrationSystem.repository.UserJPARepository;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.MediaType;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import javax.validation.Valid;
 import java.util.List;
 import java.util.Optional;

 @RestController
 @RequestMapping("/api/user")
 public class UserRegistrationRestController {
     public static final Logger logger =
             LoggerFactory.getLogger(UserRegistrationRestController.class);
     private UserJPARepository userJpaRepository;

     @Autowired
     public void setUserJpaRepository(UserJPARepository userJpaRepository) {
         this.userJpaRepository = userJpaRepository;
     }

     // method to get list of users
     @GetMapping("/")
     public ResponseEntity<List<UserDTO>> listAllUsers() {
         List<UserDTO> users = userJpaRepository.findAll();
         if (users.isEmpty()) {
             return new ResponseEntity<List<UserDTO>>(HttpStatus.NO_CONTENT);
         }
         return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
     }


     // method to create a user
     @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<UserDTO> createUser(
             @Valid @RequestBody final UserDTO user) {
         logger.info("Creating User : {}", user);
         if (userJpaRepository.findByName(user.getName()) != null) {
             logger.error("Unable to create. A User with name {} already exist",
                     user.getName());
             return new ResponseEntity<UserDTO>(
                     new CustomErrorType(
                             "Unable to create new user. A User with name "
                                     + user.getName() + " already exist."),

                     HttpStatus.CONFLICT);

         }
         userJpaRepository.save(user);
         return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
     }

     @GetMapping("/{id}")
     public ResponseEntity<UserDTO> getUserById(@PathVariable("id") final Long id) {
         UserDTO user = userJpaRepository.findById(id).orElseThrow(() -> new NullPointerException("User Not Found" + id + "Not Found"));
         if (user == null) {
             return new ResponseEntity<UserDTO>(
                     new CustomErrorType("User with id "
                             + id + " not found"), HttpStatus.NOT_FOUND);

         }
         return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
     }

     // method to update an existing user
     @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<UserDTO> updateUser(
             @PathVariable("id") final Long id, @RequestBody UserDTO user) {
         UserDTO currentUser = userJpaRepository.findById(id).orElseThrow(() -> new NullPointerException("User Not Found" + id + "Not Found"));
         ;
         if (currentUser == null) {
             return new ResponseEntity<UserDTO>(
                     new CustomErrorType("Unable to upate. User with id "
                             + id + " not found."), HttpStatus.NOT_FOUND);
         }
             currentUser.setName(user.getName());
             currentUser.setAddress(user.getAddress());
             currentUser.setEmail(user.getEmail());
             userJpaRepository.saveAndFlush(currentUser);
         return new ResponseEntity<UserDTO>(currentUser, HttpStatus.OK);


     }


         // delete an existing user
         @DeleteMapping("/{id}")
         public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") final Long id) {
             UserDTO user = userJpaRepository.findById(id).orElseThrow(() -> new NullPointerException("User Not Found" + id + "Not Found"));;
             if (user == null) {
                 return new ResponseEntity<UserDTO>(
                         new CustomErrorType("Unable to delete. User with id "
                                 + id + " not found."), HttpStatus.NOT_FOUND);
             }
             userJpaRepository.deleteById(id);
             return new ResponseEntity<UserDTO>(
                     new CustomErrorType("Deleted User with id "
                             + id + "."), HttpStatus.NO_CONTENT);
         }
     }
