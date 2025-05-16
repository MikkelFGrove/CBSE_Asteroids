package dk.sdu.mmmi.cbse.common.spaceship;
import dk.sdu.mmmi.cbse.common.Entity;
import dk.sdu.mmmi.cbse.common.GameData;
import dk.sdu.mmmi.cbse.common.World;

public interface ISpaceship{
    Entity createSpaceship(GameData gamedata, World world);
}
