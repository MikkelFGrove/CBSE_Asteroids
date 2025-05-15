package dk.sdu.mmmi.cbse.input;

import dk.sdu.mmmi.cbse.common.EInputTypes;
import dk.sdu.mmmi.cbse.common.GameData;
import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyReleased implements IInputSPI {
    @Override
    public EventType<? extends InputEvent> getInputEvent() {
        return KeyEvent.KEY_RELEASED;
    }

    @Override
    public EventHandler<InputEvent> getInputHandler(GameData gameData) {
        return new EventHandler<InputEvent>() {
            @Override
            public void handle(InputEvent inputEvent) {
                if (inputEvent instanceof KeyEvent keyEvent) {
                    switch (keyEvent.getCode()) {
                        case UP, KeyCode.W -> gameData.getInputs().setInput(EInputTypes.UP, false);
                        case LEFT, KeyCode.A -> gameData.getInputs().setInput(EInputTypes.LEFT, false);
                        case RIGHT, KeyCode.D -> gameData.getInputs().setInput(EInputTypes.RIGHT, false);
                        case SPACE -> gameData.getInputs().setInput(EInputTypes.SHOOT, false);
                    }
                }
            }
        };
    }
}
