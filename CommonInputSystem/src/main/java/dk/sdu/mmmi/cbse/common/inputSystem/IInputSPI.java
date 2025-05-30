package dk.sdu.mmmi.cbse.common.inputSystem;

import dk.sdu.mmmi.cbse.common.GameData;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.InputEvent;

public interface IInputSPI {
    /**
     * Returns the specific input event that is needed for the type of input at hand
     *
     *
     * @return the {@code EventType} corresponding to a specific subclass of {@code InputEvent} that this handler is interested in
     * @precondition
     *
     * @postcondition
     * <p>- A returned {@code EventType}
     */
    EventType<? extends InputEvent> getInputEvent();

    /**
     * Returns a custom input handler for the associated input event.
     *
     * @param gameData includes methods for setting the different keys that are being pressed
     * @return the {@code EventHandler} responsible that processes the {@code InputEvent} given
     * @precondition
     *  <p>- The parameter {@code gameData} is not null
     * @postcondition
     * <p>- A returned {@code EventHandler}
     */
    EventHandler<InputEvent> getInputHandler(GameData gameData);
}