package com.accenture.bootcamp.legalspy.model;

import org.springframework.security.core.userdetails.UserDetails;

public interface LegalUserDetails extends UserDetails {
	int getUserID();
}
