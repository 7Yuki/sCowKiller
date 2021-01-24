package com.smile.branches;
import com.smile.api.framework.LogBranch;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.smile.leafs.AttackCow;
import com.smile.leafs.SleepUntilDead;

public class IsInteracting extends LogBranch {
    public IsInteracting(APIContext ctx) {
        super(ctx);
    }

    @Override
    protected TreeTask doCreateSuccessTask(APIContext ctx) {
        return new AttackCow(ctx);
    }

    @Override
    protected TreeTask doCreateFailureTask(APIContext ctx) { return new SleepUntilDead(ctx); }
    @Override
    public boolean validate() {
        return ctx.localPlayer().getInteracting() == null;
    }
}
