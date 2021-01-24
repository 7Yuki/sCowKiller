package com.smile.branches;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.smile.api.framework.LogBranch;
import com.smile.leafs.EquipLongsword;

public class IsWeaponEquipped extends LogBranch {
    public IsWeaponEquipped(APIContext ctx) {
        super(ctx);
    }

    @Override
    protected TreeTask doCreateSuccessTask(APIContext ctx) {
        return new EquipLongsword(ctx);
    }

    @Override
    protected TreeTask doCreateFailureTask(APIContext ctx) {
        return new IsPlayerInPen(ctx);
    }

    @Override
    public boolean validate() {
        return ctx.inventory().contains("Mithril longsword");
    }
}
