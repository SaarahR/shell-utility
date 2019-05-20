package Core;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shahlin
 */
public class Util {
    
    public Util() {
    
    }
    
    //RSS Reader; Gets daily quotes from BrainyQuote
    public String printQuote(String url){
        
        String quote = "";
        
        URL feedUrl = null;
        try {
            feedUrl = new URL(url);
        } catch (MalformedURLException ex) {
           System.out.println(ex);
        }
        
        SyndFeedInput input = new SyndFeedInput();
        try {
            HttpURLConnection conn = (HttpURLConnection) feedUrl.openConnection();
            SyndFeed feed = input.build(new XmlReader(conn));
            
            List entries = feed.getEntries();
            Iterator iter = entries.iterator();
            
            if(iter.hasNext()){
                SyndEntry entry = (SyndEntry) iter.next();
                quote += entry.getDescription().getValue();
                quote += "<br><br>- " + entry.getTitle();
            }
            
        } catch (FeedException | IOException | IllegalArgumentException ex) {
            System.out.println(ex);
        }
        
        return quote;
    }
    
    public int findStringOccurrence(String text, String find){
        int i = -1;
        
        if((i = text.indexOf(find, i + 1)) != -1){
            return i;
        }
        
        return -1;
    }
}
