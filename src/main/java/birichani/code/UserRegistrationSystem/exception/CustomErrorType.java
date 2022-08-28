
 /*
  * Author     : birichani.code
  * Date         : 27/08/22  13:09
  * Project Name : UserRegistrationSystem
  * */


 package birichani.code.UserRegistrationSystem.exception;

 import birichani.code.UserRegistrationSystem.models.UserDTO;

 public class CustomErrorType extends UserDTO {
     private String errorMessage;
     public CustomErrorType(final String errorMessage){
         this.errorMessage = errorMessage;
     }
     public String getErrorMessage() {
         return errorMessage;
     }
 }

