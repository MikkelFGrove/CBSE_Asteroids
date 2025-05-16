package dk.sdu.mmmi.cbse.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class World {
    private final Map<String, Entity> entityMap = new ConcurrentHashMap<>();

    public <E extends Entity> List<Entity> getEntities(Class<E>... entityTypes) {
        List<Entity> r = new ArrayList<>();
        for (Entity e : getEntities()) {
            for (Class<E> entityType : entityTypes) {
                if (entityType.equals(e.getClass())) {
                    r.add(e);
                }
            }
        }
        return r;
    }

    public Collection<Entity> getEntities() {
        return entityMap.values();
    }
    public List<Entity> getEntities(EEntityTypes entityType) {
        List<Entity> r = new ArrayList<>();
        for (Entity e : getEntities()) {
            if (e.getEntityType().equals(entityType)) {
                r.add(e);
            }
        }
        return r;
    }

    public void addEntity(Entity e) {
        entityMap.put(e.getUUID(), e);
    }

    public void removeEntity(Entity entity) {
        entityMap.remove(entity.getUUID());
    }

    public boolean isCoordOutsidePlayArea(double x, double y, GameData gameData) {
        if (x > gameData.getWindowWidth() || x < 0 || y > gameData.getWindowHeight() || y < 0) {
            return true;
        } else {
            return false;
        }
    }
}
