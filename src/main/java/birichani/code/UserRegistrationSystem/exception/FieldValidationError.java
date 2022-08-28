
 /*
  * Author     : birichani.code
  * Date         : 27/08/22  13:51
  * Project Name : UserRegistrationSystem
  * */


 package birichani.code.UserRegistrationSystem.exception;

 import java.awt.*;

 public class FieldValidationError {
     private String filed;
     private String message;
     private TrayIcon.MessageType type;

     public String getFiled() {
         return filed;
     }

     public void setFiled(String filed) {
         this.filed = filed;
     }

     public String getMessage() {
         return message;
     }

     public void setMessage(String message) {
         this.message = message;
     }

     public TrayIcon.MessageType getType() {
         return type;
     }

     public void setType(TrayIcon.MessageType type) {
         this.type = type;
     }
 }
