/*
Business Entity Library (BEL) - A foundational library for JSF web applications 
Copyright (C) 2024  D P Bennett & Associates Limited

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

Email: info@dpbennett.com.jm
 */
package jm.com.dpbennett.sm.util;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import javax.faces.model.ListDataModel;
import jm.com.dpbennett.business.entity.hrm.Contact;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author dbennett
 */
public class ContactDataModel extends ListDataModel<Contact> implements SelectableDataModel<Contact> {
    
    private List<Contact> list;

    public ContactDataModel() {
    }

    public ContactDataModel(List<Contact> list) {
        super(list);
        this. list = list;
    }

//    @Override
//    public Object getRowKey(Contact contact) {
//        return contact.getId();
//    }

    @Override
    public Contact getRowData(String rowKey) {
        for (Contact contact : list) {
            if (contact.getId().toString().equals(rowKey)) {
                return contact;
            }
        }

        return null;
    }

    @Override
    public String getRowKey(Contact t) {
        return t.getId().toString();
    }
}
