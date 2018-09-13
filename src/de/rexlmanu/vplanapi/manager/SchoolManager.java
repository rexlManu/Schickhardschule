package de.rexlmanu.vplanapi.manager;

import de.rexlmanu.vplanapi.entities.SchoolClass;
import de.rexlmanu.vplanapi.entities.SchoolHour;
import de.rexlmanu.vplanapi.entities.SchoolPlan;
import de.rexlmanu.vplanapi.utils.SecureWebsite;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SchoolManager {

    public SchoolManager() {

    }

    public SchoolPlan loadSchoolPlan(URL url){
        String content = new SecureWebsite(url).setAutication("9a", "9a@Schick").getContent();
        Document document = Jsoup.parse(content);
        Elements allElements = document.getAllElements();
        Elements meta = document.getElementsByTag("meta");
        Map<String, String> metas = new HashMap<>();
        for (Element metaTag : meta) {
            String contentx = metaTag.attr("content");
            String name = metaTag.attr("name");
            metas.put(name, contentx);
        }
        SchoolPlan schoolPlan = new SchoolPlan();
         AtomicReference<SchoolClass> schoolClass = null;
        AtomicInteger i = new AtomicInteger(1);
        for (Element element : allElements) {
            if (!element.is("tr")) {
                if(element.tagName().endsWith("td")){
                    if(element.text().length() == 2 || element.text().length() == 3){
                        schoolClass = new AtomicReference<>(new SchoolClass(element.text()));
                        //schoolClass.set();
                        schoolPlan.getClasses().put(schoolClass.get(), new ArrayList<>());
                        i.set(1);
                    }else{
                        if(schoolClass != null){

                            schoolPlan.getClasses().get(schoolClass.get()).add(new SchoolHour(i.get()+"", element.text()));
                            if(i.get() == 3 || i.get() == 8){
                                i.getAndIncrement();
                            }
                            i.getAndIncrement();
                        }
                    }
                }
            }
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        try {
            schoolPlan.setLastChangeAt(dateFormat.parse(metas.get("changed").replace("T", " ").replace("000000", "")).getTime());
            schoolPlan.setCreatedAt(dateFormat.parse(metas.get("created").replace("T", " ").replace("000000", "")).getTime());
        } catch (ParseException e) {
        }

        return schoolPlan;
    }

}
