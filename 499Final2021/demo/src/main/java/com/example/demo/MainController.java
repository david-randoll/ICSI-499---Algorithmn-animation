package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/home")
public class MainController {
  @Autowired
  private FeedbackRepository FeedbackRepository;

  @PostMapping(path="/add")
  public @ResponseBody String addFeedback(@RequestParam String feedback) {

    saveFeedback(feedback);
    return "Saved";
  }

  @Transactional
  public void saveFeedback(String feedback){
    Feedback f = new Feedback();
    System.out.println(feedback);
    f.setFeedback(feedback);
    FeedbackRepository.save(f);
  }

}
