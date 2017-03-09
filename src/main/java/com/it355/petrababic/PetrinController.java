/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.petrababic;

/**
 *
 * @author ko
 */
import com.it355.petrababic.dao.PonudaDao;
import com.it355.petrababic.model.Ponuda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.it355.petrababic.service.PonudaService;
import java.util.List;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
public class PetrinController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    PonudaDao ponudaDao;

    @Autowired
    PonudaService ponudaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("poruka", "Petrin prvi domaći");
        return "pocetna";
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("message", "Ovo je strana za admine!");
        model.setViewName("admin");

        return model;

    }
    @RequestMapping(value = "/upisPonude" , method = RequestMethod.GET)
    public String upisPonude(ModelMap model){
        model.addAttribute("ponuda", new Ponuda());
        return "upisPonude";
    }

    @RequestMapping(value = "/upisPonude", method = RequestMethod.POST)
    
        public ModelAndView upisPonude(@ModelAttribute("ponuda") Ponuda p, ModelAndView model) {
           
        model.addObject("ponuda", p);
         model.addObject("successMsg", "Product successfully added");
        //p.setId(ponudaDao.getCount() + 1);
        
        return model;
    }
    

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addObject("username", userDetail.getUsername());

        }

        model.setViewName("403");
        return model;

    }

    @RequestMapping(value = "/ponude", method = RequestMethod.GET)
    public ModelAndView ponude(ModelAndView modelAndView) {
        System.out.println("Pozivam message source");
        List<Ponuda> ponude = ponudaService.getAllPonude();
        modelAndView.addObject("ponude", ponude);
        modelAndView.setViewName("ponude");
        //  System.out.println(messageSource.getMessage("name", null, Locale.ENGLISH));
     return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Losi login podaci!");
        }
        if (logout != null) {
            model.addObject("msg", "Izlogovani ste.");
        }
        model.setViewName("login");
        return model;
    }
}
