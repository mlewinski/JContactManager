package org.jcontactmanager.util;

import javax.naming.OperationNotSupportedException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class JcmLogger {
    private final static String WARN_HEADER = "\n\t| JcmLogger :\tWARNING\t|\t";
    private final static String ERR_HEADER = "\n\t| JcmLogger :\tERROR\t|\t";
    private final static String INFO_HEADER = "\n\t| JcmLogger :\tINFO\t|\t";
    private final static String MESG_HEADER = "\n\t| JcmLogger :\tMESSAGE\t|\t";

    private static File logFile;

    static{
        logFile = new File("log.txt");
    }

    public JcmLogger(){
        logFile = new File("log.txt");
    }

    public JcmLogger(String path){
        logFile = new File(path);
    }

    public JcmLogger(File file){
        logFile = file;
    }

    /**
     * Logs general message to a log file
     * @param message Message to be logged
     * @throws IOException
     */
    public static void LogMessage(String message) throws IOException{
        try{
            if(!logFile.exists()) logFile.createNewFile();
            Files.write(Paths.get(logFile.getAbsolutePath()), (MESG_HEADER + (new Date()).toString() +" | "+ message).getBytes(), StandardOpenOption.APPEND);
        } catch(IOException ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    /**
     * Logs warning to a log file
     * @param message Warning message
     * @throws IOException
     */
    public static void LogWarning(String message) throws IOException{
        try{
            if(!logFile.exists()) logFile.createNewFile();
            Files.write(Paths.get(logFile.getAbsolutePath()), (WARN_HEADER + (new Date()).toString() +" | "+ message).getBytes(), StandardOpenOption.APPEND);
        } catch(IOException ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    /**
     * Logs information to a log file
     * @param message Info message
     * @throws IOException
     */
    public static void LogInfo(String message) throws IOException{
        try{
            if(!logFile.exists()) logFile.createNewFile();
            Files.write(Paths.get(logFile.getAbsolutePath()), (INFO_HEADER + (new Date()).toString() +" | "+ message).getBytes(), StandardOpenOption.APPEND);
        } catch(IOException ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    /**
     * Logs error message to a log file
     * @param message Error message
     * @throws IOException
     */
    public static void LogError(String message) throws IOException{
        try{
            if(!logFile.exists()) logFile.createNewFile();
            Files.write(Paths.get(logFile.getAbsolutePath()), (ERR_HEADER + (new Date()).toString() +" | "+ message).getBytes(), StandardOpenOption.APPEND);
        } catch(IOException ex){
            ex.printStackTrace();
            throw ex;
        }
    }
}
