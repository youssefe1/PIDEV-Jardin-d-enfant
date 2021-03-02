package com.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import javax.validation.constraints.*;


@Entity
public class User implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String UserName;
    @NotNull(message = "The password can't be empty") @Size(min=4, message = "the password's " +
            "length " +
            "must be at least 8")
    private String Password;
    @NotNull
    private String Roles;
    private boolean Active;
    @Email(message="Please provide a valid email address")
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
    private String Email;
    private int Telephone;
    private String Adresse;
    private String FirstName;
    private String LastName;




       /* @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "message")
	private List<Message> message;
	
        @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "notifications")
	private List<Notifications> notifications;
	
	@OneToMany(mappedBy = "user")
	private List<EventParticipants> eventParticipants;*/
    


public User(Long Id) {
        this.Id = Id;
    }

    public User() {
		super();
	}

	public User(Long id, String userName,
		@NotNull(message = "The password can't be empty") @Size(min = 4, message = "the password's length must be at least 8") String password,
		@NotNull String roles, boolean active,
		@javax.validation.constraints.Email(message = "Please provide a valid email address") @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address") String email,
		int telephone, String adresse, String firstName, String lastName) {
	super();
	Id = id;
	UserName = userName;
	Password = password;
	Roles = roles;
	Active = active;
	Email = email;
	Telephone = telephone;
	Adresse = adresse;
	FirstName = firstName;
	LastName = lastName;
}

	public User(@NotNull(message = "The username can't be empty") @Size(min = 3, message = "the title's length " +
            "must be at least 3") String UserName, @NotNull(message = "The password can't be empty") @Size(min = 4, message = "the password's " +
            "length " +
            "must be at least 8") String Password, @NotNull String Roles, boolean Active , @Email(message="Please provide a valid email address")
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address") String Email , int Telephone , String Adresse , String FirstName , String LastName) {
        this.UserName = UserName;
        this.Password = Password;
        this.Roles = Roles;
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
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRoles() {
		return Roles;
	}

	public void setRoles(String roles) {
		Roles = roles;
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
