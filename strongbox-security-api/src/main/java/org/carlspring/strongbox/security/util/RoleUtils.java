package org.carlspring.strongbox.security.util;

import org.carlspring.strongbox.security.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author mtodorov
 */
public class RoleUtils
{

    private RoleUtils() 
    {
    }

    public static List<String> toStringList(Collection<Role> roles)
    {
        List<String> rolesAsStrings = new ArrayList<>();

        for (Role role : roles)
        {
            rolesAsStrings.add(role.getName());
        }

        return rolesAsStrings;
    }

    public static List<Role> toList(Collection<Role> roles)
    {
        List<Role> rolesList = new ArrayList<>();
        rolesList.addAll(roles);

        return rolesList;
    }

}
