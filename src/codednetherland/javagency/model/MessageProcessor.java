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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *  The subclass of {@code Thread} that processes {@code Messages}.
 *
 *  @author codednetherland <codednetherland@googlemail.com>
 *  @version 0.9
 *  @since 0.9
 */
public abstract class MessageProcessor extends Thread implements Messager {

    /**
     *  The mailbox of the {@code MessageProcessor}.
     */
    protected final BlockingQueue<Message> mailbox;

    /**
     *  Constructor for the final mailbox element.
     */
    public MessageProcessor() {
        mailbox = new LinkedBlockingQueue<Message>();
    }

    /**
     *  Sends the {@code Message} to the {@code Messager}.
     *
     *  @param agent the {@code Agent} to send the {@code Message} to
     *  @param message the {@code Message} to the {@code Agent}
     */
    protected final void send( Messager agent, Message message ) {
        agent.receive( message );
    }

    /**
     *  Responds to a {@code Message}.
     *
     *  @param toresp the {@code Message} to respond
     *  @param response the response
     */
    protected final void respond( Message toresp, Message response ) {
        toresp.getConversation().add( response );
        send( toresp.getSender(), response );
    }

    /**
     *  Stores the {@code Message} in the {@code Queue}.
     *  This will be executed from the other {@code Agent} therefore it's so short.
     *  You should keep it short as well. ;-)
     *
     *  @param m the {@code Message} to store
     */
    @Override
    public void receive( Message m ) {
        mailbox.add( m );
        if( m instanceof InterruptingMessage ) this.interrupt();
    }

    /**
     *  Handles a {@code Message}.
     *  This will be executed by the {@code Agent} himself.
     *
     *  @param m the {@code Message} to handle
     */
    protected abstract void onReceive( Message m );

    /**
     *  The method to process the {@code Queue}.
     *  This is final because there is behavior that must be the same in every {@code Agent}.
     */
    @Override
    public final void run() {
        while( true ) {
            try {
                Message current = mailbox.take();
                onReceive( current );
            }
            catch ( InterruptedException e ) {
                // this shouldn't matter
            }

        }
    }

}
