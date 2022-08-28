
 /*
  * Author     : birichani.code
  * Date         : 23/08/22  11:17
  * Project Name : UserRegistrationSystem
  * */


 package birichani.code.UserRegistrationSystem.models;

 import lombok.AllArgsConstructor;
 import lombok.Getter;
 import lombok.NoArgsConstructor;
 import lombok.Setter;
 import org.hibernate.validator.constraints.Length;

 import javax.persistence.*;
 import javax.validation.constraints.Email;
 import javax.validation.constraints.NotEmpty;

 @Getter
 @Setter
 @NoArgsConstructor
 @AllArgsConstructor
 @Entity
 @Table(name="Users")
 public class UserDTO {
     @Id
     @GeneratedValue
     @Column(name = "USER_ID")
     private Long id;
     @NotEmpty(message = "error.name.empty")
     @Length(max = 50, message = "error.name.length")
     @Column(name = "NAME")
     private String name;
     @NotEmpty(message = "error.address.empty")
     @Length(max = 150, message = "error.address.length")
     @Column(name = "ADDRESS")
     private String address;
     @Email(message = "error.email.email")
     @NotEmpty(message = "error.email.empty")
     @Length(max = 80, message = "error.email.length")
     @Column(name = "EMAIL")
     private String email;


 }
     // Getters and Setters methods



