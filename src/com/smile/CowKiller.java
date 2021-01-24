package com.smile;
import com.epicbot.api.shared.model.Skill;
import com.smile.api.State;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.GameType;
import com.epicbot.api.shared.script.ScriptManifest;
import com.epicbot.api.shared.script.TreeScript;
import com.epicbot.api.shared.util.paint.frame.PaintFrame;
import com.epicbot.api.shared.util.time.Time;
import com.smile.root.InitRoot;
import java.awt.*;
/*
    discord: smile#0700
    epicbot discord: discord.gg/epicbot

 */

@ScriptManifest(gameType = GameType.OS, name = "sCowKiller - Tree")
public class CowKiller extends TreeScript {

    //instantiating our variables
    private int attackStartLvl;
    private int strengthStartLvl;
    private int defenceStartLvl;
    private long startTime;
    //custom method from my API, dont worry about this
    public static State state = State.WALKING;

    //getting start level
    private int getStartLevel(Skill.Skills startingSkillLevel) {
        return getAPIContext().skills().get(startingSkillLevel).getCurrentLevel();
    }
    @Override
    public boolean onStart(String... strings) {
        //getting current levels
        attackStartLvl = getStartLevel(Skill.Skills.ATTACK);
        strengthStartLvl = getStartLevel(Skill.Skills.STRENGTH);
        defenceStartLvl = getStartLevel(Skill.Skills.DEFENCE);
        //for run time
        startTime = System.currentTimeMillis();

        //setRootTask() is just the first branch that will be called in your script, hence why you want it to be in your onStart() method.
        //Go to the InitRoot class to get familiar with branches.
        //Go to the WalkToPen class if you need to get familiar with Leafs.
        setRootTask(new InitRoot(getAPIContext()));
        //this sets the loop delay. I usually use 500-1000ms (.5 to 1 second) but had less errors with 1000ms delay.
        setIterationDelay(1000);

        System.out.println("Starting sCowKiller - Tree!");
        return true;
    //Methods for getting gained levels
    }
    private int getAttackLvls() {
        return getAPIContext().skills().get(Skill.Skills.ATTACK).getCurrentLevel() - attackStartLvl;
    }
    private int getStrengthLvls() {
        return  getAPIContext().skills().get(Skill.Skills.STRENGTH).getCurrentLevel() - strengthStartLvl;
    }
    private int getDefenceLvls() {
        return getAPIContext().skills().get(Skill.Skills.DEFENCE).getCurrentLevel() - defenceStartLvl;
    }

    //Paint shit
    @Override
    protected void onPaint(Graphics2D g, APIContext ctx) {
        super.onPaint(g, ctx);
        if (getAPIContext().client().isLoggedIn()) {
            PaintFrame pf = new PaintFrame("sCowKiller - Tree");
            pf.addLine("Runtime: ", Time.getFormattedRuntime(startTime));
            pf.addLine("Status: ", state.name());
            pf.addLine("Attack: ", getAPIContext().skills().attack().getCurrentLevel() + " +(" + getAttackLvls() + ")");
            pf.addLine("Strength: ", getAPIContext().skills().strength().getCurrentLevel() + " +(" + getStrengthLvls() + ")");
            pf.addLine("Defence: ", getAPIContext().skills().defence().getCurrentLevel() + " +(" + getDefenceLvls() + ")");
            pf.draw(g,0,90,ctx);
        }
    }
}
