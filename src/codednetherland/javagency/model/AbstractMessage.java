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

/**
 *  The {@code Objects} that will be traveling between the {@code Messagers}.
 *
 *  @author codednetherland <codednetherland@googlemail.com>
 *  @version 0.9
 *  @since 0.9
 */
public abstract class AbstractMessage implements Message {

    /**
     *  The sender of the {@code AbstractMessage}.
     */
    protected Messager sender;
    /**
     *  The receiver of the {@code AbstractMessage}.
     */
    protected Messager receiver;
    /**
     *  The {@code Conversation} object of the {@code AbstractMessage}.
     */
    protected Conversation conver;

    /**
     *  The standard constructor of {@code AbstractMessage}.
     */
    public AbstractMessage() {

    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public Messager getSender() {
        return sender;
    }

    /**
     *  Sets the sender of the {@code Message} but just once.
     *
     *  @param sender the sender of the {@code Message}
     */
    public final void setSender( Messager sender ) {
        if( this.sender == null ) this.sender = sender;
        if( this.sender != sender ) throw new IllegalStateException( "This message has already a sender." );
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public Messager getReceiver() {
        return receiver;
    }

    /**
     *  Sets the receiver of the {@code Message} but just once.
     *
     *  @param receiver the receiver of the {@code Message}
     */
    public final void setReceiver( Messager receiver ) {
        if( this.receiver == null ) this.receiver = receiver;
        if( this.receiver != receiver ) throw new IllegalStateException( "This message has already a receiver." );
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public Conversation getConversation() {
        if( conver == null ) conver = new Conversation( this );
        return conver;
    }

}
