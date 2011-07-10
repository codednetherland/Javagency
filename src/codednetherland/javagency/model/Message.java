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
 *  An interface for {@code Messages} with which you can make any {@code Object} a {@code Message}.
 *
 *  @author codednetherland <codednetherland@googlemail.com>
 *  @version 0.9
 *  @since 0.9
 */
public interface Message {

    /**
     *  Simply returns the sender of the {@code Message}.
     *
     *  @return the sender of the {@code Message}
     */
    public Messager getSender();

    /**
     *  Simply returns the receiver of the {@code Message}.
     *
     *  @return the receiver of the {@code Message}
     */
    public Messager getReceiver();

    /**
     *  Simply returns the {@code Conversation} object of the {@code Message}.
     *
     *  @return the {@code Conversation} object of the {@code Message}
     */
    public Conversation getConversation();

}
