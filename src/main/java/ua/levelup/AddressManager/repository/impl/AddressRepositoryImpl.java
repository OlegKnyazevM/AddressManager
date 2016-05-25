package ua.levelup.AddressManager.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import ua.levelup.AddressManager.model.Address;
import ua.levelup.AddressManager.repository.AddressRepository;


import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by java on 15.05.2016.
 */

@Repository
@Transactional
public class AddressRepositoryImpl implements AddressRepository{

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void createAddress(Address address) {
//        if(address == null) {
//            throw new IllegalArgumentException("Address cannot be null");
//        }
        hibernateTemplate.saveOrUpdate(address);
    }


    @Override
    public Address findById(long id_address) {
        return hibernateTemplate.get(Address.class, id_address);
    }


    @Override
    public Address findByContent(String content) {
        List<Address> addresses  = (List<Address>) hibernateTemplate.find("select a FROM Address a WHERE a.content = ?", content);
        if (!CollectionUtils.isEmpty(addresses)) {
            return addresses.get(0);
        }
        return null;
    }

    @Override
    public List<Address> getAllAddress() {
        return (List<Address>) hibernateTemplate.find("select * FROM Address");
    }


    @Override
    public void deleteById(long id_address) {
        hibernateTemplate.delete(findById(id_address));
    }


    @Override
    public boolean isAddressExist(long id_address) {
        return hibernateTemplate.contains(id_address);
    }

//    @Override
//    public Address getAddressByContent(String content) {
//        ArrayList<Address> list = new ArrayList<Address>((Collection<? extends Address>) Arrays.asList(
//                hibernateTemplate.find("FROM Address a WHERE a.content = ?", content)));
//        return list.get(0);
//    }
}