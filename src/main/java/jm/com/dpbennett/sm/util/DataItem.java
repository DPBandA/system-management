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

/**
 *
 * @author dbennett
 */
public class DataItem extends SortableSelectItem {

    public DataItem() {
        super("", "");
    }

    public DataItem(Object value, String label) {
        super(value, label);
    }

    @Override
    public String getLabel() {
        return super.getLabel(); 
    }

    @Override
    public void setLabel(String label) {
        super.setLabel(label);
    }

    @Override
    public Object getValue() {
        return super.getValue(); 
    }

    @Override
    public void setValue(Object value) {
        super.setValue(value); 
    }

}
