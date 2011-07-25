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
public abstract class Message {

    /**
     *  The sender of the {@code Message}.
     */
    private Messager sender;
    /**
     *  The receiver of the {@code Message}.
     */
    private Messager receiver;
    /**
     *  The {@code Conversation} object of the {@code Message}.
     */
    protected Conversation conver;

    /**
     *  Simply returns the sender of the {@code Message}.
     *
     *  @return the sender of the {@code Message}
     */
    public Messager getSender() {
        return sender;
    }

    /**
     *  Sets the sender of the {@code Message} but just once.
     *
     *  @param sender the sender of the {@code Message}
     *  @throws IllegalStateException if the {@code Message} has already a sender that differ from the given sender
     */
    public final void setSender( Messager sender ) {
        if( this.sender == null ) this.sender = sender;
        if( this.sender != sender ) throw new IllegalStateException( "This message has already a sender." );
    }

    /**
     *  Simply returns the receiver of the {@code Message}.
     *
     *  @return the receiver of the {@code Message}
     */
    public Messager getReceiver() {
        return receiver;
    }

    /**
     *  Sets the receiver of the {@code Message} but just once.
     *
     *  @param receiver the receiver of the {@code Message}
     *  @throws IllegalStateException if the {@code Message} has already a receiver that differ from the given receiver
     */
    public final void setReceiver( Messager receiver ) {
        if( this.receiver == null ) this.receiver = receiver;
        if( this.receiver != receiver ) throw new IllegalStateException( "This message has already a receiver." );
    }

    /**
     *  Simply returns the {@code Conversation} object of the {@code Message}.
     *
     *  @return the {@code Conversation} object of the {@code Message}
     */
    public Conversation getConversation() {
        if( conver == null ) conver = new Conversation( this );
        return conver;
    }

}
