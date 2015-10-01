package org.diorite.web.client;

public enum Dir
{
    RIGHT(0, 1),
    LEFT(0, - 1),
    UP(- 1, 0),
    DOWN(1, 0);

    private final byte dirX;
    private final byte dirZ;

    Dir(final int dirX, final int dirZ)
    {
        this.dirX = (byte) dirX;
        this.dirZ = (byte) dirZ;
    }

    public byte getDirX()
    {
        return this.dirX;
    }

    public byte getDirZ()
    {
        return this.dirZ;
    }
}
