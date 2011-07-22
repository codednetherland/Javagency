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

package codednetherland.javagency.message;

import codednetherland.javagency.model.AbstractMessage;

/**
 *  A {@code AbstractMessage} that contains a {@code Object}.
 *  The {@code Object} should be immutable or at least synchronized.
 *
 *  @author codednetherland <codednetherland@googlemail.com>
 *  @version 0.9
 *  @since 0.9
 *
 *  @param <O> the type of the {@code Object} to send
 */
public class ObjectMessage<O extends Object> extends AbstractMessage {

    /**
     *  The {@code Object} to send.
     */
    protected final O object;

    /**
     *  The constructor of {@code ObjectMessage}.
     *
     *  @param object the {@code Object} to send
     */
    public ObjectMessage( O object ) {
        this.object = object;
    }

    /**
     *  Returns the {@code Object} held by the {@code ObjectMessage}.
     *
     *  @return the {@code Object} held by the {@code ObjectMessage}
     */
    public O getObject() {
        return object;
    }

}
