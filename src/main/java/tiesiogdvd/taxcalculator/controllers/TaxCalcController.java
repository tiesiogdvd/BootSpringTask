package tiesiogdvd.taxcalculator.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaxCalcController {
    @GetMapping("/")
    public String enterTax(){
        return "enterTax";
    }


    @GetMapping("/tax")
    public String showTax(){
        return "showTax";
    }

    @PostMapping("/tax")
    public String calcTax(
            @RequestParam("") Integer price,
            @RequestParam Integer units,
            Model model)
    {
        Double pvm = (double)price-(price/1.21);
        Double unitWithoutPVM = price-pvm;
        Double totalWithoutPVM = unitWithoutPVM*units;
        Double totalPVM = pvm*units;
        Double total = (double) (price*units);

        model.addAttribute("pvm", pvm);
        model.addAttribute("unitWithoutPVM", unitWithoutPVM);
        model.addAttribute("price",price);
        model.addAttribute("totalWithoutPVM", totalWithoutPVM);
        model.addAttribute("totalPVM", totalPVM);
        model.addAttribute("total", total);
        return "showTax";
    }
}
