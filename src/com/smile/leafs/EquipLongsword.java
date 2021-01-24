package com.smile.leafs;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.epicbot.api.shared.util.time.Time;

public class EquipLongsword extends LeafTask {
    public EquipLongsword(APIContext ctx) {
        super(ctx);
    }

    @Override
    public void execute() {
        if (ctx.client().isLoggedIn()) {
            ctx.inventory().interactItem("Wield", "Mithril longsword");
        } else {
            Time.sleep(2000, 5000, () -> ctx.client().isLoggedIn());
        }
    }
}
