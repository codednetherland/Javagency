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

import java.util.ArrayList;
import java.util.List;

/**
 *  A class to respond on {@code Messages}.
 *  This is only supposed to be between 2 {@code Messagers} for more please use {@code Agencys} like {@code Maillist}.
 *  Use this carefully because it may consume much space because the {@code Conversation} holds all {@code Messages}
 *  in the primary memory and one {@code Message} can hold the whole {@code Conversation} in memory.
 *
 *  @author codednetherland <codednetherland@googlemail.com>
 *  @version 0.9
 *  @since 0.9
 *
 *  @param <M> the type of {@code Message} that is necessary for responses
 */
public final class Conversation<M extends Message> {

    /**
     *  The history of the {@code Conversation}.
     */
    protected volatile List<M> msgline;
    /**
     *  The two {@code Messager} that attend the {@code conversation}.
     */
    private Messager[] attenders;

    /**
     *  The standard constructor.
     */
    public Conversation() {
        msgline = new ArrayList<M>();
        attenders = new Messager[2];
    }

    /**
     *  A constructor to add the {@code Message} as first {@code Message} in the {@code Conversation}.
     *
     *  @param m the first {@code Message} in the {@code Conversation}
     */
    public Conversation( M m ) {
        this();
        add( m );
    }

    /**
     *  Sets the 2 attenders but just once.
     *
     *  @param attend1 attender number 1
     *  @param attend2 attender number 2
     *  @throws IllegalStateException if the attenders are already set
     */
    protected synchronized final void setAttenders( Messager attend1, Messager attend2 ) {
        if( attenders[0] != null && attenders[1] != null ) {
            attenders[0] = attend1;
            attenders[1] = attend2;
        }
        else {
            throw new IllegalStateException( "The attenders are already set." );
        }
    }

    /**
     *  Adds a {@code Message} to the {@code Conversation}.
     *
     *  @param m the {@code Message} to add
     */
    public synchronized void add( M m ) {
        if( size() <= 0 ) setAttenders( m.getSender(), m.getReceiver() );
        int curin = size() % 2;
        if( m.getSender() == attenders[curin] ) msgline.add( m );
        else throw new IllegalStateException( "It is not your turn to respond." );
    }

    /**
     *  Returns the {@code Message} at the position {@code index}.
     *
     *  @param index the position of the {@code Message} to return
     *  @return the {@code Message} at the position {@code index}
     */
    public M get( int index ) {
        return msgline.get( index );
    }

    /**
     *  Returns the {@code Message} at the start of the {@code Conversation}.
     *
     *  @return the {@code Message} at the start of the {@code Conversation}
     */
    public M getFirst() {
        return get( 0 );
    }

    /**
     *  Returns the {@code Message} at the end of the {@code Conversation}.
     *
     *  @return the {@code Message} at the end of the {@code Conversation}
     */
    public M getLast() {
        return get( size() - 1 );
    }

    /**
     *  Simply returns the number of {@code Messages} int the {@code Conversation}.
     *
     *  @return the number of {@code Messages} int the {@code Conversation}
     */
    public int size() {
        return msgline.size();
    }

}
