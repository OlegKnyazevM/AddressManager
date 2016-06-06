package ua.levelup.AddressManager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.levelup.AddressManager.model.Phone;
import ua.levelup.AddressManager.repository.PhoneRepository;
import ua.levelup.AddressManager.service.PhoneService;

import java.util.List;

/**
 * Created by java on 15.05.2016.
 */
@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void createPhone(Phone phone) {
        if (phone == null) {
            throw new IllegalArgumentException("phone cannot be null");
        }
        phoneRepository.createPhone(phone);
    }

    @Override
    public Phone findById(long id_phone) {
        return phoneRepository.findById(id_phone);
    }

//    @Override
//    public Phone findByNumber(String number) {
//        return phoneRepository.findByNumber(number);
//    }
//
//    @Override
//    public List<Phone> findByNumberPartial(String number) {
//        return phoneRepository.findByNumberPartial(number);
//    }

    @Override
    public List<Phone> getAllPhone() {
        return phoneRepository.getAllPhone();
    }

    @Override
    public void deleteById(long id_phone) {
        phoneRepository.deleteById(id_phone);
    }

    @Override
    public boolean isPhoneExist(long id_phone) {
        return phoneRepository.isPhoneExist(id_phone);
    }
}