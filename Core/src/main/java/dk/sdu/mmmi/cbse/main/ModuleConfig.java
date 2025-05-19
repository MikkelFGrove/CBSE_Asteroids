package dk.sdu.mmmi.cbse.main;

import dk.sdu.mmmi.cbse.common.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.IPostEntityProcessorService;
import dk.sdu.mmmi.cbse.common.IGamePluginService;
import dk.sdu.mmmi.cbse.common.inputSystem.IInputSPI;

import java.util.Collection;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ModuleConfig {
    public static Collection<? extends IGamePluginService> getPlugins() {
        return ServiceLoader.load(IGamePluginService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    public static Collection<? extends IEntityProcessingService> getEntityProcessingServices() {
        return ServiceLoader.load(IEntityProcessingService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    public static Collection<? extends IInputSPI> getInputSystem() {
        return ServiceLoader.load(IInputSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    public static Collection<? extends IPostEntityProcessorService> getIPostEntityProcessorService() {
        return ServiceLoader.load(IPostEntityProcessorService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
