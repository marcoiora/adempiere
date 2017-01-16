package org.compiere.install.security;

import java.lang.reflect.Method;

/**
 * Class Name   : KeyTool.java
 * Package Name : org.compiere.install
 * <p>
 * Created By   : Sergio Ramazzina - sergio.ramazzina@serasoft.it
 * Creation Date: 16/01/17
 * Description  :
 */

public class KeyTool {


    public static void main(String[] args) {
        try {
            Class<?> cl;
            try {
                // java 6 and 7
                cl = ClassLoader.getSystemClassLoader().loadClass("sun.security.tools.KeyTool");
            } catch (ClassNotFoundException e) {
                // java 8
                cl = ClassLoader.getSystemClassLoader().loadClass("sun.security.tools.keytool.Main");
            }
            Method main = cl.getMethod("main", new String[0].getClass());
            main.invoke(null, (Object) args);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            } else {
                throw new RuntimeException(e);
            }
        }
    }

}
