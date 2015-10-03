package org.diorite.web.snake.client;

public enum FieldType
{
    EMPTY(SnakeModule.EMPTY_FIELD),
    BONUS(SnakeModule.BONUS_FIELD),
    SNAKE(SnakeModule.SNAKE_FIELD),
    WALL(SnakeModule.WALL_FIELD),
    INVALID(null);
    private final String color;

    FieldType(final String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        if (this == INVALID)
        {
            throw new RuntimeException("Invalid field don't have color.");
        }
        return this.color;
    }
}
