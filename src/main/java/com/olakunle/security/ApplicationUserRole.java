package com.olakunle.security;

import java.util.Set;

import static com.olakunle.security.ApplicationUserPermission.*;


public enum ApplicationUserRole {

    STUDENT(Set.of()),
    ADMIN(Set.of(COURSE_READ, COURSE_WRITE, STUDENT_WRITE, STUDENT_READ)),
    TRAINEE(Set.of(COURSE_READ, STUDENT_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
