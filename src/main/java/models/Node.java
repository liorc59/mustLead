package models;


import java.util.Objects;

public class Node {
    private String name;
    private boolean isTraversed;


    public Node(String name){
        this.name = name;
        this.isTraversed = false;
    }

    public String getName(){
        return name;
    }

    public void setIsTraversed(boolean isTraversed){
        this.isTraversed = isTraversed;
    }

    public boolean getIsTraversed(){
        return isTraversed;
    }

    public boolean equals(Object toCompere){
        return this.getName().equals(((Node)toCompere).getName());
    }

    public int hashCode(){
        return Objects.hashCode(name);
    }

    public String toString(){
        return name;
    }



}
