package com.videoBox.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {



    @GetMapping("/")
    public String videoGallery(Model model) {
        model.addAttribute("title", "YouTube");
        return "video-gallery";
    }







  //  public void example() {
  //      String[] myString = new String[]{"раз", "два", "три", "четыре", "пять"};
  //      int n = (int)Math.floor(Math.random() * myString.length);
  //      System.out.println(myString[n]);
 //   }


}