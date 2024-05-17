package com.yahya.tests.Day9;

import com.yahya.utility.DB_Util;
import com.yahya.utility.LibraryAPI_BaseTest;
import org.junit.jupiter.api.Test;

public class LibraryAPIDBTest extends LibraryAPI_BaseTest {

    @Test
    public void testDB(){

        DB_Util.runQuery("SELECT * FROM books");
        System.out.println("DB_Util.getRowCount() = " + DB_Util.getRowCount());
        //DB_Util.displayAllData();
    }
}
