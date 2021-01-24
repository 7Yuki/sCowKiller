package com.smile.leafs;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.model.Area;
import com.epicbot.api.shared.model.Tile;
import com.epicbot.api.shared.util.Random;
import com.epicbot.api.shared.util.time.Time;
import com.smile.CowKiller;
import com.smile.api.State;
import com.smile.api.framework.LogLeaf;
//LogLeaf is a part of my API, will be open sourcing it soon so that people can contribute to it.
public class WalkToPen extends LogLeaf {
    //Defining areas and other private variables.
    private final Area topCowPen = new Area(new Tile(3243, 3296, 0), new Tile(3264, 3282, 0));
    private final Area bottomCowPen = new Area(new Tile(3254, 3272, 0), new Tile(3264, 3256, 0));
    private boolean shouldWalkToTopPen;
    public WalkToPen(APIContext ctx) {
        super(ctx);
    }

    //doExecute is a part of my own API.
    //This is where you do your actions and null checking. Your script will then restart at the root once it hits a leaf.
    //Example: Root -> IsPlayerInPen()? -> True -> AttackCow() -> Restart back to root branch.
    @Override
    public void doExecute() {
        if (ctx.client().isLoggedIn()) {
            shouldWalkToTopPen = Random.nextBoolean();
            if (!shouldWalkToTopPen) {
                ctx.webWalking().walkTo(bottomCowPen.getRandomTile());
            } else {
                ctx.webWalking().walkTo(topCowPen.getRandomTile());
            }
            CowKiller.state = State.WALKING;
        } else {
            Time.sleep(2000, 5000, () -> ctx.client().isLoggedIn());
        }
    }
}
