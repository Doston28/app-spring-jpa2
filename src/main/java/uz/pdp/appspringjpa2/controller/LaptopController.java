package uz.pdp.appspringjpa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appspringjpa2.model.Laptop;
import uz.pdp.appspringjpa2.repository.LaptopRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Autowired
    LaptopRepository laptopRepository;


    @RequestMapping(value = "/laptop",method = RequestMethod.GET)
    public List<Laptop> getLaptop(){
        List<Laptop> laptops = laptopRepository.findAll();
        return laptops;
    }

    @RequestMapping(value = "/laptop", method = RequestMethod.POST)
    public String addLaptop(@RequestBody Laptop laptop){
        laptopRepository.save(laptop);
        return "Laptop added";
    }

    @RequestMapping(value = "/laptop/{id}",method = RequestMethod.GET)
    public Laptop getLaptopById(@PathVariable Integer id){
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if (laptop.isPresent()){
            Laptop laptop1 = laptop.get();
            return laptop1;
        }else {
            return new Laptop();
        }
    }

    @RequestMapping(value = "/laptop/{id}", method = RequestMethod.DELETE)
    public String deleteLaptop(@PathVariable Integer id){
        laptopRepository.deleteById(id);
        return "Laptop deleted";
    }

    @RequestMapping(value = "/laptop/{id}", method = RequestMethod.PUT)
    public String editLaptop(@PathVariable Integer id, @RequestBody Laptop laptop){
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        if (optionalLaptop.isPresent()){
            Laptop editingLaptop = optionalLaptop.get();
            editingLaptop.setName(laptop.getName());
            editingLaptop.setBrandName(laptop.getBrandName());
            editingLaptop.setModel(laptop.getModel());
            editingLaptop.setRam(laptop.getRam());
            editingLaptop.setStorage(laptop.getStorage());
            editingLaptop.setMacAddress(laptop.getMacAddress());

            laptopRepository.save(editingLaptop);
            return "Laptop edited";
        }
        return "Laptop not found";
    }
}
