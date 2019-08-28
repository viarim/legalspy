/**
 * 
 */
package com.accenture.bootcamp.legalspy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

/**
 * @Extends spring boot User class with userID field
 *
 */
public class LegalUser extends org.springframework.security.core.userdetails.User implements LegalUserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param username
	 * @param password
	 * @param authorities
	 */
	private final int userID;
	
	public LegalUser(String username, String password, int userID, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
		this.userID = userID;
	}

	/**
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public LegalUser(String username, String password, int userID, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}

	@Override
	public String toString() {
		return super.toString() + userID;
	}

	
	
//	public static class UserBuilder extends org.springframework.security.core.userdetails.User.UserBuilder{
//
//	private int userID;
//		
//	private UserBuilder() {
//	}
//
//		/**
//		 * Populates the username. This attribute is required.
//		 *
//		 * @param username the username. Cannot be null.
//		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
//		 * additional attributes for this user)
//		 */
//		public UserBuilder userID(int userID) {
//			Assert.notNull(userID, "username cannot be null");
//			this.userID = userID;
//			return this;
//		}
//
//		@Override
//		public UserDetails build() {
//			// TODO ADD userID
//			int userID;
//			return super.build();
//		}
//	}
	//public static class UserBuilder extends org.springframework.security.core.userdetails.User.UserBuilder{}

}
