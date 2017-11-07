package com.cputech.statemachine;

/**
 * Created by song on 2017/9/21.
 */

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateContext.Stage;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.LinkedList;
import java.util.List;

public class StateMachineLogListener extends StateMachineListenerAdapter<String, String> {

    private final LinkedList<String> messages = new LinkedList<String>();

    public List<String> getMessages() {
        return messages;
    }

    public void resetMessages() {
        messages.clear();
    }

    @Override
    public void stateContext(StateContext<String, String> stateContext) {
        if (stateContext.getStage() == Stage.STATE_ENTRY) {
            messages.addFirst("Enter " + stateContext.getTarget().getId());
        } else if (stateContext.getStage() == Stage.STATE_EXIT) {
            messages.addFirst("Exit " + stateContext.getSource().getId());
        } else if (stateContext.getStage() == Stage.STATEMACHINE_START) {
            messages.addLast("Machine started");
        } else if (stateContext.getStage() == Stage.STATEMACHINE_STOP) {
            messages.addFirst("Machine stopped");
        }
    }

    @Override
    public void stateChanged(State<String, String> from, State<String, String> to) {
        System.out.println("State change to " + to.getId());
    }
}
