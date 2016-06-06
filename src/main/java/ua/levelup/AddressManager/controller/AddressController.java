package ua.levelup.AddressManager.controller;

import org.apache.log4j.Logger;
import ua.levelup.AddressManager.dto.AddressDto;
import ua.levelup.AddressManager.dto.PhoneDto;
import ua.levelup.AddressManager.model.Address;
import ua.levelup.AddressManager.model.Phone;
import ua.levelup.AddressManager.service.AddressService;
import ua.levelup.AddressManager.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created by java on 25.05.2016.
 */
@Controller
@RequestMapping("/address")
public class AddressController {

    private static final Logger LOG = Logger.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @Autowired
    private PhoneService phoneService;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showMainPage() {
        return "inex";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String showForm() {

        LOG.info("AAAAAAAAAAAAAAAAAAAAAA");
        return "create";

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAddress(@ModelAttribute AddressDto addressDto, Model model) {
        LOG.info("hi");
        Address address = addressService.findByContent(addressDto.getContent());

        if (address == null) {
            address = new Address();
            address.setContent(addressDto.getContent());
            address.setCountry(addressDto.getCountry());
            addressService.createAddress(address);
            LOG.info("Created address");
        }

        Phone phone = new Phone();
        phone.setNumber(addressDto.getPhone());
        phone.setAddress(address);

        try {
            phoneService.createPhone(phone);
        } catch (Exception e) {
            return "error";
        }

        List<Phone> phonesList = address.getPhones();
        boolean exist = false;
        if (phonesList != null) {
            Iterator<Phone> iterator = phonesList.iterator();
            while (iterator.hasNext()) {
                Phone next = iterator.next();
                if (next.getNumber().equals(phone.getNumber())) {
                    exist = true;
                    break;
                }
            }
        } else {
            phonesList = new ArrayList<Phone>();
            phonesList.add(phone);
            address.setPhones(phonesList);
            exist = true;
        }
        if (!exist) {
            phonesList.add(phone);
            addressService.createAddress(address);
        }

        model.addAttribute("content", address.getContent());
        model.addAttribute("country", address.getCountry());
        model.addAttribute("phones", address.getPhones());
        return "view";
    }

    @RequestMapping(value = "/deleteAddress", method = RequestMethod.POST)
    public String deleteAddress(@ModelAttribute AddressDto addressDto, Model model) {
        try {
            Address address = addressService.findByContent(addressDto.getContent());
            addressService.deleteById(address.getId_address());
        } catch (Exception e) {
            model.addAttribute("content", "\"" + addressDto.getContent() + "\"" + " <font color=\"#FF0000\">not found!!!</font>");
            return "deleted";
        }
        model.addAttribute("content", "\"" + addressDto.getContent() + "\"" + "  <font color=\"#01DF01\">is deleted!!!</font>");
        return "deleted";
    }


//    @RequestMapping(value = "/deletePhone", method = RequestMethod.POST)
//    public String deletePhone(@ModelAttribute PhoneDto phoneDto, Model model) {
//        try {
//            Phone phone = phoneService.findByNumber(phoneDto.getNumber());
//            phoneService.deleteById(phone.getId_phone());
//        } catch (Exception e) {
//            model.addAttribute("content", "\"" + phoneDto.getNumber() + "\"" + " <font color=\"#FF0000\">not found!!!</font>");
//            return "deleted";
//        }
//        model.addAttribute("content", "\"" + phoneDto.getNumber() + "\"" + "  <font color=\"#01DF01\">is deleted!!!</font>");
//        return "deleted";
//    }
//
//    @RequestMapping(value = "/searchAddress", method = RequestMethod.GET)
//    public String findAddress(@ModelAttribute AddressDto addressDto, Model model) {
//        List<Address> address = addressService.findByContentPartial(addressDto.getContent());
//        model.addAttribute("address", address);
//        return "addressView";
//    }
//
//    @RequestMapping(value = "/searchPhone", method = RequestMethod.GET)
//    public String findPhone(@ModelAttribute PhoneDto phoneDto, Model model) {
//        List<Phone> phones = phoneService.findByNumberPartial(phoneDto.getNumber());
//        model.addAttribute("phones", phones);
//        return "phonesView";
//    }

}