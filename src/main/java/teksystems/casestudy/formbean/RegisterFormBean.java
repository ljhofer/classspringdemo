package teksystems.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import teksystems.casestudy.validator.EmailUnique;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@ToString
@Getter
@Setter

public class RegisterFormBean {

    // this id will be null in the case of a create and populated in the case of an edit
    private Integer id;

    @NotBlank(message="Email is required")
    @EmailUnique(message="Email is already in use.")
    @Email(message = "Not a valid email format")
//    @Pattern(regexp = "^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message="Email format invalid")
    private String email;


    @NotBlank(message="First name is required")
    private String firstName;

    @NotBlank(message="Last name is required")
    private String lastName;

    @Length(min= 3, max= 15, message="Password must be between 3 and 15 characters.")
    @NotBlank(message="Password is required")
    private String password;

    @NotBlank(message="Confirm password is required")
    private String confirmPassword;

    @AssertTrue(message = "Checkbox is required")
    private Boolean checkbox;

}