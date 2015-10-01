package org.diorite.web.client;

public enum FieldType
{
    EMPTY(Index.EMPTY_FIELD),
    BONUS(Index.BONUS_FIELD),
    SNAKE(Index.SNAKE_FIELD),
    WALL(Index.EMPTY_FIELD),
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
