package com.galaxyware.colaborae.business;

import com.galaxyware.colaborae.model.AddressModel;
import com.galaxyware.colaborae.model.Authority;
import com.galaxyware.colaborae.model.UserModel;
import com.galaxyware.colaborae.repository.AddressRepository;
import com.galaxyware.colaborae.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserBo {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    private StandardAuthorityBO authorityBO;

    public Page<UserModel> findAllUsers(Pageable pageable) { return  userRepository.findAll(pageable); }

    public  UserModel findUserByUuid(UUID uuid) { return  userRepository.findById(uuid).orElse(null); }

    public List<UserModel> findByFirstName(String name){return  userRepository.findByFirstNameContaining(name);}

    public  UserModel saveNewUser( UserModel  userModel) {
        Authority customerAuthority = authorityBO.getCustomerAuthority();
        userModel.addAuthority(customerAuthority);
        userModel.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));

        return  userRepository.save( userModel);
    }

    public  UserModel updateUser(UUID uuid,  UserModel  userModel) {
         UserModel userByUuid = findUserByUuid(uuid);

        AddressModel address = userByUuid.getAddress();
        address.setAddress(userModel.getAddress().getAddress());
        address.setBlock(userModel.getAddress().getBlock());
        address.setCity(userModel.getAddress().getCity());
        address.setNumber(userModel.getAddress().getNumber());
        address.setState(userModel.getAddress().getState());
        address.setZipcode(userModel.getAddress().getZipcode());
        addressRepository.save(address);

         userByUuid.setFirstName( userModel.getFirstName());
         userByUuid.setLastName(userModel.getLastName());
         userByUuid.setEmail(userModel.getEmail());
         userByUuid.setDescription(userModel.getDescription());
         userByUuid.setFavorites(userModel.getFavorites());

        return  userRepository.save(userByUuid);
    }

    public void deleteUser(UUID uuid) {
         userRepository.deleteById(uuid);
    }
}
