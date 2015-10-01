package org.diorite.web.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;

public class Index implements EntryPoint
{
    public static final String EMPTY_FIELD = "#607d8b";
    public static final String WALL_FIELD  = "#f0f0f0";
    public static final String SNAKE_FIELD = "#aed581";
    public static final String BONUS_FIELD = "#64dd17";
    public static final String LOSE_FIELD  = "#de3226";
    public static final int    GAME_SIZE_X = 19;
    public static final int    GAME_SIZE_Z = 40;

    public static final Logger logger = Logger.getLogger("Log");
    private SnakeGame game;

    @Override
    public void onModuleLoad()
    {
        this.game = new SnakeGame(GAME_SIZE_X, GAME_SIZE_Z, this);
        this.game.start();
    }

    public void restart()
    {
        this.game = new SnakeGame(GAME_SIZE_X, GAME_SIZE_Z, this);
        this.game.start();
    }

    public static void log(final Object obj)
    {
        logger.log(Level.SEVERE, obj.toString());
    }
}
