package dk.sdu.mmmi.cbse.weapon;

import dk.sdu.mmmi.cbse.common.Entity;
import dk.sdu.mmmi.cbse.common.GameData;
import dk.sdu.mmmi.cbse.common.World;
import dk.sdu.mmmi.cbse.common.bullet.IBulletSPI;
import dk.sdu.mmmi.cbse.common.weapon.IWeaponSPI;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class Rifle implements IWeaponSPI {
    private long lastShotTime = 0;
    private final double FIRERATE = 150;
    private final double DAMAGE = 10;

    @Override
    public void trigger(Entity e, double x, double y, double angle, GameData gameData, World world) {
        if (System.currentTimeMillis() - lastShotTime > FIRERATE) {
                getBulletSpi().stream().findFirst().ifPresent(bulletSpi -> {world.addEntity(bulletSpi.createBullet(e,x,y,angle,DAMAGE));});
                lastShotTime = System.currentTimeMillis();
        }
    }

    private Collection<? extends IBulletSPI> getBulletSpi() {
        return ServiceLoader.load(IBulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
