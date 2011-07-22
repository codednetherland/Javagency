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

/**
 *  A {@code ObjectMessage} that contains a {@code Exception}.
 *
 *  @author codednetherland <codednetherland@googlemail.com>
 *  @version 0.9
 *  @since 0.9
 *
 *  @param <E> the type of the {@code Exception} to send
 */
public class ExceptionMessage<E extends Exception> extends ObjectMessage<E> {

    /**
     *  The constructor of {@code ExceptionMessage}.
     *
     *  @param except the {@code Exception} to send
     */
    public ExceptionMessage( E except ) {
        super( except );
    }

    /**
     *  Returns the {@code Exception} held by the {@code ExceptionMessage}.
     *
     *  @return the {@code Exception} held by the {@code ExceptionMessage}
     */
    public E getException() {
        return getObject();
    }

}
