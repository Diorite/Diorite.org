package org.diorite.web.client;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.dom.client.Document;

public class Snake
{
    private final Set<Long> snail = new HashSet<>(10);
    private       SnakePart head  = new SnakePart(Index.GAME_SIZE_X / 2, Index.GAME_SIZE_Z / 2);
    private       SnakePart tail  = this.head;

    public SnakePart getHead()
    {
        return this.head;
    }

    public SnakePart getTail()
    {
        return this.tail;
    }

    public boolean contains(final int x, final int z)
    {
        return this.snail.contains(IntsToLong.pack(x, z));
    }

    public MoveResult move(final Dir dir, final SnakeGame game)
    {
        final int nextX = this.head.x + dir.getDirX();
        final int nextZ = this.head.z + dir.getDirZ();
        final FieldType type = game.getFieldType(nextX, nextZ);
        if ((type == FieldType.WALL) || (type == FieldType.INVALID))
        {
            return MoveResult.LOSE_WALL;
        }
        if (type == FieldType.SNAKE)
        {
            return MoveResult.LOSE_SELF;
        }

        {
            final SnakePart oldHead = this.head;
            final SnakePart newHead = new SnakePart(nextX, nextZ);
            this.head = newHead;
            if ((oldHead.prev == null) && (type != FieldType.BONUS))
            {
                oldHead.update(false);
                this.snail.remove(IntsToLong.pack(oldHead.x, oldHead.z));
                game.addFreeField(oldHead.x, oldHead.z);
            }
            else
            {
                oldHead.next = newHead;
                newHead.prev = oldHead;
            }
            newHead.update(true);

            game.removeFreeField(newHead.x, newHead.z);
        }

        if (type == FieldType.BONUS)
        {
            return MoveResult.NONE;
        }

        {
            final SnakePart oldTail = this.tail;
            final SnakePart newTail = oldTail.next;
            if (newTail != null)
            {
                this.tail = newTail;
                newTail.prev = null;
            }
            else
            {
                this.tail = this.head;
            }
            oldTail.update(false);

            this.snail.remove(IntsToLong.pack(oldTail.x, oldTail.z));
            game.addFreeField(oldTail.x, oldTail.z);
        }
        return MoveResult.NONE;
    }

    public enum MoveResult
    {
        LOSE_SELF,
        LOSE_WALL,
        WIN,
        NONE
    }

    public class SnakePart
    {
        private final int       x;
        private final int       z;
        private       SnakePart next;
        private       SnakePart prev;

        public SnakePart(final int x, final int z)
        {
            this.x = x;
            this.z = z;
            Snake.this.snail.add(IntsToLong.pack(x, z));
            this.update(true);
        }

        public int getX()
        {
            return this.x;
        }

        public int getZ()
        {
            return this.z;
        }

        public SnakePart getNext()
        {
            return this.next;
        }

        public SnakePart getPrev()
        {
            return this.prev;
        }

        public long getKey()
        {
            return IntsToLong.pack(this.x, this.z);
        }

        @Override
        public String toString()
        {
            return this.x + ":" + this.z;
        }

        @Override
        public boolean equals(final Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (! (o instanceof SnakePart))
            {
                return false;
            }

            final SnakePart snakePart = (SnakePart) o;

            return (this.x == snakePart.x) && (this.z == snakePart.z);
        }

        public void update(final boolean isSnake)
        {
            Document.get().getElementById(this.toString()).getStyle().setBackgroundColor(isSnake ? FieldType.SNAKE.getColor() : FieldType.EMPTY.getColor());
        }

        public void lose()
        {
            Document.get().getElementById(this.toString()).getStyle().setBackgroundColor(Index.LOSE_FIELD);
        }

        @Override
        public int hashCode()
        {
            int result = this.x;
            result = (31 * result) + this.z;
            return result;
        }

    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Snake{");
        SnakePart part = this.head;
        while (part != null)
        {
            sb.append(part);
            part = part.next;
            if (part != null)
            {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
