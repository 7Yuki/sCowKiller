package com.smile.leafs;
import com.smile.api.framework.LogLeaf;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.util.time.Time;

public class LogIn extends LogLeaf {
    public LogIn(APIContext ctx) {
        super(ctx);
    }

    @Override
    public void doExecute() {
        Time.sleep(2_000, () -> ctx.tabs().getCurrent() != null);
    }
}
