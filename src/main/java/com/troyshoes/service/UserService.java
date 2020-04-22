package com.troyshoes.service;

import java.util.Set;

import com.troyshoes.domain.User;
import com.troyshoes.domain.security.PasswordResetToken;
import com.troyshoes.domain.security.UserRole;

public interface UserService {
	
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
}