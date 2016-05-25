package ua.levelup.AddressManager.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import ua.levelup.AddressManager.model.Phone;
import ua.levelup.AddressManager.repository.PhoneRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by java on 15.05.2016.
 */

@Repository
@Transactional
public class PhoneRepositoryImpl implements PhoneRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void createPhone(Phone phone) {
        if(phone == null) {
            throw new IllegalArgumentException("Phone cannot be null");
        } hibernateTemplate.saveOrUpdate(phone);
    }


    @Override
    public Phone findById(long id_phone) {
        return hibernateTemplate.load(Phone.class, id_phone);
    }

    @Override
    public List<Phone> getAllPhone() {
        return (List<Phone>) hibernateTemplate.find("FROM Phone");
    }

    @Override
    public void deleteById(long id_phone) {
        hibernateTemplate.delete(findById(id_phone));
    }

    @Override
    public boolean isPhoneExist(long id_phone) {
        return hibernateTemplate.contains(id_phone);
    }
}