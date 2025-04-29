package com.example.tripplanner.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="User_id")
    private Long userId;
    @Column(name="Last_Name",nullable=false)
    private String lastName;
    @Column(name="First_Name",nullable=false)
    private String firstName;
    @Column(name="user_password",nullable=false,unique=true)
    private String password;
    @Column(name="Email",nullable=false,unique=true)
    private String email;
    @Column(name="Address",nullable=false,unique=true)
    private String address;
    @Column(name="MobileNo",nullable=false,unique=true)
    private String userMobileNo;
    @Column(name="favourite")
    private String userFavourite;
    @Column(name="Age",nullable=false)
    private int userAge;
    
    @Column(name="Gender",nullable=false)
    private String userGender;
   

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Wishlist> wishlists;
    
    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}
    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Wishlist> getWishlists() {
        return wishlists;
    }

    public void setWishlists(Set<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }
    


	public String getUserFavourite() {
		return userFavourite;
	}

	public void setUserFavourite(String userFavourite) {
		this.userFavourite = userFavourite;
	}

	

	@Override
	public String toString() {
		return "User [id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", address=" + address + ", userMobileNo=" + userMobileNo +  ", wishlists=" + wishlists +"]";
	}
}