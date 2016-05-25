package ua.levelup.AddressManager.repository;

import ua.levelup.AddressManager.model.Address;

import java.util.List;

/**
 * Created by java on 15.05.2016.
 */
public interface AddressRepository {
    void createAddress (Address address);
    //    void updateAddress (Address address);
    Address findById (long id_address);
    Address findByContent (String content);
    List<Address> getAllAddress ();
    void deleteById (long id_address);
    boolean isAddressExist(long id_address);
//    Address getAddressByContent(String content);
}
