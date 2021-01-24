package com.smile.branches;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.model.Area;
import com.epicbot.api.shared.model.Tile;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.smile.api.framework.LogBranch;
import com.smile.leafs.WalkToPen;

public class IsPlayerInPen extends LogBranch {
    public IsPlayerInPen(APIContext ctx) {
        super(ctx);
    }
    private final Area lumbyDeathArea = new Area(new Tile(3217, 3226, 0), new Tile(3231, 3213, 0));

    @Override
    protected TreeTask doCreateSuccessTask(APIContext ctx) {
        return new WalkToPen(ctx);
    }

    @Override
    protected TreeTask doCreateFailureTask(APIContext ctx) {
        return new IsInteracting(ctx);
    }

    @Override
    public boolean validate() {
        return lumbyDeathArea.contains(ctx.localPlayer().get());
    }
}
