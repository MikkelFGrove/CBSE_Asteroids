package dk.sdu.mmmi.cbse.input;


import dk.sdu.mmmi.cbse.common.EInputTypes;
import dk.sdu.mmmi.cbse.common.GameData;

import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyPressed implements IInputSPI {
    @Override
    public EventType<? extends InputEvent> getInputEvent() {
        return KeyEvent.KEY_PRESSED;
    }

    @Override
    public EventHandler<InputEvent> getInputHandler(GameData gameData) {
        return new EventHandler<>() {
            @Override
            public void handle(InputEvent inputEvent) {
                if (inputEvent instanceof KeyEvent keyEvent) {
                    switch (keyEvent.getCode()) {
                        case UP, KeyCode.W -> gameData.getInputs().setInput(EInputTypes.UP, true) ;
                        case LEFT, KeyCode.A -> gameData.getInputs().setInput(EInputTypes.LEFT, true);
                        case RIGHT, KeyCode.D -> gameData.getInputs().setInput(EInputTypes.RIGHT, true);
                        case SPACE -> gameData.getInputs().setInput(EInputTypes.SHOOT, true);
                    }
                }
            }
        };
    }
}