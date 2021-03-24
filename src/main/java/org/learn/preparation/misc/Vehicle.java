package org.learn.preparation.misc;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;

public interface Vehicle {

    // interface -- method that throws SQLException
    // abstract class --  implements same

    void getEnginePower() throws FileSystemException;

}
