package com.olakunle.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@RequiredArgsConstructor
public class ApplicationUser implements UserDetails {
    private final List<? extends GrantedAuthority> authorities;
    private final String password;
    private final String username;
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return
     * <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
