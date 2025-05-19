package dk.sdu.mmmi.cbse.common.weapon;

import dk.sdu.mmmi.cbse.common.Entity;
import dk.sdu.mmmi.cbse.common.GameData;
import dk.sdu.mmmi.cbse.common.World;

public interface IWeaponSPI {
    void trigger(Entity e, double x, double y, double angle, GameData gameData, World world);
}
