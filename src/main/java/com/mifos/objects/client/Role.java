/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.objects.client;

import lombok.Data;

/**
 * Created by ishankhanna on 09/02/14.
 */
@Data
public class Role {

    private int id;
    private final String name;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return name == role.name;
    }

    @Override
    public int hashCode() {
        if (name == null)
            return 0;
        int result = 1;
        return 31 * result + name.hashCode();
    }
}
