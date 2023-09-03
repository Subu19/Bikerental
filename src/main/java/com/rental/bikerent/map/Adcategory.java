package com.rental.bikerent.map;

import com.rental.bikerent.model.Category;
import com.rental.bikerent.model.User;
import com.rental.bikerent.repository.AcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Id;

@Controller
public class Adcategory {
    @Autowired
    private AcategoryRepository acategoryRepository;
    @RequestMapping(value="/deleteCategory", method= RequestMethod.POST)
    public String deleteRenting(@RequestParam("id") Integer id){

        acategoryRepository.deleteById(Long.valueOf(id));
        return "redirect:/admin/category";
    }









    @RequestMapping(value="/add_category", method= RequestMethod.POST)
    public String acategory( @ModelAttribute("category") Category category){
        Category to = acategoryRepository.save(category);
        System.out.println(to.getCategoryTitle());
//        System.out.println(product.getpName());
        return "redirect:/admin/add_category";
    }


}
