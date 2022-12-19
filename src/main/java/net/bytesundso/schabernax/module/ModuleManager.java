package net.bytesundso.schabernax.module;

import net.bytesundso.schabernax.module.generic.Module;
import net.bytesundso.schabernax.module.generic.ProxyModule;
import net.bytesundso.schabernax.module.modules.movement.AntiHumanBypass;

import java.util.function.Consumer;

public class ModuleManager {
    private static ModuleManager instance = new ModuleManager();
    private ModuleManager() { }

    public static ModuleManager getInstance() {
        return instance;
    }
    Module[] movement = {
        new AntiHumanBypass()
    };
    Module[] render = {

    };
    Module[] world = {

    };

    public void foreachModule(Consumer<Module> action) {
    }

    public void foreachProxyModule(Consumer<ProxyModule> action) {
        for (Module m : movement)
            if (m instanceof ProxyModule pm)
                action.accept(pm);

        for (Module m : render)
            if (m instanceof ProxyModule pm)
                action.accept(pm);

        for (Module m : world)
            if (m instanceof ProxyModule pm)
                action.accept(pm);
    }
}
