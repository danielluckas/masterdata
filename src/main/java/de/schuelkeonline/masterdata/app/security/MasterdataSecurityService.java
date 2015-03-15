package de.schuelkeonline.masterdata.app.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.schuelkeonline.masterdata.app.bean.UserRole;
import de.schuelkeonline.masterdata.app.db.UserRepository;

@Service("userDetailsService")
public class MasterdataSecurityService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		de.schuelkeonline.masterdata.app.bean.User user = userDao.findByUsername(username);
		if(user != null){
			List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
			return buildUserForAuthentication(user, authorities);
		}else{
			throw new UsernameNotFoundException("username " + username
                    + " not found");
		}

	}

	private User buildUserForAuthentication(de.schuelkeonline.masterdata.app.bean.User user,
			List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
