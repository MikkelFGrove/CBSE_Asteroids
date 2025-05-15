import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;
import dk.sdu.mmmi.cbse.input.KeyPressed;
import dk.sdu.mmmi.cbse.input.KeyReleased;

module InputSystem {
    requires CommonInputSystem;
    requires Common;
    requires javafx.graphics;

    provides IInputSPI with
            KeyPressed,
            KeyReleased;
}