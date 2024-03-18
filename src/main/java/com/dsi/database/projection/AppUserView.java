package com.dsi.database.projection;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

public interface AppUserView {

    Long getId();
    String getName();
    String getEmail();

}
