package com.example.felix.delivery.data;

import android.provider.BaseColumns;

/**
 * Created by FeliX on 31.05.2017.
 */

public final class DbContract {

    private DbContract() {
    };

    public static final class GuestEntry implements BaseColumns {
        public final static String TABLE_NAME = "guests";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_ITEM = "city";
        public final static String COLUMN_COUNTS = "gender";

        //public static final int GENDER_FEMALE = 0;
        //public static final int GENDER_MALE = 1;
        //public static final int GENDER_UNKNOWN = 2;
    }

}
