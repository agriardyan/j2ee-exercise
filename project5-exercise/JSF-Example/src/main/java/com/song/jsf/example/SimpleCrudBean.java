package com.song.jsf.example;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SimpleCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Book> list;
    private Book item = new Book();
    private Book beforeEditItem = null;
    private boolean edit;

    @PostConstruct
    public void init() {
        list = new ArrayList<Book>();
    }

    public void add() {
    	// DAO save the add
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new Book();
    }

    public void resetAdd() {
    	item = new Book();
    }

    public void edit(Book item) {
    	beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Book();
        edit = false;
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Book();
        edit = false;
    }

    public void delete(Book item) throws IOException {
    	// DAO save the delete
        list.remove(item);
    }

    public List<Book> getList() {
        return list;
    }

    public Book getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }

}