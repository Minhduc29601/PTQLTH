package com.devpro.javaweb22.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
@Table(name = "tbl_users")
public class User extends BaseEntity implements UserDetails {

	@Column(name = "username", length = 45, nullable = false)
	private String username;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "ho_ten", length = 45, nullable = false)
	private String ho_ten;
	
	@Column(name = "nam_sinh", length = 100, nullable = true)
	private String nam_sinh;

	@Column(name = "que_quan", length = 100, nullable = true)
	private String que_quan;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_users_roles",
			   joinColumns = @JoinColumn(name = "user_id"),
			   inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<Role>();
	public void addRoles(Role role) {
		role.getUsers().add(this);
		roles.add(role);
	}
	public void deleteRole(Role role) {
		role.getUsers().remove(this);
		roles.remove(role);
	}
	public int getRoleInString(String s){
		return Integer.parseInt(s);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
