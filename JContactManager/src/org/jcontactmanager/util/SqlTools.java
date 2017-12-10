package org.jcontactmanager.util;

public class SqlTools {
    /**
     * Sanitizes SQL query parameters by performing character-escaping
     * @param query Query to be sanitized
     * @return Sanitized query
     */
    public static String sanitizeQuery(String query){
        String sanitizedQuery = query
                        .replace("\"", "\\\"")
                        .replace("'","\\'")
                        .replace("%","\\%")
                        .replace("_", "\\_")
                        .replace("\b", "\\b")
                        .replace("\t","\\t")
                        .replaceAll("(?i)union", "");
        return sanitizedQuery;
    }
}
