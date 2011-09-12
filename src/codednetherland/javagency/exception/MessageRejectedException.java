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

package codednetherland.javagency.exception;

import codednetherland.javagency.model.MessageBox;

/**
 *  Occurs whenever a {@code MessageProcessor} does reject a {@code Message}.
 *  The cause can be a overflowing {@code MessageBox}.
 *
 *  @author codednetherland <codednetherland@googlemail.com>
 *  @version 0.9
 *  @since 0.9
 *  @see MessageBox
 */
public class MessageRejectedException extends Exception {

    /**
     *  Just a surrogate constructor.
     */
    public MessageRejectedException() {
        super();
    }

    /**
     *  Just a surrogate constructor.
     *
     *  @param message the detail message of the {@code MessageRejectedException}
     */
    public MessageRejectedException( String message ) {
        super( message );
    }

    /**
     *  Just a surrogate constructor.
     *
     *  @param cause the cause why the {@code MessageRejectedException} was thrown
     */
    public MessageRejectedException( Throwable cause ) {
        super( cause );
    }

    /**
     *  Just a surrogate constructor.
     *
     *  @param message the detail message of the {@code MessageRejectedException}
     *  @param cause the cause why the {@code MessageRejectedException} was thrown
     */
    public MessageRejectedException( String message, Throwable cause ) {
        super( message, cause );
    }

}
