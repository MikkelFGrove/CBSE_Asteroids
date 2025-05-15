package dk.sdu.mmmi.cbse.input;

import dk.sdu.mmmi.cbse.common.GameData;
import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;

public class Mouse implements IInputSPI {
    @Override
    public EventType<? extends InputEvent> getInputEvent() {
        return MouseEvent.MOUSE_MOVED;
    }

    @Override
    public EventHandler<InputEvent> getInputHandler(GameData gameData) {
        return new EventHandler<>() {
            @Override
            public void handle(InputEvent inputEvent) {
                if (inputEvent instanceof MouseEvent mouseEvent) {
                    gameData.setMousePosition(mouseEvent.getSceneX(), mouseEvent.getSceneY());
                }
            }
        };
    }
}
