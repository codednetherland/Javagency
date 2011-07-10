/*
 *  Copyright 2011 Daniel Reimann
 *
 *  This file is part of Javagency.
 *
 *  Javagency is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation, either version 3 of
 *  the License, or (at your option) any later version.
 *
 *  Javagency is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with Javagency.
 *  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package codednetherland.javagency.model;

import java.util.List;

/**
 *  The groups of {@code Agents} that are like {@code Agents} themselves.
 *
 *  @author codednetherland <codednetherland@googlemail.com>
 *  @version 0.9
 *  @since 0.9
 */
public abstract class Agency extends MessageProcessor {

    /**
     *  This holds all {@code Agents} in a {@code Map}.
     */
    private static List<Agent> agents;
    /**
     *  Shows whether the {@code Agency} is already open.
     */
    protected boolean open;
    /**
     *  Shows whether the {@code Agency} is already closed.
     */
    protected boolean closed;
    /**
     *  The max count of {@code Agents}.
     */
    protected final long maxagents;

    /**
     *  The standard constructor of the {@code Agency}.
     *  Makes the {@code Integer} max value to the max number of {@code Agents}.
     */
    public Agency() {
        this( Long.MAX_VALUE );
    }

    /**
     *  The constructor which uses a special number of {@code Agents}.
     *
     *  @param maxagents the max number of {@code Agents}
     */
    public Agency( long maxagents ) {
        open = false;
        closed = false;
        this.maxagents = maxagents;
    }

    /**
     *  Opens the {@code Agency}.
     */
    protected void open() {
        if( !closed ) open = true;
        else throw new IllegalStateException( "The Agency is already closed." );
    }

    /**
     *  Closes the {@code Agency}.
     */
    protected void close() {
        closed = true;
    }

    /**
     *  Returns whether the {@code Agency} is open.
     *
     *  @return whether the {@code Agency} is open.
     */
    public boolean isOpen() {
        return open && !closed;
    }

    /**
     *  Returns whether the {@code Agency} is closed.
     *
     *  @return whether the {@code Agency} is closed.
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public final void receive( Message m ) {
        super.receive( m );
    }

}
