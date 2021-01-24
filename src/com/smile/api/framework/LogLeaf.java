package com.smile.api.framework;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;

public abstract class LogLeaf extends LeafTask {
    public LogLeaf(APIContext ctx) {
        super(ctx);
    }
    public abstract void doExecute();

    @Override
    public void execute() {
        System.out.println("[Leaf] " + getClass().getSimpleName() + " --> Executed");
        doExecute();
    }

}
