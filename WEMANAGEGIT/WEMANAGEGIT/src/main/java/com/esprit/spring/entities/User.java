package com.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.validation.constraints.*;




@Entity
public class User implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
	@NotNull(message = "The username can't be empty") @Size(min = 3, message = "the title's length " +
            "must be at least 3")
    private String userName;
    @NotNull(message = "The password can't be empty") @Size(min=3, message = "the password's " +
            "length " +
            "must be at least 8")
    private String Password;
    @NotNull(message = "The Role can't be empty")
    private String roles;
    private boolean Active;
    @Email
    
    private String Email;
    private int Telephone;
    private String Adresse;
    private String FirstName;
    private String LastName;





    @JsonIgnore
        @OneToMany(mappedBy = "user")
	private List<Message> messages;
    @JsonIgnore
        @OneToMany(mappedBy = "user")
	private List<Notification> notifications;
    


public User(Long Id) {
        this.Id = Id;
    }

    public User() {
		super();
	}

	

	public User( @NotNull String userName, @NotNull(message = "The password can't be empty") @Size(min = 3, message = "the password's " +
            "length " +
            "must be at least 8") String Password, @NotNull String roles, boolean Active , String Email , int Telephone , String Adresse , String FirstName , String LastName) {
        this.userName = userName;
        this.Password = Password;
        this.roles = roles;
        this.Active = Active;
        this.Email = Email;
        this.Telephone = Telephone;
        this.Adresse = Adresse;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRoles() {
		return roles;
	}

	

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getTelephone() {
		return Telephone;
	}

	public void setTelephone(int telephone) {
		Telephone = telephone;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

    
    
    
}
