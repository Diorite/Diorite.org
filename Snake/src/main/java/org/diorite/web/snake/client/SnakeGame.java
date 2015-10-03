package org.diorite.web.snake.client;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;

import org.diorite.web.snake.client.Snake.MoveResult;
import org.diorite.web.snake.client.Snake.SnakePart;

@SuppressWarnings({"ClassHasNoToStringMethod", "Convert2Lambda"})
public class SnakeGame extends Timer
{
    public static final int BONUS_BONUS_CAHNCE = 30;
    public static final int LOSE_TICK          = 50;
    public static final int GAME_TICK          = 200;
    public static final int MIN_GAME_SPEED     = 75;
    public static final int SPEED_INCREASE_MOD = 50;

    private final int   sizeX;
    private final int   sizeZ;
    private       int   gameTick;
    private final Snake snake;

    private final Set<Long> bonuses;
    private final Set<Long> walls;
    private final Set<Long> freeFields;

    private Dir dir = Dir.RIGHT;

    private final Random rand = new Random();
    private final SnakeModule snakeModule;

    public SnakeGame(final int sizeX, final int sizeZ, final SnakeModule snakeModule)
    {
        this.bonuses = new HashSet<>(3);
        this.walls = new HashSet<>(20);

        this.sizeX = sizeX;
        this.sizeZ = sizeZ;
        this.gameTick = GAME_TICK * SPEED_INCREASE_MOD;
        this.snakeModule = snakeModule;

        this.freeFields = new HashSet<>(sizeX * sizeZ);
        for (int x = 0; x < sizeX; x++)
        {
            for (int z = 0; z < sizeZ; z++)
            {
                this.freeFields.add(IntsToLong.pack(x, z));
                Document.get().getElementById(x + ":" + z).getStyle().setBackgroundColor(FieldType.EMPTY.getColor());
            }
        }
        this.snake = new Snake();
        this.freeFields.remove(this.snake.getHead().getKey());
    }

    public void removeFreeField(final int x, final int z)
    {
        final long key = IntsToLong.pack(x, z);
        this.freeFields.remove(key);
        this.bonuses.remove(key);
    }

    public void addFreeField(final int x, final int z)
    {
        this.freeFields.add(IntsToLong.pack(x, z));
    }

    public void start()
    {
        RootPanel.get().addDomHandler(new KeyDownHandler()
        {
            @Override
            public void onKeyDown(final KeyDownEvent event)
            {
                if ((SnakeGame.this.dir != Dir.UP) && event.isDownArrow())
                {
                    SnakeGame.this.dir = Dir.DOWN;
                }
                else if ((SnakeGame.this.dir != Dir.DOWN) && event.isUpArrow())
                {
                    SnakeGame.this.dir = Dir.UP;
                }
                else if ((SnakeGame.this.dir != Dir.LEFT) && event.isRightArrow())
                {
                    SnakeGame.this.dir = Dir.RIGHT;
                }
                else if ((SnakeGame.this.dir != Dir.RIGHT) && event.isLeftArrow())
                {
                    SnakeGame.this.dir = Dir.LEFT;
                }
            }
        }, KeyDownEvent.getType());

        this.schedule(GAME_TICK);
    }

    @Override
    public void run()
    {
        if (this.gameTick > (MIN_GAME_SPEED * SPEED_INCREASE_MOD))
        {
            this.gameTick--;
        }
        final MoveResult result = this.snake.move(this.dir, this);
        if (this.bonuses.isEmpty() || (this.rand.nextInt(BONUS_BONUS_CAHNCE) == 0))
        {
            this.spawnBonusField();
        }
        if (result == MoveResult.NONE)
        {
            this.schedule(this.gameTick / SPEED_INCREASE_MOD);
        }
        else
        {
            new Timer()
            {
                SnakePart part = SnakeGame.this.snake.getHead();

                @Override
                public void run()
                {
                    this.part.lose();
                    this.part = this.part.getPrev();
                    if (this.part == null)
                    {
                        SnakeGame.this.snakeModule.restart();
                        return;
                    }
                    this.schedule(LOSE_TICK);
                }
            }.schedule(LOSE_TICK);
        }
    }

    public boolean spawnBonusField()
    {
        if (this.freeFields.isEmpty())
        {
            return false;
        }
        final Long[] values = this.freeFields.toArray(new Long[this.freeFields.size()]);
        final long cords = values[this.rand.nextInt(values.length)];
        this.freeFields.remove(cords);
        this.bonuses.add(cords);
        Document.get().getElementById(IntsToLong.getA(cords) + ":" + IntsToLong.getB(cords)).getStyle().setBackgroundColor(FieldType.BONUS.getColor());
        return true;
    }

    public FieldType getFieldType(final int x, final int z)
    {
        if ((x >= this.sizeX) || (x < 0) || (z >= this.sizeZ) || (z < 0))
        {
            return FieldType.INVALID;
        }
        if (this.snake.contains(x, z))
        {
            return FieldType.SNAKE;
        }
        final long key = IntsToLong.pack(x, z);
        if (this.bonuses.contains(key))
        {
            return FieldType.BONUS;
        }
        if (this.walls.contains(key))
        {
            return FieldType.WALL;
        }
        return FieldType.EMPTY;
    }
}
