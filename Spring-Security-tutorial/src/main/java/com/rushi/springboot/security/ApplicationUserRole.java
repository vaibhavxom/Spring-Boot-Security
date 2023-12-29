package com.rushi.springboot.security;

import static com.rushi.springboot.security.ApplicationUserPermission.COURSE_READ;
import static com.rushi.springboot.security.ApplicationUserPermission.COURSE_WRITE;
import static com.rushi.springboot.security.ApplicationUserPermission.STUDENT_READ;
import static com.rushi.springboot.security.ApplicationUserPermission.STUDENT_WRITE;

import java.util.Set;

import com.google.common.collect.Sets;

public enum ApplicationUserRole {
STUDENT(Sets.newHashSet()),
ADMIN(Sets.newHashSet(COURSE_READ
					  ,COURSE_WRITE  			// ctrl + shift + m Static-Import
					  ,STUDENT_READ
					  ,STUDENT_WRITE));
	
	private final Set<ApplicationUserPermission> permissions;

	private ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}
	
}
