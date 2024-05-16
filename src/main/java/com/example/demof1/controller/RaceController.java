package com.example.demof1.controller;

import com.example.demof1.model.TbRider;
import com.example.demof1.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RaceController {

    @Autowired
    private RiderService riderService;

    @GetMapping("/")
    public String getUsers(Model model) {
        List<TbRider> riders = riderService.getData();
        model.addAttribute("riders", riders);
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam String name, @RequestParam String motor, @RequestParam int age) {
        TbRider tbRider = new TbRider();
        tbRider.setName(name);
        tbRider.setAge(age);
        tbRider.setMotor(motor);
        riderService.save(tbRider);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@RequestParam int upid, @RequestParam String upname, @RequestParam String upmotor, @RequestParam int upage) {
        TbRider tbRider = riderService.exist(upid);
        if(tbRider!=null){
            TbRider tb = new TbRider();
            tb.setId(upid);
            tb.setName(upname);
            tb.setAge(upage);
            tb.setMotor(upmotor);
            riderService.save(tb);
            return "redirect:/";
        }

        return "redirect:/index?update=failed";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {

        Boolean status = riderService.delete(id);
        if(status){
            return "redirect:/";
        }

        return "redirect:/index?delete=failed";
    }
}
