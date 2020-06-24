package Shaman.Inc.demo;

import Shaman.Inc.demo.model.Region;
import Shaman.Inc.demo.model.data.RegionDao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScrapping {


    public Element Conexion() throws IOException {
        Document doc = Jsoup.connect("https://www.minsal.cl/nuevo-coronavirus-2019-ncov/casos-confirmados-en-chile-covid-19/").get();
        Element tabla = doc.select("table").get(0); //select the first table.
        Elements filas = tabla.select("tr");
        for (int i = 2; i < filas.size(); i++) { //first row is the col names so skip it.
            Element fila = filas.get(i);
            Elements columna = fila.select("td");
            System.out.println(columna.get(0).text());

        }
            return tabla;
        }



    public String webScappingActivos()throws IOException{
        Document doc = Jsoup.connect("https://www.minsal.cl/nuevo-coronavirus-2019-ncov/casos-confirmados-en-chile-covid-19/").get();
        Element tabla2 = doc.select("table").get(1); //select the first table.
        Elements filas2 = tabla2.select("tr");
        Element columna2 =filas2.select("td").get(1);
        return quitarPunto(columna2.text());
    }

    public void webScrapping( RegionDao regionDao) throws IOException {
        Document doc = Jsoup.connect("https://www.minsal.cl/nuevo-coronavirus-2019-ncov/casos-confirmados-en-chile-covid-19/").get();
        Element tabla = doc.select("table").get(0); //select the first table.
        Elements filas = tabla.select("tr");
        for (int i = 2; i < filas.size(); i++) { //first row is the col names so skip it.
            Element fila = filas.get(i);
            Elements columna = fila.select("td");
            Region act = regionDao.findByNombre(columna.get(0).text());
            act.setCasos_totales(quitarPunto(columna.get(1).text()));
            act.setCasos_nuevos_totales(quitarPunto(columna.get(2).text()));
            act.setCasos_nuevos_con_sintomas(quitarPunto(columna.get(3).text()));
            act.setCasos_nuevos_sin_sintomas(quitarPunto(columna.get(4).text()));
            act.setFallecidos(quitarPunto(columna.get(6).text()));
            act.setActivos(quitarPunto(columna.get(7).text()));
            regionDao.save(act);

        }
    }
    public String quitarPunto(String valor){
        String [] partes=valor.split("\\.");
        String valorFinal="";
        if(partes.length>0){
            for(int i=0;i<partes.length;i++){
                valorFinal=valorFinal+partes[i];
            }
            return valorFinal;
        }else {
            return valor;
        }
    }
}
