package ua.levelup.AddressManager.repository;

import ua.levelup.AddressManager.model.Phone;

import java.util.List;

/**
 * Created by java on 15.05.2016.
 */
public interface PhoneRepository {

    void createPhone (Phone phone);
    //    void updateAddress (Address address);
    Phone findById (long id_phone);
    List<Phone> getAllPhone ();
    void deleteById (long id_phone);
    boolean isPhoneExist(long id_phone);
}