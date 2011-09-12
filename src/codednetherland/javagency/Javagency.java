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

package codednetherland.javagency;

import codednetherland.javagency.exception.MessageRejectedException;
import codednetherland.javagency.model.Message;
import codednetherland.javagency.model.Messager;

/**
 *  The static class of Javagency.
 *  It's a pretty mighty tool so use it wisely.
 *  It is supposed to be used to control the program from the outside.
 *  You can see it as tool to make the main Thread an Agent.
 *  It is not meant to be used by the {@code Agents}.
 *
 *  @author codednetherland <codednetherland@googlemail.com>
 *  @version 0.9
 *  @since 0.9
 */
public final class Javagency {

    /**
     *  No use for.
     */
    private Javagency() {
        // will never be invoked because {@code Javagency} is fully static
    }

    /**
     *  Sends a {@code AbstractMessage} to the {@code Agent}.
     *
     *  @param agent the {@code Agent} to send the {@code Message} to
     *  @param message the {@code Agent} to send the {@code Message}
     */
    public static void send( Messager agent, Message message ) throws MessageRejectedException {
        agent.receive( message );
    }

}
