package com.smile.branches;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.smile.api.framework.LogBranch;

public class DoesInvContainEquipment extends LogBranch {

    public DoesInvContainEquipment(APIContext ctx) {
        super(ctx);
    }

    @Override
    protected TreeTask doCreateSuccessTask(APIContext ctx) { return new IsPlayerInPen(ctx); }

    @Override
    protected TreeTask doCreateFailureTask(APIContext ctx) {
        return new IsWeaponEquipped(ctx);
    }

    @Override
    public boolean validate() {
        return ctx.inventory().onlyContains("Mithril longsword");
    }
}
