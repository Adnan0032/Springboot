package org.example.web.controler;


import org.example.web.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {
    @Autowired
    AddressRepository addressRepository;
    @GetMapping("/addresses")
    public String showAddresses(Model model) {
        model.addAttribute("allAddresses", addressRepository.findAll());
        System.out.println(addressRepository.findAll());
        return "addresses";
    }
    @GetMapping("/address")
    public String addAddress() {
        return "address";
    }
}