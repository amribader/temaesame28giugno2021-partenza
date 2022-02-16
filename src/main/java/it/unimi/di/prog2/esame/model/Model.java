package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model implements Subject<List<Articolo>>{

    private final List<Observer<List<Articolo>>> observers = new ArrayList<>();
    private Map<String,Articolo> articoli = new HashMap<>();
    //private Map

    @Override
    public void notifyObservers() {
        for (Observer<List<Articolo>> observer : observers) {
            observer.update(this,new ArrayList<>(articoli.values()));
        }
    }

    @Override
    public void addObserver(Observer<List<Articolo>> obs) {
        observers.add(obs);
    }

    @Override
    public List<Articolo> getState() {
        return new ArrayList<>(articoli.values());
    }

    public void add(int i, String text) {
        assert !text.isEmpty() && i > 0;
        assert articoli.size() < Main.MAX_ALIMENTI;
        text = text.trim();
        //articolo nuovo
        if(!articoli.containsKey(text)){
            articoli.put(text,new Articolo(text,i,0));
            System.err.println("aggiungo nuovo elemento");
            notifyObservers();
        }else{
            articoli.put(text,new Articolo(text,articoli.get(text).getDaComprare()+i,articoli.get(text).getComprati()));

            System.err.println("aggiungo a elemento esistente");
            notifyObservers();
        }

        //se già essite lo aggiorno

        //altrimenti lo crea
    }

    public void buy(int id, String text) {//daComprare, comprati
        assert !text.isEmpty();
        assert articoli.containsKey(text);
        System.err.println(articoli);
        if (articoli.get(text).getDaComprare() > 0){
            articoli.put(text,new Articolo(
                    text,
                    articoli.get(text).getDaComprare()-1,
                    articoli.get(text).getComprati()+1)
            );
            notifyObservers();
        }
        System.err.println(articoli);
    }
}
