package com.example.managerment_player_footbal.service;

import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.repository.account_repository.AccountRepository;
import com.example.managerment_player_footbal.repository.account_repository.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountRoleRepository accountRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByAccountName(username);
        if (account == null || !account.getAccountName().equals(username)) {
            throw new UsernameNotFoundException("User không tồn tại");
        }


        List<String> roles = accountRoleRepository.findAllRoleByUser(username);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (String roleName : roles) {
            authorityList.add(new SimpleGrantedAuthority(roleName));
        }

        UserDetails userDetails = new User(username, account.getPassword(), authorityList);
        return userDetails;
    }
}
