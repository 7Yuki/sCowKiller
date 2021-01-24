package com.smile.api.framework;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;

public abstract class LogBranch extends BranchTask {

    public LogBranch(APIContext ctx) {
        super(ctx);
    }
    protected abstract TreeTask doCreateSuccessTask(APIContext ctx);
    protected abstract TreeTask doCreateFailureTask(APIContext ctx);

    @Override
    protected TreeTask createSuccessTask(APIContext ctx) {
        System.out.println("[Branch] " + getClass().getSimpleName() + " --> Success");
        return doCreateSuccessTask(ctx);
    }

    @Override
    protected TreeTask createFailureTask(APIContext ctx) {
        System.out.println("[Branch] " + getClass().getSimpleName() + " --> Failure");
        return doCreateFailureTask(ctx);
    }
}
