package dk.sdu.mmmi.cbse.weapon;

import dk.sdu.mmmi.cbse.common.GameData;
import dk.sdu.mmmi.cbse.common.World;
import dk.sdu.mmmi.cbse.common.bullet.IBulletSPI;
import dk.sdu.mmmi.cbse.common.weapon.IWeaponSPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

public class Rifle implements IWeaponSPI {
    private long lastShotTime = 0;

    @Override
    public void trigger(double x, double y, double angle, GameData gameData, World world) {
            if (System.currentTimeMillis() - lastShotTime > 100){
                getBulletSpi().stream().findFirst().ifPresent(bulletSpi -> {world.addEntity(bulletSpi.createBullet(x,y,angle));});
                lastShotTime = System.currentTimeMillis();
            }
    }

    private Collection<? extends IBulletSPI> getBulletSpi() {
        return ServiceLoader.load(IBulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
