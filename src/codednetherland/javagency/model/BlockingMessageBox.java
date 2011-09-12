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

import codednetherland.javagency.exception.MessageRejectedException;
import codednetherland.javagency.exception.MessageUnavailableException;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *  A implementation of {@code MessageBox} that blocks while taking but .
 *
 *  @author codednetherland <codednetherland@googlemail.com>
 *  @version 0.9
 *  @since 0.9
 */
public class BlockingMessageBox<M extends Message> extends LinkedBlockingDeque<M> implements MessageBox<M> {

    /**
     *  {@inheritDoc}
     */
    @Override
    public void putMessage( M message ) throws MessageRejectedException {
        try {
            // TODO add inner if
            if( false ) {
                addFirst( message );
            }
            else {
                addLast( message );
            }
        }
        catch( Exception e ) {
            throw new MessageRejectedException( e );
        }
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public M takeMessage() throws MessageUnavailableException {
        try {
            return takeFirst();
        }
        catch( Exception e ) {
            throw new MessageUnavailableException( e );
        }
    }

}
