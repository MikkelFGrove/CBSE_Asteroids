package dk.sdu.mmmi.cbse.common;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class GameInputs {
    private static Map<EInputTypes, Boolean> keys;
    private static Map<EInputTypes, Boolean> pkeys;

    public GameInputs() {
        keys = Collections.synchronizedMap(new EnumMap<>(EInputTypes.class));
        pkeys = Collections.synchronizedMap(new EnumMap<>(EInputTypes.class));
    }

    public void update() {
        pkeys.putAll(keys);
    }

    public void setInput(EInputTypes key, boolean b) {
        keys.put(key, b);
    }

    public boolean isDown(EInputTypes key) {
        return keys.getOrDefault(key, false);
    }

    public boolean isPressed(EInputTypes key) {
        return keys.getOrDefault(key, false) & pkeys.getOrDefault(key, false);
    }
}
