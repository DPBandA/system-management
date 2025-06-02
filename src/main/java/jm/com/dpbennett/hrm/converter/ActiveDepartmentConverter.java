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
package jm.com.dpbennett.hrm.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import jm.com.dpbennett.business.entity.hrm.Department;
import jm.com.dpbennett.sm.converter.ConverterAdapter;

/**
 *
 * @author desbenn
 */
@FacesConverter("activeDepartmentConverter")
public class ActiveDepartmentConverter extends ConverterAdapter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        EntityManager em = (EntityManager) component.getAttributes().get("em");
        Department department = Department.findActiveByName(em, value);

        if (department == null) {
            department = new Department(value);
        }

        return department;
    }

}
