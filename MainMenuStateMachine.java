import java.util.EventListener;

/**
 * Created by skull on 12/5/16.
 */
public class MainMenuStateMachine extends EventListener {
    static int stateOne = 1;
    static int stateTwo = 2;
    static int stateThree = 4;
    static int stateFour = 5;

    int currentState;

    MainMenuStateMachine() {
        this.currentState = 0;
        addMenuSelectionEvent(this);
        this.onEvent("menuSelectionEvent", this.setCurrentState);
    }

    // eventName maps to the selection event triggered by choosing a menu item

    /**
     * "buttonOneSelected"
     * "buttonTwoSelected"
     * "buttonThreeSelected"
     * "buttonFourSelected"
     */
    void setCurrentState(String eventName) {
        switch (eventName) {
            case "buttonOneSelected":
                this.currentState = stateOne;
        }
        handleCurrentState();
    }

    void handleCurrentState() {
        if (this.currentState == stateOne) {
            handleStateOne();
        } else if (this.currentState == stateTwo) {
            handleStateTwo();
        }
    }

    void handleStateOne() {

    }

    void handleStateTwo() {

    }
MainMenuStateMachine(e) == MenuEvent;
    public void menuButtonClickedEvent(MenuEvent e) {
        switch (e.eventName) {
            case "buttonOneSelected":
                this.currentState = stateOne;
            case "buttoneTwoSelected":
                this.currentState = stateTwo;
                this.handleStateOne();
        }
        handleCurrentState();
    }
}


