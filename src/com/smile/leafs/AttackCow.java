package com.smile.leafs;
import com.smile.CowKiller;
import com.smile.api.NPCQuery;
import com.smile.api.State;
import com.smile.api.framework.LogLeaf;
import com.epicbot.api.shared.APIContext;

public class AttackCow extends LogLeaf {
    private final NPCQuery query = new NPCQuery();

    public AttackCow(APIContext ctx) {
        super(ctx);
    }

    @Override
    public void doExecute() {
        if (query.getNearestNPC("Cow",ctx) != null) {
            if (query.getNearestNPC("Cow", ctx).interact("Attack") && ctx.mouse().isPresent()) {
                ctx.mouse().moveOffScreen();
            }
        }

        CowKiller.state = State.ATTACKING;
    }
}
