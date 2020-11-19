package com.galaxyware.colaborae.business;

import  com.galaxyware.colaborae.model.Authority;
import com.galaxyware.colaborae.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StandardAuthorityBO {

    @Autowired
    private AuthorityRepository authorityRepository;

    protected Authority adminsAuthority;

    protected Authority customerAuth;

    protected Authority superadminAuthority;

    protected Authority stoomAuthority;


    @PostConstruct
    protected void loadAuthorities(){
        adminsAuthority = authorityRepository.findByName("ADMIN");
        customerAuth = authorityRepository.findByName("CUSTOMER");
        superadminAuthority = authorityRepository.findByName("SUPERADMIN");
    }

    public Authority getAdminAuthority() {
        return adminsAuthority;
    }

    public Authority getCustomerAuthority() {
        return customerAuth;
    }

    public Authority getSuperadminAuthority(){
        return superadminAuthority;
    }


}
