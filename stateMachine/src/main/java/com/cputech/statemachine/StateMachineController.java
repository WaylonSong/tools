package com.cputech.statemachine;

/**
 * Created by song on 2017/9/21.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StateMachineController {

    @Autowired
    private StateMachine<String, String> stateMachine;

    @RequestMapping("/")
    public String home() {
        return "redirect:/state";
    }

    @Autowired
    private StateMachineLogListener stateMachineLogListener;

    @RequestMapping("/state")
    public String feedAndGetStates(@RequestParam(value = "events", required = false) List<String> events, Model model) throws Exception {
        if (events != null) {
            for (String event : events) {
                stateMachine.sendEvent(event);
            }
        }
        model.addAttribute("allEvents", new String[]{"E1", "E2", "E3"});
        model.addAttribute("messages", createMessages(stateMachineLogListener.getMessages()));
        return "states";
    }

    private String createMessages(List<String> messages) {
        StringBuilder buf = new StringBuilder();
        for (String message : messages) {
            buf.append(message);
            buf.append("\n");
        }
        return buf.toString();
    }

    @RequestMapping("/myBean")
    @ResponseBody
    public String myBean(){
        return "ok";
    }

}
