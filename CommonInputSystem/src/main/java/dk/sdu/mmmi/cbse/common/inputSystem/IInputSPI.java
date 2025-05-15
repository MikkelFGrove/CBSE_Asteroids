package dk.sdu.mmmi.cbse.common.inputSystem;

import dk.sdu.mmmi.cbse.common.GameData;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.InputEvent;

public interface IInputSPI {
    EventType<? extends InputEvent> getInputEvent();

    EventHandler<InputEvent> getInputHandler(GameData gameData);
}