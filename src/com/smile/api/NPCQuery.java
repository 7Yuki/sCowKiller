package com.smile.api;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.NPC;

public class NPCQuery {

    public NPC getNearestNPC(String name, APIContext ctx) {
        return ctx.npcs().query().nameMatches(name).notInCombat().animation(-1).results().nearest();
    }
}
