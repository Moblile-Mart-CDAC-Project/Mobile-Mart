package com.backend.service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
//	 public static String getCurrentUserEmail() {
//	        return SecurityContextHolder.getContext()
//	                .getAuthentication()
//	                .getName();
//	    }
	 
	 public static String getCurrentUserEmail() {
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		    if (auth == null || !auth.isAuthenticated()) {
		        throw new RuntimeException("User not authenticated");
		    }
		    return auth.getName();
		}

}
