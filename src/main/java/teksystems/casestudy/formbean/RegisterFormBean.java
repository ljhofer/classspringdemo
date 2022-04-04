package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class RegisterFormBean {

    // this id will be null in the case of a create and populated in the case of an edit
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;

}