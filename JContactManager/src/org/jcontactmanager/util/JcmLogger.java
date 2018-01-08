package org.jcontactmanager.util;

import javax.naming.OperationNotSupportedException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class JcmLogger {
    private final static String WARN_HEADER = "\t| JcmLogger :\tWARNING\t|\t";
    private final static String ERR_HEADER = "\t| JcmLogger :\tERROR\t|\t";
    private final static String INFO_HEADER = "\t| JcmLogger :\tINFO\t|\t";
    private final static String MESG_HEADER = "\t| JcmLogger :\tMESSAGE\t|\t";

    private final File logFile;

    public JcmLogger(){
        logFile = new File("log.txt");
    }

    public JcmLogger(String path){
        logFile = new File(path);
    }

    public JcmLogger(File file){
        logFile = file;
    }

    public void LogMessage(String message) throws IOException{
        try{
            if(!logFile.exists()) logFile.createNewFile();
            Files.write(Paths.get(logFile.getAbsolutePath()), (MESG_HEADER + message).getBytes(), StandardOpenOption.APPEND);
        } catch(IOException ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    public void LogWarning(String message) throws IOException{
        try{
            if(!logFile.exists()) logFile.createNewFile();
            Files.write(Paths.get(logFile.getAbsolutePath()), (WARN_HEADER + (new Date()).toString() + message).getBytes(), StandardOpenOption.APPEND);
        } catch(IOException ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    public void LogInfo(String message) throws IOException{
        try{
            if(!logFile.exists()) logFile.createNewFile();
            Files.write(Paths.get(logFile.getAbsolutePath()), (INFO_HEADER + (new Date()).toString() + message).getBytes(), StandardOpenOption.APPEND);
        } catch(IOException ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    public void LogError(String message) throws IOException{
        try{
            if(!logFile.exists()) logFile.createNewFile();
            Files.write(Paths.get(logFile.getAbsolutePath()), (ERR_HEADER + (new Date()).toString() +  message).getBytes(), StandardOpenOption.APPEND);
        } catch(IOException ex){
            ex.printStackTrace();
            throw ex;
        }
    }
}
