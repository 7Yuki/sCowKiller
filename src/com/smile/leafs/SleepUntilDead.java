package com.smile.leafs;
import com.smile.CowKiller;
import com.smile.api.State;
import com.smile.api.framework.LogLeaf;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.util.time.Time;

public class SleepUntilDead extends LogLeaf {

    public SleepUntilDead(APIContext ctx) {
        super(ctx);
    }

    @Override
    public void doExecute() {

        Time.sleep(10_000,() -> ctx.localPlayer().getAnimation() == -1);

        CowKiller.state = State.TARGETING;
    }
}
