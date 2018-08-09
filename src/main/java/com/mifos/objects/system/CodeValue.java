/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.objects.system;

import lombok.Data;

@Data
public class CodeValue {
    private final Integer id;
    private final String name;
    private final String description;
    private final Integer score;
}
