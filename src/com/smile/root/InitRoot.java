package com.smile.root;
import com.smile.api.framework.LogBranch;
import com.smile.branches.DoesInvContainEquipment;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.TreeTask;
import com.smile.leafs.LogIn;

//LogBranch is another custom api (will be open sourcing my API soon!)
public class InitRoot extends LogBranch {
    //this is just the constructor for your class
    public InitRoot(APIContext ctx) {super(ctx);}

    //If your validate returns true, it'll do the doCreateSuccessTask() method. (Also a part of my API)
    @Override
    protected TreeTask doCreateSuccessTask(APIContext ctx) {
        return new DoesInvContainEquipment(ctx);
    }

    //if your validate method returns false it will do the doCreateFailureTask() method. (That's also a part of my API)
    @Override
    protected TreeTask doCreateFailureTask(APIContext ctx) {
        return new LogIn(ctx);
    }

    //In your validate method you need to have a boolean.
    @Override
    public boolean validate() { return ctx.client().isLoggedIn(); }
}

/*
Short summary about branches:
    Branches are just your if else statements like if you were to do it in LoopScript. Personally, I find this easier to do than to do that.
    Branches should be for checking if something is true or false. (you do not have to null check in your branches, you do that in your leafs)
 */
