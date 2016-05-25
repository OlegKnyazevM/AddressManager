package ua.levelup.AddressManager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.levelup.AddressManager.model.Address;
import ua.levelup.AddressManager.repository.AddressRepository;
import ua.levelup.AddressManager.service.AddressService;

import java.util.List;

/**
 * Created by java on 15.05.2016.
 */

@Service
//@Transactional
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void createAddress(Address address) {
//        if(address == null) {
//            throw new IllegalArgumentException("address cannot be null");
//        }
        addressRepository.createAddress(address);
    }

    @Override
    public Address findById(long id_address) {
        return addressRepository.findById(id_address);
    }

    @Override
    public Address findByContent(String content) {
        return addressRepository.findByContent(content);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.getAllAddress();
    }

    @Override
    public void deleteById(long id_address) {
        addressRepository.deleteById(id_address);
    }

    @Override
    public boolean isAddressExist(long id_address) {
        return addressRepository.isAddressExist(id_address);
    }
}