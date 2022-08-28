
 /*
  * Author     : birichani.code
  * Date         : 27/08/22  14:05
  * Project Name : UserRegistrationSystem
  * */


 package birichani.code.UserRegistrationSystem.configuration;

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.support.ReloadableResourceBundleMessageSource;

 @Configuration
 public class UserRegistrationConfiguration {

     @Bean(name = "messageSource")
     public ReloadableResourceBundleMessageSource messageSource() {
         ReloadableResourceBundleMessageSource messageBundle =
                 new ReloadableResourceBundleMessageSource();
         messageBundle.setBasename("classpath:messages/messages");
         messageBundle.setDefaultEncoding("UTF-8");
         return messageBundle;
     }
 }
